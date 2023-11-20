package baseball.validation

import baseball.GameControl
import baseball.extention.isValidNumbersRange
import baseball.extention.isValidRestartInput
import baseball.util.NumberConfig

enum class InputValidation(val message: String) {
    EMPTY_INPUT("값을 입력하지 않았습니다. 다시 입력해 주세요."),
    CONTAIN_GAP("공백이 포함되어 있습니다. 다시 입력해 주세요."),
    OUT_RANGE("1부터 9사이의 숫자만 입력 가능합니다. 다시 입력해 주세요."),
    INVALID_NUMBER("올바르지 않은 입력입니다. 다시 입력해 주세요."),
    DUPLICATION_NUMBER("중복된 숫자를 입력하였습니다. 다시 입력해 주세요.");

    companion object {
        fun validateInputNumber(input: String) {
            val error = when {
                input.isEmpty() -> EMPTY_INPUT
                input.contains(" ") -> CONTAIN_GAP
                !input.isValidNumbersRange() -> OUT_RANGE
                NumberValidator.hasOutOfRange(input) -> INVALID_NUMBER
                NumberValidator.hasDuplication(input) -> DUPLICATION_NUMBER
                else -> return
            }
            throw IllegalArgumentException("[ERROR] ${error.message}")
        }

        fun validateInputRestart(input: String) {
            val error = when {
                input.isEmpty() -> EMPTY_INPUT
                !input.isValidRestartInput() -> INVALID_NUMBER
                input.length != 1 -> INVALID_NUMBER
                else -> return
            }
            throw IllegalArgumentException("[ERROR] ${error.message}")
        }
    }
}