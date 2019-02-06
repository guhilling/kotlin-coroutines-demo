package cancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import java.util.*

fun main() {
    runBlocking {
        withTimeoutOrNull(4500L) {
            while (true) {
                println("It is now ${Date()}")
                delay(1000)
            }
        }
    }
}
