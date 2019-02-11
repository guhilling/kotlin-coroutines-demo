package basics

import de.hilling.coroutines.common.log
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val deferredWorld = async {
        log("delaying first coroutine")
        Thread.sleep(500)
        "World!"
    }
    val deferredHello = async {
        log("delaying second coroutine")
        Thread.sleep(500)
        "Hello"
    }
    log("${deferredHello.await()}, ${deferredWorld.await()}")
}
