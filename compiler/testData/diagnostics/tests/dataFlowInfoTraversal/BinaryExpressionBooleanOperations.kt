// !CHECK_TYPE
// !WITH_NEW_INFERENCE

fun foo1(x: Number, cond: Boolean): Boolean {
    val result = cond && ((x as Int) == 42)
    checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!>)
    return result
}

fun foo2(x: Number, cond: Boolean): Boolean {
    val result = ((x as Int) == 42) && cond
    checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
    return result
}

fun foo3(x: Number, cond: Boolean): Boolean {
    val result = cond || ((x as Int) == 42)
    checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!>)
    return result
}

fun foo4(x: Number, cond: Boolean): Boolean {
    val result = ((x as Int) == 42) || cond
    checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
    return result
}
