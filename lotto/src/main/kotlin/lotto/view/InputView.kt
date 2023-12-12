package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto

class InputView {
    fun readAmount(): Int {
        println(INPUT_READ_AMOUNT)
        val amount = Console.readLine()
        println()
        return amount.toInt()
    }

    fun readWinningNumber(): Lotto {
        println(INPUT_WINNING_NUMBER)
        val input = Console.readLine()
        val numbers = input.split(",")
        println()
        return Lotto(numbers.map { it.toInt() })
    }

    fun readBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER)
        val bonusNumber = Console.readLine()
        println()
        return bonusNumber.toInt()
    }

    companion object {
        private const val INPUT_READ_AMOUNT = "구입금액을 입력해 주세요."
        private const val INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    }
}