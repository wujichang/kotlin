// !DIAGNOSTICS: -UNUSED_EXPRESSION, -REFLECTION_TYPES_NOT_LOADED

class Delegate() {
    deprecated("text")
    fun get(instance: Any, property: PropertyMetadata) : Int = 1

    deprecated("text")
    fun set(instance: Any, property: PropertyMetadata, value: Int) {}
}

class PropertyHolder {
    deprecated("text")
    val x = 1

    deprecated("text")
    var name = "String"

    val valDelegate <!DEPRECATED_SYMBOL_WITH_MESSAGE!>by<!> Delegate()
    var varDelegate <!DEPRECATED_SYMBOL_WITH_MESSAGE, DEPRECATED_SYMBOL_WITH_MESSAGE!>by<!> Delegate()

    public val test1: String = ""
        @deprecated("val-getter") get

    public var test2: String = ""
        @deprecated("var-getter") get
        @deprecated("var-setter") set

    public var test3: String = ""
        @deprecated("var-getter") get
        set

    public var test4: String = ""
        get
        @deprecated("var-setter") set
}

fun PropertyHolder.extFunction() {
    <!DEPRECATED_SYMBOL_WITH_MESSAGE!>test2<!> = "ext"
    <!DEPRECATED_SYMBOL_WITH_MESSAGE!>test1<!>
}

fun fn() {
    PropertyHolder().<!DEPRECATED_SYMBOL_WITH_MESSAGE!>test1<!>
    PropertyHolder().<!DEPRECATED_SYMBOL_WITH_MESSAGE!>test2<!>
    PropertyHolder().<!DEPRECATED_SYMBOL_WITH_MESSAGE!>test2<!> = ""

    PropertyHolder().<!DEPRECATED_SYMBOL_WITH_MESSAGE!>test3<!>
    PropertyHolder().test3 = ""

    PropertyHolder().test4
    PropertyHolder().<!DEPRECATED_SYMBOL_WITH_MESSAGE!>test4<!> = ""

    val <!UNUSED_VARIABLE!>a<!> = PropertyHolder().<!DEPRECATED_SYMBOL_WITH_MESSAGE!>x<!>
    val <!UNUSED_VARIABLE!>b<!> = PropertyHolder().<!DEPRECATED_SYMBOL_WITH_MESSAGE!>name<!>
    PropertyHolder().<!DEPRECATED_SYMBOL_WITH_MESSAGE!>name<!> = "value"

    val <!UNUSED_VARIABLE!>d<!> = PropertyHolder().valDelegate
    PropertyHolder().varDelegate = 1
}

fun literals() {
    PropertyHolder::test1
    PropertyHolder::<!DEPRECATED_SYMBOL_WITH_MESSAGE!>name<!>
}