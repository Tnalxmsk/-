package baseball.validation

object NumberValidator {
    fun hasOutOfRange(input: String): Boolean {
        return input.length != 3
    }

    fun hasDuplication(input: String): Boolean {
        return input.length != input.toSet().size
    }
}