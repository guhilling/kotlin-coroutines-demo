package network

import de.hilling.coroutines.common.log
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicLong
import kotlin.system.measureTimeMillis

fun loadPage(webPage: String): Long = measureTimeMillis {
    log("loading ${webPage}")
    Thread.sleep(100)
    log("loaded ${webPage}")
}

fun main() = runBlocking(newFixedThreadPoolContext(5, "Background Pool")) {
    val totalTime = AtomicLong(0);
    val totalMillis = measureTimeMillis {
        coroutineScope {
            for (i in 1..10)
                launch() {
                    totalTime.addAndGet(loadPage("www.url-$i.de"))
                }
        }
    }
    println("took             ${totalMillis} ms.")
    println("individual total ${totalTime} ms.")
}
