package lotto.view

import lotto.model.Lotto
import lotto.config.WinningResult

class OutputView {
    fun printPurchaseDetails(lottoBundle: List<Lotto>) {
        printPurchaseLottoSummary(lottoBundle)
        printPurchaseLottoNumbers(lottoBundle)
        println()
    }

    private fun printPurchaseLottoSummary(lottoBundle: List<Lotto>) =
        println(VIEW_PURCHASE_DETAILS.format(lottoBundle.size))

    private fun printPurchaseLottoNumbers(lottoBundle: List<Lotto>) {
        lottoBundle.forEach { println(it.getLottoNumber()) }
    }

    fun printWinningDetails(result: List<WinningResult>) {
        println(VIEW_DETAILS)
        WinningResult.entries.filter { it != WinningResult.FAIL }.forEach { winningResult ->
            val count = result.count { it == winningResult }
            println("${winningResult.text}${NUMBER_WINNING.format(count)}")
        }
    }

    fun printTotalProfit(profit: Double) {
        println(VIEW_TOTAL_PROFIT.format(profit))
    }

    companion object {
        private const val VIEW_PURCHASE_DETAILS = "%d개를 구매했습니다."
        private const val VIEW_TOTAL_PROFIT = "총 수익률은 %.1f%%입니다."
        private const val VIEW_DETAILS = "당첨 통계\n---"
        private const val NUMBER_WINNING = " - %d개"
    }
}