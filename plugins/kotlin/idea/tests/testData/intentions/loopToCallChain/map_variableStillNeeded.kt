// WITH_RUNTIME
// IS_APPLICABLE: false
fun foo(list: List<String>): String? {
    <caret>for (s in list) {
        val length = s.length
        if (length > 0) return s + length
    }
    return null
}