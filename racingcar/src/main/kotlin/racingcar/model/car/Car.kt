package racingcar.model.car

class Car(val name: String) : Movement {
    private var distance: String = DEFAULT_DISTANCE

    fun getDistance() = distance

    override fun moveForward() {
        distance += PLUS_DISTANCE
    }

    override fun stopMove() {
        // 움직임을 멈추기 때문에 거리가 증가하지 않음
    }

    companion object {
        private const val DEFAULT_DISTANCE = ""
        private const val PLUS_DISTANCE = "-"
    }
}
