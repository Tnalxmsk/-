package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.validation.InputValidator

class InputView {
    fun readAmount(): Int {
        try {
            println(INPUT_READ_AMOUNT)
            val amount = Console.readLine()
            InputValidator.validCommonElement(amount)
            InputValidator.validateAmount(amount)
            println()
            return amount.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return readAmount()
        }
    }

    fun readWinningNumber(): Lotto {
        try {
            println(INPUT_WINNING_NUMBER)
            val input = Console.readLine()
            InputValidator.validCommonElement(input)
            InputValidator.validateLottoNumber(input)
            val numbers = input.split(",")
            println()
            return Lotto(numbers.map { it.toInt() })
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return readWinningNumber()
        }
    }

    fun readBonusNumber(): Int {
        try {
            println(INPUT_BONUS_NUMBER)
            val bonusNumber = Console.readLine()
            InputValidator.validCommonElement(bonusNumber)
            InputValidator.validateBonusNumber(bonusNumber)
            println()
            return bonusNumber.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return readBonusNumber()
        }
    }

    companion object {
        private const val INPUT_READ_AMOUNT = "구입금액을 입력해 주세요."
        private const val INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    }
}