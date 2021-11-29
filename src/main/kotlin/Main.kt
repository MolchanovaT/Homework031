fun main() {
    val countSec = 1010

    val result = agoToText(countSec)
    println(result)
}

fun agoToText(countSec: Int): String {
    return when (countSec) {
        in 0..60 -> "был(а) только что"
        in 61..60 * 60 -> {
            howMuchMinutes(countSec)
        }
        in 60 * 60 + 1..24 * 60 * 60 -> {
            howMuchHours(countSec)
        }
        in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "был(а) сегодня"
        in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "был(а) вчера"
        else -> "был(а) давно"
    }
}

fun howMuchMinutes(countSec: Int): String {
    val countMinutes = countSec / 60
    val minutesStr =  when {
        (countMinutes == 1 || countMinutes % 10 == 1) && countMinutes != 11 -> "минуту"
        (countMinutes % 10 in 2..4) && (countMinutes !in 12..14) -> "минуты"
        else -> "минут"
    }
    return "был(а) $countMinutes $minutesStr назад"
}

fun howMuchHours(countSec: Int): String {
    val countHours = countSec / (60 * 60)
    val countHoursStr = countHours.toString()
    val countMinutesLastChar = countHoursStr.substring(countHoursStr.length - 1, countHoursStr.length)

    val hoursStr = if (countHoursStr.length == 1) {
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
    return "был(а) $countHours $hoursStr назад"
}