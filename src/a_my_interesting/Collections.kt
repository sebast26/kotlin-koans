package a_my_interesting

/**
 * convinient functions like maxBy, sortedBy
 * groupBy
 * easy partition
 *
 */

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

fun example5() {
    val result = listOf("a", "bbb", "cc").sortedBy { it.length }

    result == listOf("a", "cc", "bbb")
}

fun example7() {
    val result = listOf("a", "b", "ba", "ccc", "ad").groupBy { it.length }

    result == mapOf(1 to listOf("a", "b"), 2 to listOf("ba", "ad"), 3 to listOf("ccc"))
}

fun example8() {
    val numbers = listOf(1, 3, -4, 2, -11)

    // The details (how multi-assignment works) will be explained later in the 'Conventions' task
    val (positive, negative) = numbers.partition { it > 0 }

    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}
