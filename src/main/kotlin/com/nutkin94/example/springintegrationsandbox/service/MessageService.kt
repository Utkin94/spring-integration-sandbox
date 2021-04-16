package com.nutkin94.example.springintegrationsandbox.service

import com.nutkin94.example.springintegrationsandbox.domain.CustomMessage
import org.springframework.integration.channel.DirectChannel
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class MessageService(val messageChannel: DirectChannel) {

    @PostConstruct
    fun listenMessage() {
        createSubscriberWithName("firstSubscriber")
        createSubscriberWithName("secondSubscriber")
    }

    private fun createSubscriberWithName(name: String) {
        messageChannel.subscribe {
            val message = it.payload as CustomMessage
            Thread.sleep(1000L)
            println("${Thread.currentThread().name} thread on $name: receive message: ${message.text}")
        }
    }
}