package com.nutkin94.example.springintegrationsandbox.interceptor

import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.support.ChannelInterceptor

class CustomInterceptor : ChannelInterceptor {

    override fun preSend(message: Message<*>, channel: MessageChannel): Message<*>? {
        println("preSend executed")
        return super.preSend(message, channel)
    }

    override fun postSend(message: Message<*>, channel: MessageChannel, sent: Boolean) {
        println("postSend executed")
        super.postSend(message, channel, sent)
    }

    override fun afterSendCompletion(message: Message<*>, channel: MessageChannel, sent: Boolean, ex: Exception?) {
        println("afterSendCompletion executed")
        super.afterSendCompletion(message, channel, sent, ex)
    }

    override fun preReceive(channel: MessageChannel): Boolean {
        println("preReceive executed")
        return super.preReceive(channel)
    }

    override fun postReceive(message: Message<*>, channel: MessageChannel): Message<*>? {
        println("postReceive executed")
        return super.postReceive(message, channel)
    }

    override fun afterReceiveCompletion(message: Message<*>?, channel: MessageChannel, ex: Exception?) {
        println("afterReceiveCompletion executed")
        super.afterReceiveCompletion(message, channel, ex)
    }
}