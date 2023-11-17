package baseball.view

class OutputView {
    fun printStartView() {
        println(GAME_START_VIEW)
    }

    companion object {
        private const val GAME_START_VIEW = "숫자 야구 게임을 시작합니다."
    }
}