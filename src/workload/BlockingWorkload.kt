package workload

import de.hilling.coroutines.common.log
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicLong
import kotlin.system.measureTimeMillis

fun doWork(work: String): Long = measureTimeMillis {
    log("starting work ${work}")
    Thread.sleep(100)
    log("finished work ${work}")
}

fun main() = runBlocking(newFixedThreadPoolContext(2, "worker pool")) {
    val accumulatedTime = AtomicLong(0);
    val totalMillis = measureTimeMillis {
        coroutineScope {
            for (i in 1..4)
                launch() {
                    accumulatedTime.addAndGet(doWork("task-$i"))
                }
        }
    }
    log("finished with accumulated time ${accumulatedTime} ms, user time ${totalMillis} ms")
}
