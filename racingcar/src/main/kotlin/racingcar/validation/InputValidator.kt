package racingcar.validation

enum class InputValidator(val message: String) {
    EMPTY_INPUT("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요."),
    CONTAIN_GAP("[ERROR] 공백이 포함되어 있습니다. 다시 입력해 주세요."),
    OUT_RANGE_NAME("[ERROR] 1글자 이상 5자 이하의 이름만 가능합니다. 다시 입력해 주세요."),
    DUPLICATION_NAME("[ERROR] 중복된 이름이 존재합니다. 다시 입력해 주세요."),
    NOT_NUMBER_ROUND("[ERROR] 시도 횟수는 숫자만 입력 가능합니다. 다시 입력해 주세요."),
    OUT_RANGE_ROUND("[ERROR] 시도 횟수는 1부터 50까지 가능합니다. 다시 입력해 주세요.");

    companion object {
        fun validateName(input: String) {
            val nameChecker = NameChecker
            val error = when {
                input.isEmpty() -> EMPTY_INPUT
                nameChecker.hasGap(input) -> CONTAIN_GAP
                nameChecker.hasOutRange(input) -> OUT_RANGE_NAME
                nameChecker.hasDuplication(input) -> DUPLICATION_NAME
                else -> return
            }

            throw IllegalArgumentException(error.message)
        }

        fun validateTotalRound(input: String) {
            val error = when {
                input.isEmpty() -> EMPTY_INPUT
                input.contains("0") -> OUT_RANGE_ROUND
                input.contains(" ") -> CONTAIN_GAP
                !input.matches(Regex("\\d")) -> NOT_NUMBER_ROUND
                input.toInt() !in (1..50) -> OUT_RANGE_ROUND
                else -> return
            }
            throw IllegalArgumentException(error.message)
        }
    }
}