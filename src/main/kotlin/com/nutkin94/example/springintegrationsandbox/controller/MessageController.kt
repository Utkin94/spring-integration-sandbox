package com.nutkin94.example.springintegrationsandbox.controller

import org.springframework.messaging.MessageChannel
import org.springframework.messaging.support.GenericMessage
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/message")
class MessageController(val directChannel: MessageChannel?) {

    @PostMapping
    fun createMessage(@RequestBody message: String): String {
        println("${Thread.currentThread().name} send message to directChannel")
        directChannel?.send(GenericMessage<String>(message))

        return "Message $message published!"
    }
}