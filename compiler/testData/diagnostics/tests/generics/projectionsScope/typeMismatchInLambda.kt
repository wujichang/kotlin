// !DIAGNOSTICS: -UNUSED_PARAMETER -UNUSED_VARIABLE
// !WITH_NEW_INFERENCE

class Out<out T> {
    fun id() = this
    fun foobar(x: Any) {}
}

class A<E> {
    inline fun foo(block: () -> E) {}
    inline fun bar(block: () -> Out<E>) {}
}

fun test(a: A<out CharSequence>, z: Out<CharSequence>) {
    a.foo {
        val x: String = <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!> // Should be no TYPE_MISMATCH_DUE_TO_TYPE_PROJECTIONS
        <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!>
    }
    a.bar { <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>Out<CharSequence>()<!><!> }
    a.bar { Out() }
    a.bar { <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>z.id()<!><!> }

    a.foo {
        z.foobar(if (1 > 2) return@foo <!TYPE_MISMATCH!>""<!> else "")
        <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!>
    }
}
