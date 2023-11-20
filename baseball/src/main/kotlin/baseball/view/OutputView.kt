package baseball.view

import baseball.data.BaseballResult

class OutputView {
    fun printIntro() = println(GAME_START_VIEW)

    fun printGameResult(result: BaseballResult) {
        when {
            result.ball == NONE && result.strike == NONE -> println(NOTHING)
            result.ball == NONE -> println(STRIKE.format(result.strike))
            result.strike == NONE -> println(BALL.format(result.ball))
            else -> println("${BALL.format(result.ball)} ${STRIKE.format(result.strike)}")
        }
    }

    companion object {
        private const val NONE = 0
        private const val GAME_START_VIEW = "숫자 야구 게임을 시작합니다."
        private const val STRIKE = "%d스트라이크"
        private const val BALL = "%d볼"
        private const val NOTHING = "낫싱"
    }
}