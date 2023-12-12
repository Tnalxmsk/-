package lotto.model.game

import lotto.model.Player
import lotto.model.Referee
import lotto.model.Seller
import lotto.model.WinningResult
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame : Game {
    private val inputView = InputView()
    private val outputView = OutputView()

    override fun startGame() {
        val seller = Seller()
        val amount = inputView.readAmount()
        val lottoBundle = seller.sellLotto(amount)
        outputView.printPurchaseDetails(lottoBundle)

        val player = Player(amount, lottoBundle)
        val referee = createReferee()

        startComparing(player, referee)
    }

    private fun createReferee(): Referee {
        val winningNumber = inputView.readWinningNumber()
        println()
        val bonusNumber = inputView.readBonusNumber()
        return Referee(winningNumber, bonusNumber)
    }

    private fun startComparing(player: Player, referee: Referee) {
        val result = player.lottoBundle.map {
            referee.judeWinning(it)
        }
        val profit = calculateProfit(calculatePrizeAmount(result), player.spendingAmount)
        outputView.printTotalProfit(profit)

    }

    private fun calculatePrizeAmount(result: List<WinningResult>) = result.sumOf { it.prizeAmount }

    private fun calculateProfit(prizeAmount: Int, spendingAmount: Int): Double {
        return prizeAmount.toDouble() / spendingAmount.toDouble() * 100.0
    }
}