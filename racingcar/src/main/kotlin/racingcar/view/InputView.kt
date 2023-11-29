package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.validation.InputValidator

class InputView {
    private val inputValidator = InputValidator

    fun readCarName(): String {
        println(CAR_NAME_INPUT_VIEW)
        while (true) {
            try {
                val names = Console.readLine()
                inputValidator.validateName(names)
                return names
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readTotalRound(): Int {
        println(TOTAL_ROUND_INPUT_VIEW)
        while (true) {
            try {
                val totalRound = Console.readLine()
                inputValidator.validateTotalRound(totalRound)
                return totalRound.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    companion object {
        private const val CAR_NAME_INPUT_VIEW = "경주할 자동차 이름을 입력하세요.(이름은 쉼포(,) 기준으로 구분)"
        private const val TOTAL_ROUND_INPUT_VIEW = "시도할 횟수는 몇 회인가요?"
    }
}