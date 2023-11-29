package racingcar.view

import racingcar.extension.getAllWinnerName
import racingcar.model.User
import racingcar.model.Winner

class OutputView {
    fun printCarDistance(user: User) {
        for (car in user.cars) {
            println(CAR_DISTANCE_OUTPUT_VIEW.format(car.name, car.getDistance()))
        }
        println()
    }

    fun printGameWinner(winner: Winner) {
        println(RACING_WINNER_OUTPUT_VIEW.format(winner.getAllWinnerName()))
    }

    companion object {
        private const val CAR_DISTANCE_OUTPUT_VIEW = "%s : %s"
        private const val RACING_WINNER_OUTPUT_VIEW = "최종 우승자 : %s"
    }
}