// !DIAGNOSTICS: -UNUSED_EXPRESSION,-UNUSED_VARIABLE,-UNUSED_PARAMETER,-ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE,-UNUSED_VALUE
// !WITH_NEW_INFERENCE

fun <T : CharSequence> bar1(x: T) {}
fun bar2(x: CharSequence) {}
fun bar3(x: String) {}

fun <T : CharSequence?> foo(x: T) {
    var y1: CharSequence = ""
    var y2: String = ""
    if (x != null) {
        if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!>x != null<!><!>) {}

        y1 = <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>
        y2 = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!>

        <!TYPE_INFERENCE_UPPER_BOUND_VIOLATED!>bar1<!>(<!NI;TYPE_MISMATCH!>x<!>)
        bar1<CharSequence>(<!NI;TYPE_MISMATCH!><!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!><!>)
        bar2(<!NI;TYPE_MISMATCH!><!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!><!>)
        bar3(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!>)
    }

    if (x is String) {
        y1 = <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>
        y2 = <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>

        bar1(<!DEBUG_INFO_SMARTCAST!>x<!>)
        bar2(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
        bar3(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
    }

    if (x is CharSequence) {
        y1 = <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>
        y2 = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!>

        bar1(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
        bar2(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
        bar3(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!>)
    }

    if (1 == 1) {
        val y = x!!
        <!TYPE_INFERENCE_UPPER_BOUND_VIOLATED!>bar1<!>(<!NI;TYPE_MISMATCH!>x<!>)
        bar1<CharSequence>(<!NI;TYPE_MISMATCH!><!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!><!>)
        bar2(<!NI;TYPE_MISMATCH!><!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!><!>)
        bar3(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!>)

        <!TYPE_INFERENCE_UPPER_BOUND_VIOLATED!>bar1<!>(y)
        bar2(<!DEBUG_INFO_SMARTCAST!>y<!>)
        bar3(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>y<!><!>)
    }
}
