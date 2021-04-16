package com.nutkin94.example.springintegrationsandbox.config

import com.nutkin94.example.springintegrationsandbox.domain.CustomMessage
import com.nutkin94.example.springintegrationsandbox.interceptor.CustomInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.channel.DirectChannel
import org.springframework.messaging.MessageChannel

@Configuration
class MessagingConfiguration {

    /**
     * DirectChannel execute subscribe function of the sender thread.
     */
    @Bean
    fun directChannel(): MessageChannel {
        val channel = DirectChannel()
        channel.setDatatypes(CustomMessage::class.java)
        channel.addInterceptor(CustomInterceptor())
        return channel
    }

}