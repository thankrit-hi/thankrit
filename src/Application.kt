package com.thankrit

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

// ipconfig
fun Application.module() {

    install(Routing){
        get("/api/krit/test") {
            call.respond("dru sp")
        }

        post("/api/krit/testtest"){
            call.respond("OK success")
        }
    }

}

