package util

import camp.nextstep.edu.missionutils.Randoms

object NumberGenerator {
    fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}