// !DIAGNOSTICS: -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE

var count = 0

operator fun Int.get(s: Int): Int {
    count++
    return this + s
}

operator fun Int.set(s: Int, x: String = "", z: Int) {
}

fun main(args: Array<String>) {
    1[2] = 1
    1.set(2, z = 1)
    1[2] += 1

    1.set(2, <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!><!NI;NO_VALUE_FOR_PARAMETER!><!NO_VALUE_FOR_PARAMETER!>)<!><!>
}
