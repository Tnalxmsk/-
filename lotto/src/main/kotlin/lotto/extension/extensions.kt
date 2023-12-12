package lotto.extension

import lotto.config.LottoRule
import lotto.model.Lotto

fun Lotto.isContainBonusNumber(bonusNumber: Int): Boolean {
    return this.getLottoNumber().contains(bonusNumber)
}

fun List<String>.isNotLottoNumberFormat(lottoRule: LottoRule): Boolean {
    this.forEach {
        if (it.matches(Regex("\\d+")).not() || it.toInt() !in lottoRule.minNumber..lottoRule.maxNumber) {
            return true
        }
    }
    return false
}