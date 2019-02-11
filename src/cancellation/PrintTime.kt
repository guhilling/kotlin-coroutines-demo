package cancellation

import de.hilling.coroutines.common.log
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

fun main() = runBlocking {
    val timeJob = launch {
        while (true) {
            log("It is now ${Date()}")
            delay(1000)
        }
    }
    delay(3500L)
    log("joining")
    timeJob.cancelAndJoin()
    log("joined")
}
