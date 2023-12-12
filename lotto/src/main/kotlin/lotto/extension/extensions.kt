package lotto.extension

import lotto.model.Lotto

fun Lotto.isContainBonusNumber(bonusNumber: Int): Boolean {
    return this.getLottoNumber().contains(bonusNumber)
}

fun List<String>.isNotLottoNumberFormat(): Boolean {
    this.forEach {
        if (it.matches(Regex("\\d")).not() || (1..45).contains(it.toInt()).not()) {
            return true
        }
    }
    return false
}