package workload

import de.hilling.coroutines.common.log
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main(): Unit = runBlocking {
    val pool = newFixedThreadPoolContext(2, "worker pool")
    val timesAccumulator = Channel<Long>(0)

    (1..4).forEach {
        launch(pool) {
            timesAccumulator.send(doWork("task-${it}"))
        }
    }

    var total = 0L
    withTimeoutOrNull(1000) {
        timesAccumulator.consumeEach {
            total += it
            log("current total time ${total} ms")
        }
    }?:Unit
}
