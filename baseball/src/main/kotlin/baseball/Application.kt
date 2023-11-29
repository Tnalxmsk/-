package baseball

import baseball.view.InputView
import baseball.view.OutputView

fun main() {
    BaseballApp(InputView(), OutputView()).runBaseballGame()
}