package lotto.model

import lotto.config.LottoRule
import lotto.util.NumberGenerator

class Seller {
    fun sellLotto(amount: Int, lottoRule: LottoRule): List<Lotto> {
        val lottoBundle = mutableListOf<Lotto>()
        for (i in 1..amount/1000) {
            lottoBundle.add(Lotto(NumberGenerator.getNumbers(lottoRule)))
        }
        return lottoBundle
    }
}