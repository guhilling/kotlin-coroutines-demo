package basics

import de.hilling.coroutines.common.log
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val deferredWorld = async {
        log("delaying first coroutine")
        delay(500)
        "World!"
    }
    val deferredHello = async {
        log("delaying second coroutine")
        delay(500)
        "Hello"
    }
    log("${deferredHello.await()}, ${deferredWorld.await()}")
}
