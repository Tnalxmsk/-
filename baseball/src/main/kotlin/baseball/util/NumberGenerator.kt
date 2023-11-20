package baseball.util

import baseball.data.BallNumber
import camp.nextstep.edu.missionutils.Randoms

object NumberGenerator {
    fun generateNumbers(): BallNumber {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return BallNumber(computer)
    }
}