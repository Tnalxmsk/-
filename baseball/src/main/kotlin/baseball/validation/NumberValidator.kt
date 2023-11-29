package baseball.validation

import baseball.util.NumberConfig

object NumberValidator {
    fun hasOutOfRange(input: String): Boolean {
        return input.length != NumberConfig.NUMBERS_SIZE.value
    }

    fun hasDuplication(input: String): Boolean {
        return input.length != input.toSet().size
    }
}