package racingcar.model.game

import racingcar.extension.decideMove
import racingcar.extension.getLongDistance
import racingcar.model.User
import racingcar.extension.toCarList
import racingcar.model.Winner
import racingcar.model.car.Car
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView
) : Game {
    override fun startGame() {
        val user = createUser()
        val round = inputView.readTotalRound()

        repeat(round) { startRound(user) }

        val winner = findWinner(user)
        outputView.printGameWinner(winner)
    }

    private fun createUser(): User {
        val cars: List<Car> = inputView.readCarName().toCarList()
        return User(cars)
    }

    private fun startRound(user: User) {
        moveAllCars(user)
        outputView.printCarDistance(user)
    }

    private fun moveAllCars(user: User) = user.cars.forEach { it.decideMove() }

    private fun findWinner(user: User): Winner {
        val longDistance: String = user.getLongDistance()
        val winners = user.cars.filter { it.getDistance().length == longDistance.length }
        return Winner(winners)
    }
}