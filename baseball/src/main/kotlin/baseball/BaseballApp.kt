package baseball

import baseball.data.BallNumber
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
        var computer = controlAnswerNumber()
        var gameController = true
        while (gameController) {
            gameController = controlGame(computer)
            computer = controlAnswerNumber()
        }
    }

    private fun controlAnswerNumber() : Computer {
        val answerNumber = BallNumber(NumberGenerator.generateNumbers())
        return Computer(answerNumber)
    }

    private fun controlGame(computer: Computer) : Boolean {
        println(computer.computerNumber)
        val player = Player(inputView.readUserNumbers())
        val result = NumberComparator.compareNumbers(player.playerNumber, computer.computerNumber)
        outputView.printGameResult(result)
        return controlRestart(result.strike)
    }

    private fun controlRestart(strike: Int) : Boolean {
        if (strike == 3) {
            return inputView.readRestart() == 1
        }
        return true
    }
}