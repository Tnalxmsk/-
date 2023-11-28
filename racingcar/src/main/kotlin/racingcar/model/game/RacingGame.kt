package racingcar.model.game

import racingcar.extension.getLongDistance
import racingcar.model.User
import racingcar.extension.toCarList
import racingcar.model.Winner
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
        val winner = decideWinner(user)
        outputView.printGameWinner(winner)
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

    private fun decideWinner(user: User): Winner {
        val longDistance: String = user.getLongDistance()
        val winners = user.cars.filter { car ->
            longDistance.length == car.getDistance().length
        }
        return Winner(winners)
    }
}