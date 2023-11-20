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
        val answerNumber = BallNumber(NumberGenerator.generateNumbers())
        val computer = Computer(answerNumber)

        val player = Player(inputView.readUserNumbers())

        val result = NumberComparator.compareNumbers(player.playerNumber, computer.computerNumber)
        outputView.printGameResult(result)
    }
}