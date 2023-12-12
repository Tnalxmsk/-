package lotto.model

import lotto.extension.isContainBonusNumber

class Referee(
    private val winningNumber: Lotto,
    private val bonusNumber: Int
) {
    private fun getContainNumbers(lotto: Lotto): List<Int> {
        val userWinningNumbers = lotto.getLottoNumber().filter { winningNumber.getLottoNumber().contains(it) }
        return userWinningNumbers
    }

    fun judeWinning(lotto: Lotto): WinningResult {
        val size = getContainNumbers(lotto).size
        return when {
            size == 6 -> WinningResult.FIRST
            size == 5 && lotto.isContainBonusNumber(bonusNumber) -> WinningResult.SECOND
            size == 5 -> WinningResult.THIRD
            size == 4 -> WinningResult.FORTH
            size == 3 -> WinningResult.FIFTH
            else -> WinningResult.FAIL
        }
    }
}