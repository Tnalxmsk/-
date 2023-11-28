package racingcar.model.car

class Car(val name: String) : Movement {
    private var distance = ""

    fun getDistance() = distance

    override fun moveForward() {
        distance += "-"
    }

    override fun stopMove() {
        // 움직임을 멈추기 때문에 거리가 증가하지 않음
    }
}
