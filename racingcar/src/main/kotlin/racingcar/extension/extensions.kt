package racingcar.extension

import racingcar.model.car.Car

fun String.toCarList(): List<Car> {
    val input = this.split(",")
    return when (input.size) {
        1 -> listOf(Car(this))
        else -> input.map { name ->
            Car(name) }
    }
}