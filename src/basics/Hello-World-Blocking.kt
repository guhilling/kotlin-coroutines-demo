package basics

import de.hilling.coroutines.common.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
     launch {
        delay(500)
        log("World!")
    }
    log("Hello,")
}
