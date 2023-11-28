package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCarName(): String {
        val names = Console.readLine()
        return names
    }
}