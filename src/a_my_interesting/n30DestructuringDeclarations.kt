package a_my_interesting

class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

fun isLeapDay(date: MyDate): Boolean {
    val (year, month, dayOfMonth) = date

    // 29 February of a leap year
    return year % 4 == 0 && month == 2 && dayOfMonth == 29
}

private operator fun MyDate.component3(): Int {
    return dayOfMonth
}

private operator fun MyDate.component2(): Int {
    return month
}

private operator fun MyDate.component1(): Int {
    return year
}
