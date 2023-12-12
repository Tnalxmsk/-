package lotto.model.game

import lotto.model.Player
import lotto.model.Referee
import lotto.model.Seller
import lotto.model.WinningResult
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val seller: Seller
) : Game {
    override fun startGame() {
        val amount = inputView.readAmount()
        val lottoBundle = seller.sellLotto(amount)
        outputView.printPurchaseDetails(lottoBundle)

        val player = Player(amount, lottoBundle)
        val referee = createReferee()

        val result = compareLottoWithWinningNumbers(player, referee)
        val profit = calculateProfit(calculatePrizeAmount(result), player.spendingAmount)

        outputView.printWinningDetails(result)
        outputView.printTotalProfit(profit)
    }

    private fun createReferee(): Referee {
        val winningNumber = inputView.readWinningNumber()
        val bonusNumber = inputView.readBonusNumber()
        return Referee(winningNumber, bonusNumber)
    }

    private fun compareLottoWithWinningNumbers(player: Player, referee: Referee): List<WinningResult> {
        val result = player.lottoBundle.map {
            referee.judeWinning(it)
        }
        return result
    }

    private fun calculatePrizeAmount(result: List<WinningResult>) = result.sumOf { it.prizeAmount }

    private fun calculateProfit(prizeAmount: Int, spendingAmount: Int): Double {
        return prizeAmount.toDouble() / spendingAmount.toDouble() * HUNDRED_PERCENT
    }

    companion object {
        private const val HUNDRED_PERCENT = 100.0
    }

}