package com.nutkin94.example.springintegrationsandbox.controller

import org.springframework.integration.channel.PublishSubscribeChannel
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.support.GenericMessage
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/message")
class MessageController(
    val directChannel: MessageChannel?,
    val publishSubscribeChannel: PublishSubscribeChannel
) {

    @PostMapping
    fun createMessage(@RequestBody message: String): String {
        println("${Thread.currentThread().name} send message to directChannel")
        directChannel?.send(GenericMessage<String>(message))

        return "Message $message was processed"
    }

    @PostMapping(params = arrayOf("async"))
    fun createMessageAsync(@RequestBody message: String): String {
        println("${Thread.currentThread().name} send message to queueChannel to asynchronously consume it")

        publishSubscribeChannel.send(GenericMessage<String>(message))

        return "Message $message was published"
    }
}