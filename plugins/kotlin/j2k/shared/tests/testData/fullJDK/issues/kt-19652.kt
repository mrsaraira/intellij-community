import java.awt.image.AreaAveragingScaleFilter
import java.awt.image.AreaAveragingScaleFilter.TOPDOWNLEFTRIGHT

class TestInterfaceStaticFieldReference(width: Int, height: Int) : AreaAveragingScaleFilter(width, height) {
    fun test() {
        println(TOPDOWNLEFTRIGHT)
    }
}
