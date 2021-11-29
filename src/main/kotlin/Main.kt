fun main() {
    val countSec = 85610

    val result = agoToText(countSec)
    println(result)
}

fun agoToText(countSec: Int): String {
    return when (countSec) {
        in 0..60 -> "был(а) только что"
        in 61..60 * 60 -> {
            val timeLast = countSec / 60
            val minutes = howMuchMinutes(timeLast)
            "был(а) $timeLast $minutes назад"
        }
        in 60 * 60 + 1..24 * 60 * 60 -> {
            val timeLast = countSec / (60 * 60)
            val hours = howMuchHours(timeLast)
            "был(а) $timeLast $hours назад"
        }
        in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "был(а) сегодня"
        in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "был(а) вчера"
        else -> "был(а) давно"
    }
}

fun howMuchMinutes(countMinutes: Int): String {
    return when (countMinutes) {
        1, 21, 31, 41, 51 -> "минуту"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "минуты"
        else -> "минут"
    }
}

fun howMuchHours(countHours: Int): Any {
    val countHoursStr = countHours.toString()
    val countMinutesLastChar = countHoursStr.substring(countHoursStr.length - 1, countHoursStr.length)

    return if (countHoursStr.length == 1) {
        when (countMinutesLastChar) {
            "1" -> "час"
            "2", "3", "4" -> "часа"
            else -> "часов"
        }
    } else {
        val countHoursStrTwoLastChar = countHoursStr.substring(countHoursStr.length - 2, countHoursStr.length)

        when (countMinutesLastChar) {
            "1" -> {
                if (countHoursStrTwoLastChar != "11") "час"
                else "часов"
            }
            "2", "3", "4" -> "часа"
            else -> "часов"
        }
    }
}