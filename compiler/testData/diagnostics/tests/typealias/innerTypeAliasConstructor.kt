// !DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER -TOPLEVEL_TYPEALIASES_ONLY
// !WITH_NEW_INFERENCE

class Pair<X, Y>(val x: X, val y: Y)

class C<T> {
    typealias P = Pair<T, T>
    typealias P1<X> = Pair<X, T>
    typealias P2<Y> = Pair<T, Y>
}

// C<...>.P[<...>]() syntax doesn't work due to the way qualified expressions are resolved now.
// This restriction can be removed later.
val test0 = <!NI;FUNCTION_CALL_EXPECTED!><!FUNCTION_CALL_EXPECTED!>C<Int><!><!>.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>P<!><!>(1, 1)
val test1 = <!NI;FUNCTION_CALL_EXPECTED!><!FUNCTION_CALL_EXPECTED!>C<Int><!><!>.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>P1<!><!><String>("", 1)
val test2 = <!NI;FUNCTION_CALL_EXPECTED!><!FUNCTION_CALL_EXPECTED!>C<Int><!><!>.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>P2<!><!><String>(1, "")
val test3 = <!NI;FUNCTION_CALL_EXPECTED!><!FUNCTION_CALL_EXPECTED!>C<Int><!><!>.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>P1<!><!>("", 1)
val test4 = <!NI;FUNCTION_CALL_EXPECTED!><!FUNCTION_CALL_EXPECTED!>C<Int><!><!>.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>P2<!><!>(1, "")

// C.P() syntax could work if we add captured type parameters as type variables in a constraint system for corresponding call.
// However, this should be consistent with inner classes capturing type parameters.
val test5 = C.P(<!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!>, <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!>)
val test6 = C.<!TYPE_INFERENCE_PARAMETER_CONSTRAINT_ERROR!>P1<!>("", <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!>)
val test7 = C.<!TYPE_INFERENCE_PARAMETER_CONSTRAINT_ERROR!>P2<!>(<!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!>, "")
