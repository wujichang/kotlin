// !DIAGNOSTICS: -UNUSED_PARAMETER -UNUSED_ANONYMOUS_PARAMETER
// !WITH_NEW_INFERENCE

fun <T, R : Any> foo(body: (R?) -> T): T = fail()

fun test1() {
    <!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>foo<!> {
        <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!>true<!>
    }
    <!NI;UNREACHABLE_CODE!><!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>foo<!> { <!CANNOT_INFER_PARAMETER_TYPE!>x<!> ->
        <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!>true<!>
    }<!>
}


fun <T, R> bar(body: (R) -> T): T = fail()

fun test2() {
    <!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>bar<!> {
        <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!>true<!>
    }
    <!NI;UNREACHABLE_CODE!><!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>bar<!> { <!CANNOT_INFER_PARAMETER_TYPE!>x<!> ->
        <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!>true<!>
    }<!>
}

fun <T, R> baz(body: (List<R>) -> T): T = fail()

fun test3() {
    <!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>baz<!> {
        <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!>true<!>
    }
    <!NI;UNREACHABLE_CODE!><!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>baz<!> { <!CANNOT_INFER_PARAMETER_TYPE!>x<!> ->
        <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!>true<!>
    }<!>
}

fun <T, R : Any> brr(body: (List<R?>) -> T): T = fail()

fun test4() {
    <!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>brr<!> {
        <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!>true<!>
    }
    <!NI;UNREACHABLE_CODE!><!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>brr<!> { <!CANNOT_INFER_PARAMETER_TYPE!>x<!> ->
        <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!>true<!>
    }<!>
}

fun fail(): Nothing = throw Exception()