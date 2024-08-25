package com.ghrer.commerce.payments.event

import com.fasterxml.jackson.databind.ObjectMapper
import com.ghrer.commerce.payments.event.handler.EventHandlerProxy
import com.ghrer.commerce.payments.event.model.CommerceEvent
import io.awspring.cloud.sqs.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class SqsListener(
    private val objectMapper: ObjectMapper,
    private val eventHandlerProxy: EventHandlerProxy
) {

    @SqsListener("\${aws-resources.paymentServiceEventsQueueUrl}")
    fun listen(message: String) {
        val event = objectMapper.readValue(message, CommerceEvent::class.java)
        eventHandlerProxy.handleEvent(event)
    }
}
