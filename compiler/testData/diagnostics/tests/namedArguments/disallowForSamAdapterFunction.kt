// !WITH_NEW_INFERENCE

// FILE: test/J.java

package test;

public class J {
    public static void foo(String s, Runnable r, Boolean z) {
    }
}

// FILE: usage.kt

package test

fun test() {
    J.foo("", <!NI;NAMED_ARGUMENTS_NOT_ALLOWED!><!NAMED_ARGUMENTS_NOT_ALLOWED!>r<!><!> = <!NI;TYPE_MISMATCH!>{ }<!>, <!NI;NAMED_ARGUMENTS_NOT_ALLOWED!><!NAMED_ARGUMENTS_NOT_ALLOWED!>z<!><!> = false)
}
