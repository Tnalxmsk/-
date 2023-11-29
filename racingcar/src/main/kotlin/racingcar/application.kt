package racingcar

import racingcar.model.game.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    RacingGame(InputView(), OutputView()).startGame()
}