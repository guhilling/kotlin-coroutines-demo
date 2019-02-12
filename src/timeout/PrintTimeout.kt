package timeout

import de.hilling.coroutines.common.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import java.util.*

fun main() = runBlocking {
    withTimeout(4500L) {
        while (true) {
            log("It is now ${Date()}")
            delay(1000)
        }
    }
}
