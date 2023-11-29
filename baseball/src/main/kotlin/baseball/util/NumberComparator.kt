package baseball.util

import baseball.data.BallNumber
import baseball.data.BaseballResult

object NumberComparator {
    fun compareNumbers(player: BallNumber, computer: BallNumber): BaseballResult {
        val userNumbers = player.numbers
        val computerNumbers = computer.numbers
        var strike = 0
        var ball = 0
        repeat(player.numbers.size) {
            when {
                computerNumbers[it] == userNumbers[it] -> strike++
                computerNumbers.contains(userNumbers[it]) && computerNumbers.indexOf(userNumbers[it]) != it -> ball++
            }
        }
        return BaseballResult(ball, strike)
    }
}