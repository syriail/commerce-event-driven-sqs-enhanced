package com.ghrer.commerce.orders.event

import com.fasterxml.jackson.databind.ObjectMapper
import com.ghrer.commerce.orders.event.handler.EventHandlerProxy
import com.ghrer.commerce.orders.event.model.CommerceEvent
import io.awspring.cloud.sqs.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class SqsListener(
    private val objectMapper: ObjectMapper,
    private val eventHandlerProxy: EventHandlerProxy
) {

    @SqsListener("\${aws-resources.orderServiceEventsQueueUrl}")
    fun listen(message: String) {
        val event = objectMapper.readValue(message, CommerceEvent::class.java)
        eventHandlerProxy.handleEvent(event)
    }
}
