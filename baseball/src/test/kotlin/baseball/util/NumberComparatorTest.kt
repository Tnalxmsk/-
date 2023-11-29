package baseball.util

import baseball.data.BallNumber
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class NumberComparatorTest {
    @Test
    fun `볼과 스트라이크가 제대로 저장되는지 확인`() {
        val user = BallNumber(listOf(1, 2, 3))
        val answer = BallNumber(listOf(2, 1, 3))
        val result = NumberComparator.compareNumbers(user, answer)
        assertThat(result.ball).isEqualTo(2)
        assertThat(result.strike).isEqualTo(1)
    }

    @Test
    fun `숫자 비교 후 같은 수가 하나도 없을 경우 볼과 스트라이크가 0인지 확인`() {
        val user = BallNumber(listOf(1, 2, 3))
        val answer = BallNumber(listOf(4, 5, 6))
        val result = NumberComparator.compareNumbers(user, answer)
        assertThat(result.ball).isEqualTo(0)
        assertThat(result.strike).isEqualTo(0)
    }

    @Test
    fun `스트라이크 결과만 누적되는지 확인`() {
        val user = BallNumber(listOf(1, 2, 3))
        val answer = BallNumber(listOf(1, 2, 6))
        val result = NumberComparator.compareNumbers(user, answer)
        assertThat(result.ball).isEqualTo(0)
        assertThat(result.strike).isEqualTo(2)
    }

    @Test
    fun `볼 결과만 누적되는지 확인`() {
        val user = BallNumber(listOf(1, 2, 3))
        val answer = BallNumber(listOf(2, 1, 6))
        val result = NumberComparator.compareNumbers(user, answer)
        assertThat(result.ball).isEqualTo(2)
        assertThat(result.strike).isEqualTo(0)
    }
}