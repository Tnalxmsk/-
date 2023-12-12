package lotto.model

import lotto.config.LottoRule

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoRule.STANDARD.numbersPerLotto)
    }

    fun getLottoNumber() = numbers.sorted()
}
