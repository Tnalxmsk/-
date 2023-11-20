package baseball.view

import baseball.data.BallNumber
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readUserNumbers(): BallNumber {
        print(INPUT_VIEW)
        val numbers = Console.readLine()
        return BallNumber(numbers.map { it.digitToInt() })
    }

    companion object {
        private const val INPUT_VIEW = "숫자를 입력해주세요: "
    }
}