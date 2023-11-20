package baseball.view

import baseball.data.BallNumber
import baseball.extention.toIntList
import baseball.validation.InputValidation
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readUserNumbers(): BallNumber {
        while (true) {
            try {
                print(INPUT_VIEW)
                val numbers = Console.readLine()
                InputValidation.validateInputNumber(numbers)
                return BallNumber(numbers.toIntList())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readRestart() : Int {
        println(ALL_CORRECT)
        while (true) {
            try {
                println(INPUT_RESTART)
                val number = Console.readLine()
                InputValidation.validateInputRestart(number)
                return number.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    companion object {
        private const val INPUT_VIEW = "숫자를 입력해주세요: "
        private const val ALL_CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        private const val INPUT_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    }
}