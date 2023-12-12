package lotto.validation

import lotto.extension.isNotLottoNumberFormat

enum class InputValidator(val message: String) {
    INVALID_AMOUNT("[ERROR] 입력 금액은 천원 단위로 입력하셔야 합니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자만 입력 가능합니다. 다시 입력해 주세요."),
    UNDER_ONE_THOUSAND("[ERROR] 금액은 천원 이상 입력하셔야 합니다."),
    INVALID_LOTTO_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_SIZE("[ERROR] 당첨 번호 갯수는 6개여야 합니다."),
    DUPLICATION_LOTTO_NUMBER("[ERROR] 로또 번호가 중복되었습니다. 다시 입력해 주세요."),
    INVALID_BONUS_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    EMPTY_NUMBER("[ERROR] 값을 입력하지 않았습니다. 다시 입력해 주세요."),
    CONTAIN_GAP("[ERROR] 공백이 포함되어 있습니다. 다시 입력해 주세요.");


    companion object {

        fun validCommonElement(input: String) {
            val error = when {
                input.isEmpty() -> EMPTY_NUMBER
                input.contains(" ") -> CONTAIN_GAP
                else -> return
            }
            throw IllegalArgumentException(error.message)
        }
        fun validateAmount(amount: String) {
            val error = when {
                amount.matches(Regex("\\d+")).not() -> INVALID_NUMBER_FORMAT
                amount.toInt() < 1000 -> UNDER_ONE_THOUSAND
                amount.toInt() % 1000 != 0 -> INVALID_AMOUNT
                else -> return
            }
            throw IllegalArgumentException(error.message)
        }

        fun validateLottoNumber(input: String) {
            val numbers = input.split(",")
            val error = when {
                numbers.isNotLottoNumberFormat() -> INVALID_LOTTO_NUMBER
                numbers.size != 6 -> INVALID_LOTTO_NUMBER_SIZE
                numbers.size != numbers.toSet().size -> DUPLICATION_LOTTO_NUMBER
                else -> return
            }
            throw IllegalArgumentException(error.message)
        }

        fun validateBonusNumber(number: String) {
            val error = when {
                number.matches(Regex("\\d+")).not() -> INVALID_NUMBER_FORMAT
                (1..45).contains(number.toInt()).not() -> INVALID_BONUS_NUMBER
                else -> return
            }
            throw IllegalArgumentException(error.message)
        }
    }
}