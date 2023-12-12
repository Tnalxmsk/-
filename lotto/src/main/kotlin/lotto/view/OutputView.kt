package lotto.view

import lotto.model.Lotto

class OutputView {
    fun printPurchaseDetails(lottoBundle: List<Lotto>) {
        printPurchaseLottoSummary(lottoBundle)
        printPurchaseLottoNumbers(lottoBundle)
    }

    private fun printPurchaseLottoSummary(lottoBundle: List<Lotto>) =
        println(VIEW_PURCHASE_DETAILS.format(lottoBundle.size))

    private fun printPurchaseLottoNumbers(lottoBundle: List<Lotto>) {
        lottoBundle.forEach { println(it.getLottoNumber()) }
        println()
    }

    fun printTotalProfit(profit: Double) {
        println(VIEW_TOTAL_PROFIT.format(profit))
    }


    companion object {
        private const val VIEW_PURCHASE_DETAILS = "%d개를 구매했습니다."
        private const val VIEW_TOTAL_PROFIT = "총 수익률은 %.1f%%입니다."
    }
}