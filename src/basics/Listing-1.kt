package basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch ( block = {
        delay(500)
        println("World!")
    });
    println("Hello,")
    Thread.sleep(1000L)
}
