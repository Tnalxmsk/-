package lotto.extension

import lotto.model.Lotto

fun Lotto.isContainBonusNumber(bonusNumber: Int): Boolean {
    return this.getLottoNumber().contains(bonusNumber)
}