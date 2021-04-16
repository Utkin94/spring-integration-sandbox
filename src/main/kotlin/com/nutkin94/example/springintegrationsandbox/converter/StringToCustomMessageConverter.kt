package com.nutkin94.example.springintegrationsandbox.converter

import com.nutkin94.example.springintegrationsandbox.domain.CustomMessage
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class StringToCustomMessageConverter : Converter<String, CustomMessage> {

    override fun convert(source: String): CustomMessage = CustomMessage(source)
}