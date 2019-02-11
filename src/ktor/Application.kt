package ktor

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import kotlinx.coroutines.delay
import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("application")

fun log(message: String) {
    logger.debug(message)
}

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val client = HttpClient() {
    }

    routing {
        get("/hello") {
            log("delay")
            delay(100)
            log("responding hello")
            call.respondText("hello, world!")
        }
        get("/HELLO") {
            log("calling HELLO")
            val result = client.get<String> ("http://localhost:8080/hello")
            call.respondText(result.toUpperCase())
            log("called HELLO")
        }
    }
}

