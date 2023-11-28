package racingcar.model.game

import racingcar.User
import racingcar.extension.toCarList
import racingcar.model.car.Car
import racingcar.view.InputView

class RacingGame(
    private val inputView: InputView
) : Game {
    override fun startGame() {
        val user = createUser()
    }

    private fun createUser(): User {
        val cars: List<Car> = inputView.readCarName().toCarList()
        return User(cars)
    }
}