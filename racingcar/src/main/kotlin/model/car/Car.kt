package model.car

class Car(val name: String) : Movement {
    private var distance = ""

    fun getDistance() = distance

    override fun moveForward() {
        distance += "-"
    }

    override fun stopMove() {
        distance += ""
    }
}
