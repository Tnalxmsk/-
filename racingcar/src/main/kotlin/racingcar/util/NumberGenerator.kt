package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object NumberGenerator {
    private const val START_NUMBER = 0
    private const val LAST_NUMBER = 0

    fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(START_NUMBER, LAST_NUMBER)
    }
}