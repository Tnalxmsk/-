package racingcar.model.game

import racingcar.model.User
import racingcar.extension.toCarList
import racingcar.model.car.Car
import racingcar.util.NumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView
) : Game {
    override fun startGame() {
        val user = createUser()
        val round = inputView.readTotalRound()
        repeat(round) {
            startRound(user)
        }
    }

    private fun createUser(): User {
        val cars: List<Car> = inputView.readCarName().toCarList()
        return User(cars)
    }

    private fun startRound(user: User) {
        decideCarMove(user)
        outputView.printCarDistance(user)
    }

    private fun decideCarMove(user: User) {
        user.cars.map { car ->
            when {
                NumberGenerator.getRandomNumber() < 4 -> car.stopMove()
                else -> car.moveForward()
            }
        }
    }
}