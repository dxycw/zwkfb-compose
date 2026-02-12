package 安卓x.组合.界面

import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope

object 修饰符 : Modifier{
    override fun <R> foldIn(initial: R, operation: (R, Modifier.Element) -> R): R = initial

    override fun <R> foldOut(initial: R, operation: (Modifier.Element, R) -> R): R = initial

    override fun any(predicate: (Modifier.Element) -> Boolean): Boolean = false

    override fun all(predicate: (Modifier.Element) -> Boolean): Boolean = true

    @Suppress("ModifierFactoryExtensionFunction")
    override infix fun then(other: Modifier): Modifier = other

    override fun toString() = "Modifier"

    abstract class 节点 : Modifier.Node {

        val 协程作用域: CoroutineScope = this.coroutineScope

        var 是否已附加: Boolean = this.isAttached
            private set

        @Suppress("GetterSetterNames")
        @get:Suppress("GetterSetterNames")
        open val 是否应自动失效: Boolean
            get() = this.shouldAutoInvalidate

        constructor() : super()

        open fun 附加回调(){
            super.onAttach()
        }

        open fun 分离回调() {
            super.onDetach()
        }


        open fun 重置回调() {
            super.onReset()
        }

        fun 副作用(effect: () -> Unit) = this.sideEffect(effect)

    }

    interface 元素 : Modifier.Element {
        override fun <R> foldIn(initial: R, operation: (R, Modifier.Element) -> R, ): R =
            operation(initial, this)
        override fun <R> foldOut(initial: R, operation: (Modifier.Element, R) -> R, ): R =
            operation(this , initial)
        override fun any(predicate: (Modifier.Element) -> Boolean): Boolean = predicate(this)
        override fun all(predicate: (Modifier.Element) -> Boolean): Boolean = predicate(this)
    }
}

class 合并修饰符(internal val 外部: Modifier, internal val 内部: Modifier) : Modifier {
    override fun <R> foldIn(initial: R, operation: (R, Modifier.Element) -> R): R =
        内部.foldIn(外部.foldIn(initial, operation), operation)

    override fun <R> foldOut(initial: R, operation: (Modifier.Element, R) -> R): R =
        外部.foldOut(内部.foldOut(initial, operation), operation)

    override fun any(predicate: (Modifier.Element) -> Boolean): Boolean =
        外部.any(predicate) || 内部.any(predicate)

    override fun all(predicate: (Modifier.Element) -> Boolean): Boolean =
        外部.all(predicate) && 内部.all(predicate)

    override fun equals(other: Any?): Boolean =
        other is 合并修饰符 && 外部 == other.外部 && 内部 == other.内部

    override fun hashCode(): Int = 外部.hashCode() + 31 * 内部.hashCode()

    override fun toString() =
        "[" +
            foldIn("") { acc, element ->
                if (acc.isEmpty()) element.toString() else "$acc, $element"
            } +
        "]"
}
