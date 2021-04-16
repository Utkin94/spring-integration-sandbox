package com.nutkin94.example.springintegrationsandbox.service

import com.nutkin94.example.springintegrationsandbox.domain.CustomMessage
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.channel.PublishSubscribeChannel
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class MessageService(
    val directChannel: DirectChannel,
    val publishSubscribeChannel: PublishSubscribeChannel
) {

    @PostConstruct
    fun listenMessage() {
        attachMessageHandlerWithName("firstSubscriber")
        attachMessageHandlerWithName("secondSubscriber")

        subscribeChannel("firstSubscriber")
        subscribeChannel("secondSubscriber")
    }

    private fun subscribeChannel(name: String) {
        publishSubscribeChannel.subscribe {
            Thread.sleep(1000L)
            println("$name on ${Thread.currentThread().name} receive message ${it.payload}")
        }
    }

    private fun attachMessageHandlerWithName(name: String) {
        directChannel.subscribe {
            val message = it.payload as CustomMessage
            Thread.sleep(1000L)
            println("${Thread.currentThread().name} thread on $name: receive message: ${message.text}")
        }
    }
}