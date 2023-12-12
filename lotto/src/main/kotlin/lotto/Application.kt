package lotto

import lotto.config.LottoRule
import lotto.model.Seller
import lotto.model.game.LottoGame
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val seller = Seller()
    val lottoGame = LottoGame(inputView, outputView, seller, LottoRule.STANDARD)

    lottoGame.startGame()
}