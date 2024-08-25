package com.ghrer.commerce.eventor.event

import com.fasterxml.jackson.databind.ObjectMapper
import com.ghrer.commerce.eventor.event.model.CommerceEvent
import mu.KotlinLogging
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class MessageTransformer(
    private val applicationEventPublisher: ApplicationEventPublisher,
    private val objectMapper: ObjectMapper,
) {
    val logger = KotlinLogging.logger { }
    fun transform(message: String) {
        runCatching {
            val event = objectMapper.readValue(message, CommerceEvent::class.java)
            applicationEventPublisher.publishEvent(event)
        }.onFailure {
            logger.error(it) { "It seems that the event is not deserializable. $message" }
        }
    }
}
