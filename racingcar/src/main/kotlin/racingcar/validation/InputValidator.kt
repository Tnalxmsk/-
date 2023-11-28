package racingcar.validation

enum class InputValidator(val message: String) {
    EMPTY_INPUT("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요."),
    CONTAIN_GAP("[ERROR] 공백이 포함되어 있습니다. 다시 입력해 주세요."),
    OUT_RANGE_NAME("[ERROR] 1글자 이상 5자 이하의 이름만 가능합니다. 다시 입력해 주세요."),
    DUPLICATION_NAME("[ERROR] 중복된 이름이 존재합니다. 다시 입력해 주세요.");

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
    }
}