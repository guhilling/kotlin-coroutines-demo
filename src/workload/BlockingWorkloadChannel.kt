package workload

import de.hilling.coroutines.common.log
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val pool = newFixedThreadPoolContext(2, "worker pool")
    val timesAccumulator = Channel<Long>(0);
    for (i in 1..4) {
        launch(pool) {
            timesAccumulator.send(doWork("task-$i"))
        }
    }
    var total = 0L
    timesAccumulator.consumeEach {
        total += it
        log("current total time ${total} ms")
    }
}
