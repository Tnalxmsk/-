package lotto.model

import lotto.config.WinningResult
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
        val matchingNumbersCount = getContainNumbers(lotto).size
        return WinningResult.entries.firstOrNull {
            it.isWinning(
                matchingNumbersCount,
                it == WinningResult.SECOND && lotto.isContainBonusNumber(bonusNumber)
            )
        } ?: WinningResult.FAIL
    }
}