package baseball.extention

import baseball.data.BaseballResult

private const val ALL_STRIKE = 3

fun BaseballResult.isAllStrike(): Boolean {
    return this.strike == ALL_STRIKE
}

fun String.toIntList(): List<Int> {
    return this.map { it.digitToInt() }
}