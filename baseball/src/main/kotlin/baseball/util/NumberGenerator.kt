package baseball.util

import baseball.data.BallNumber
import camp.nextstep.edu.missionutils.Randoms

object NumberGenerator {
    fun generateNumbers(): BallNumber {
        val computer = mutableListOf<Int>()
        while (computer.size < NumberConfig.NUMBERS_SIZE.value) {
            val randomNumber = Randoms.pickNumberInRange(NumberConfig.START_NUMBER.value, NumberConfig.LAST_NUMBER.value)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return BallNumber(computer)
    }
}