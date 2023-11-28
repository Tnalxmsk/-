package racingcar.extension

import racingcar.model.User
import racingcar.model.Winner
import racingcar.model.car.Car
import racingcar.util.NumberGenerator

fun String.toCarList(): List<Car> {
    val input = this.split(",")
    return when (input.size) {
        1 -> listOf(Car(this))
        else -> input.map { name ->
            Car(name) }
    }
}

fun Car.decideMove() {
    when {
        NumberGenerator.getRandomNumber() < 4 -> stopMove()
        else -> moveForward()
    }
}

fun User.getLongDistance(): String {
    var longDistance = ""
    this.cars.forEach { car ->
        if (longDistance.length < car.getDistance().length)
            longDistance = car.getDistance()
    }
    return longDistance
}

fun Winner.getAllWinnerName(): String = this.winners.joinToString(", ") { it.name }