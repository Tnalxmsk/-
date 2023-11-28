package racingcar.view

import racingcar.model.User

class OutputView {
    fun printCarDistance(user: User) {
        for (car in user.cars) {
            println(CAR_DISTANCE_OUTPUT_VIEW.format(car.name, car.getDistance()))
        }
        println()
    }

    companion object {
        private const val CAR_DISTANCE_OUTPUT_VIEW = "%s : %s"
    }
}