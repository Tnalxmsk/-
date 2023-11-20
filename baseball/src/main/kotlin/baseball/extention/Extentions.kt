package baseball.extention

import baseball.GameControl
import baseball.data.BaseballResult
import baseball.util.NumberConfig

private const val ALL_STRIKE = 3

fun BaseballResult.isAllStrike(): Boolean {
    return this.strike == ALL_STRIKE
}

fun String.toIntList(): List<Int> {
    return this.map { it.digitToInt() }
}

fun String.isValidNumbersRange(): Boolean =
    this.matches(Regex("[${NumberConfig.START_NUMBER}-${NumberConfig.LAST_NUMBER}]${NumberConfig.NUMBERS_SIZE}"))

fun String.isValidRestartInput(): Boolean =
    this.matches(Regex("[${GameControl.CONTINUE_GAME}-${GameControl.STOP_GAME}]"))