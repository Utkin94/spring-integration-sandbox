package com.nutkin94.example.springintegrationsandbox.config

import com.nutkin94.example.springintegrationsandbox.domain.CustomMessage
import org.springframework.boot.convert.ApplicationConversionService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.ConversionService
import org.springframework.integration.channel.DirectChannel
import org.springframework.messaging.MessageChannel

@Configuration
class MessagingConfiguration {

    @Bean
    fun messageChannel(): MessageChannel {
        val channel = DirectChannel()

        channel.setDatatypes(CustomMessage::class.java)

        return channel
    }
}