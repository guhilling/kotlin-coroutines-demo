package cancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

fun main() {
    runBlocking {
        val timeJob = launch {
            while (true) {
                println("It is now ${Date()}")
                delay(1000)
            }
        }
        delay(4500L)
        timeJob.cancelAndJoin()
    }
}
