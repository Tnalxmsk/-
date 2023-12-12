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


    companion object {
        private const val VIEW_PURCHASE_DETAILS = "%d개를 구매했습니다."
    }
}