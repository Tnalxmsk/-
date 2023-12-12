package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readAmount(): Int {
        println(INPUT_READ_AMOUNT)
        val amount = Console.readLine()
        return amount.toInt()
    }


    companion object {
        private const val INPUT_READ_AMOUNT = "구입금액을 입력해 주세요."
    }
}