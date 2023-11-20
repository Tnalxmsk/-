package baseball

import baseball.data.BallNumber
import baseball.data.BaseballResult
import baseball.data.Computer
import baseball.data.Player
import baseball.util.NumberComparator
import baseball.util.NumberGenerator
import baseball.view.InputView
import baseball.view.OutputView

class BaseballApp(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun runBaseballGame() {
        outputView.printStartView()
        while (true) {
            controlGame()
            when(inputView.readRestart()) {
                RESTART -> continue
                STOP -> return
            }
        }
    }

    private fun applyAnswerNumber() : Computer {
        val answerNumber = BallNumber(NumberGenerator.generateNumbers())
        return Computer(answerNumber)
    }

    private fun controlGame() {
        val computer = applyAnswerNumber()
        while (true) {
            val player = Player(inputView.readUserNumbers())
            val result = NumberComparator.compareNumbers(player.playerNumber, computer.computerNumber)
            outputView.printGameResult(result)
            if (isAllStrike(result)) return
        }
    }

    private fun isAllStrike(result: BaseballResult): Boolean {
        return result.strike == ALL_STRIKE
    }

    companion object {
        private const val ALL_STRIKE = 3
        private const val STOP = 2
        private const val RESTART = 1
    }
}