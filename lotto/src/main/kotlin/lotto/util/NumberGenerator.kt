package lotto.util

import camp.nextstep.edu.missionutils.Randoms

object NumberGenerator {
    fun getNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers
    }
}