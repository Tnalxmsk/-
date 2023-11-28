package racingcar.validation

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class InputValidatorTest {
    @Test
    fun `이름을 아무 것도 입력하지 않았을 때 예외를 던진다`() {
        val input = ""
        assertThrows<IllegalArgumentException> { InputValidator.validateName(input) }
    }

    @Test
    fun `이름에 공백이 포함되어 있을 경우 예외를 던진다`() {
        val input = "pobi,woni,na se"
        assertThrows<IllegalArgumentException> { InputValidator.validateName(input) }
    }

    @Test
    fun `중복된 이름이 존재할 경우 예외를 던진다`() {
        val input = "pobi,woni,pobi"
        assertThrows<IllegalArgumentException> { InputValidator.validateName(input) }
    }

    @Test
    fun `5글자를 초과하는 이름이 존재할 경우 예외를 던진다`() {
        val input = "pobi,woni,muldaeng"
        assertThrows<IllegalArgumentException> { InputValidator.validateName(input) }
    }

    @Test
    fun `입력한 이름 중 아무 값도 입력되지 않은 이름이 존재할 경우 예외를 던진다`() {
        val input = "pobi,,woni"
        assertThrows<IllegalArgumentException> { InputValidator.validateName(input) }
    }
}