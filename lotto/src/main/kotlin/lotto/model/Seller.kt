package lotto.model

import lotto.config.LottoRule
import lotto.util.NumberGenerator

class Seller {
    fun sellLotto(amount: Int, lottoRule: LottoRule): List<Lotto> {
        val lastCycle = amount / THOUSAND_AMOUNT
        return (1..lastCycle).map {
            Lotto(NumberGenerator.getNumbers(lottoRule))
        }
    }

    companion object {
        private const val THOUSAND_AMOUNT = 1000
    }
}