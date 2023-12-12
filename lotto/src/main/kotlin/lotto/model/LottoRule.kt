package lotto.model

enum class LottoRule(val minNumber: Int, val maxNumber: Int, val numbersPerLotto: Int) {
    STANDARD(1, 45, 6)
}