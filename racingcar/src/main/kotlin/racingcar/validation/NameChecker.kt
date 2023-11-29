package racingcar.validation

object NameChecker {
    fun hasDuplication(input: String): Boolean {
        val names = input.split(",")
        return names.size != names.toSet().size
    }

    fun hasOutRange(input: String): Boolean {
        input.split(",").forEach { name ->
            if (name.length > 5 || name.isEmpty()) return true
        }
        return false
    }

    fun hasGap(input: String): Boolean {
        input.split(",").forEach { name ->
            if (name.contains(" ")) return true
        }
        return false
    }
}