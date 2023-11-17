package baseball

import baseball.view.InputView
import baseball.view.OutputView

class BaseballApp(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun runBaseballGame() {
        outputView.printStartView()
        val player = Player(inputView.readUserNumbers())
    }
}