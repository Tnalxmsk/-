package baseball

import baseball.data.Computer
import baseball.data.Player
import baseball.extention.isAllStrike
import baseball.util.NumberComparator
import baseball.util.NumberGenerator
import baseball.view.InputView
import baseball.view.OutputView

class BaseballApp(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun runBaseballGame() {
        outputView.printIntro()
        while (true) {
            controlGame()
            when(inputView.readRestart()) {
                GameControl.CONTINUE_GAME.value -> continue
                GameControl.STOP_GAME.value -> return
            }
        }
    }

    private fun controlGame() {
        val computer = Computer(NumberGenerator.generateNumbers())
        while (true) {
            val player = Player(inputView.readUserNumbers())
            val result = NumberComparator.compareNumbers(player.playerNumber, computer.computerNumber)
            outputView.printGameResult(result)
            if (result.isAllStrike()) return
        }
    }
}