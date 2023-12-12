package lotto.model.game

import lotto.model.Player
import lotto.model.Seller
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame : Game {
    private val inputView = InputView()
    private val outputView = OutputView()

    override fun startGame() {
        val seller = Seller()
        val amount = inputView.readAmount()
        val lottoBundle = seller.sellLotto(amount)
    }
}