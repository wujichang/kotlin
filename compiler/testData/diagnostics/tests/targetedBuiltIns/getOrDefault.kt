// !WITH_NEW_INFERENCE

// FULL_JDK

abstract class A : Map<Int, String>

fun foo(x: Map<Int, String>, a: A, b: java.util.HashMap<Int, String>) {
    x.getOrDefault(1, "")
    x.getOrDefault(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!>, "")
    x.getOrDefault(1, <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>2<!><!>)
    x.getOrDefault(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!>, <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>2<!><!>)

    a.getOrDefault(1, "")
    a.getOrDefault(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!>, "")
    a.getOrDefault(1, <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>2<!><!>)
    a.getOrDefault(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!>, <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>2<!><!>)

    b.getOrDefault(1, "")
    b.getOrDefault(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!>, "")
    b.getOrDefault(1, <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>2<!><!>)
    b.getOrDefault(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!>, <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>2<!><!>)
}
