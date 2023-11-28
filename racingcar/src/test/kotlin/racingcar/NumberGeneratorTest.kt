package racingcar

import org.assertj.core.api.Assertions.assertThat
import util.NumberGenerator
import kotlin.test.Test

class NumberGeneratorTest {
    @Test
    fun `0부터 9사이의 무작위 숫자를 반환하는지 확인한다`() {
        val numbers = (0..9)
        assertThat(numbers.contains(NumberGenerator.getRandomNumber())).isEqualTo(true)
    }
}