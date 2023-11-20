package baseball.view

import baseball.data.BaseballResult

class OutputView {
    fun printStartView() = println(GAME_START_VIEW)

    fun printGameResult(result: BaseballResult) {
        when {
            result.ball == 0 && result.strike == 0 -> println(NOTHING)
            result.ball == 0 -> println(STRIKE.format(result.strike))
            result.strike == 0 -> println(BALL.format(result.ball))
            else -> println("${BALL.format(result.ball)} ${STRIKE.format(result.strike)}")
        }
    }

    companion object {
        private const val GAME_START_VIEW = "숫자 야구 게임을 시작합니다."
        private const val STRIKE = "%d스트라이크"
        private const val BALL = "%d볼"
        private const val NOTHING = "낫싱"
    }
}