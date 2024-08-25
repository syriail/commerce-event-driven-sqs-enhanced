package com.ghrer.commerce.eventor.agent

import com.ghrer.commerce.eventor.event.model.CommerceEvent
import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class StreamingAgent {

    private val logger = KotlinLogging.logger { }

    @EventListener
    fun on(commerceEvent: CommerceEvent) {
        // Send the event to a streaming service such Kinesis.
        // So that we can add more layers to process the events.
        // Such as event-sourcing solution, analytics application, notification solution ...etc
        logger.info { "Send the ${commerceEvent.eventType} event to Kinesis stream" }
    }
}
