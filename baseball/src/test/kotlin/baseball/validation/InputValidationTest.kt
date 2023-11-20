package baseball.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidationTest {
    @Test
    fun `숫자 대신 아무 값을 입력하지 않았을 때 예외를 던짐`() {
        assertThrows<IllegalArgumentException> { InputValidation.validateInputRestart("") }
    }

    @Test
    fun `숫자 대신 문자를 입력하였을 때 예외를 던짐`() {
        assertThrows<IllegalArgumentException> { InputValidation.validateInputNumber("a23") }
    }

    @Test
    fun `3자리 숫자 범위를 벗어났을 시 예외를 던짐`() {
        assertThrows<IllegalArgumentException> { InputValidation.validateInputNumber("1234") }
    }

    @Test
    fun `숫자에 공백이 포함되어 있을 시 예외를 던짐`() {
        assertThrows<IllegalArgumentException> { InputValidation.validateInputNumber("1 34") }
    }

    @Test
    fun `입력한 숫자가 중복되었을 경우 예외를 던짐`() {
        assertThrows<IllegalArgumentException> { InputValidation.validateInputNumber("334") }
    }

    @Test
    fun `재시작 입력 값을 문자로 입력하였을 시 예외를 던짐`() {
        assertThrows<IllegalArgumentException> { InputValidation.validateInputRestart("a") }
    }

    @Test
    fun `재시작 입력 값이 1이나 2가 아닐 경우 예외를 던짐`() {
        assertThrows<IllegalArgumentException> { InputValidation.validateInputRestart("3") }
    }
}