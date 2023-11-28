package model.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.car.Car

class CarTest {
    @Test
    fun `차가 움직이면 거리가 저장된다`() {
        val car = Car("부릉부릉")
        car.moveForward()
        car.moveForward()
        assertThat(car.getDistance()).isEqualTo("--")
    }

    @Test
    fun `차가 전진, 스탑, 전진 후에 거리가 저장되는지 확인한다`() {
        val car = Car("부르릉")
        car.moveForward()
        car.stopMove()
        car.moveForward()
        assertThat(car.getDistance()).isEqualTo("--")
    }

    @Test
    fun `차가 계속 멈춰 있을 때 거리에 변화가 없는지 확인한다`() {
        val car = Car("부릉")
        car.stopMove()
        car.stopMove()
        assertThat(car.getDistance()).isEqualTo("")
    }
}