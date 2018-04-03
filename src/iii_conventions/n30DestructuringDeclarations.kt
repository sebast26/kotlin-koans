package iii_conventions.multiAssignemnt

import a_my_interesting.MyDate
import util.TODO
import util.doc30

fun todoTask30(): Nothing = TODO(
    """
        Task 30.
        Read about destructuring declarations and make the following code compile by adding one 'data' modifier.
    """,
    documentation = doc30()
)

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
