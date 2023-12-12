package lotto.util

import camp.nextstep.edu.missionutils.Randoms
import lotto.config.LottoRule

object NumberGenerator {
    fun getNumbers(lottoRule: LottoRule): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(
            lottoRule.minNumber,
            lottoRule.maxNumber,
            lottoRule.numbersPerLotto
        )
        return numbers
    }
}