package racingcar.model.game

import racingcar.User
import racingcar.extension.toCarList
import racingcar.model.car.Car
import racingcar.util.NumberGenerator
import racingcar.view.InputView

class RacingGame(
    private val inputView: InputView
) : Game {
    override fun startGame() {
        val user = createUser()
        val round = inputView.readTotalRound()
        startRound(user)
    }

    private fun createUser(): User {
        val cars: List<Car> = inputView.readCarName().toCarList()
        return User(cars)
    }

    private fun startRound(user: User) {
        decideCarMove(user)
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