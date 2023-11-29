package racingcar.validation

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class InputRoundValidatorTest {
    @Test
    fun `아무 것도 입력하지 않았을 시 예외를 던진다`() {
        val input = ""
        assertThrows<IllegalArgumentException> { InputValidator.validateTotalRound(input) }
    }

    @Test
    fun `문자를 입력하였을 때 예외를 던진다`() {
        val input = "a"
        assertThrows<IllegalArgumentException> { InputValidator.validateTotalRound(input) }
    }

    @Test
    fun `문자가 포함되어 있을 때 예외를 던진다`() {
        val input = "14a"
        assertThrows<IllegalArgumentException> { InputValidator.validateTotalRound(input) }
    }

    @Test
    fun `0을 입력하였을 때 예외를 던진다`() {
        val input = "0"
        assertThrows<IllegalArgumentException> { InputValidator.validateTotalRound(input) }
    }

    @Test
    fun `입력한 값이 50을 초과하였을 때 예외를 던진다`() {
        val input = "51"
        assertThrows<IllegalArgumentException> { InputValidator.validateTotalRound(input) }
    }

    @Test
    fun `입력한 값에 공백이 포함되어 있을 경우 예외를 던진다`() {
        val input = "14 "
        assertThrows<IllegalArgumentException> { InputValidator.validateTotalRound(input) }
    }
}