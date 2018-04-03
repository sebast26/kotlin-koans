package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

operator fun MyDate.compareTo(other: MyDate): Int {
    val (yearDiff, monthDiff, dayDiff) = listOf(this.year - other.year, this.month - other.month, this.dayOfMonth - other.dayOfMonth)
    if (yearDiff != 0) return yearDiff / Math.abs(yearDiff)
    if (monthDiff != 0) return monthDiff / Math.abs(monthDiff)
    if (dayDiff != 0) return dayDiff / Math.abs(dayDiff) else return dayDiff
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

operator fun MyDate.plus(interval: TimeInterval): MyDate {
    return this.addTimeIntervals(interval, 1)
}

operator fun MyDate.plus(interval: CustomInterval): MyDate {
    return this.addTimeIntervals(interval.interval, interval.number)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class CustomInterval(val interval: TimeInterval, val number: Int)

operator fun TimeInterval.times(number: Int): CustomInterval {
    return CustomInterval(this, number)
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    var current = start

    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            override fun hasNext(): Boolean {
                return current in start..endInclusive
            }

            override fun next(): MyDate {
                val retVal = current
                current = current.nextDay()
                return retVal
            }
        }
    }
}

operator fun DateRange.contains(date: MyDate): Boolean {
    return date >= this.start && date <= this.endInclusive
}


