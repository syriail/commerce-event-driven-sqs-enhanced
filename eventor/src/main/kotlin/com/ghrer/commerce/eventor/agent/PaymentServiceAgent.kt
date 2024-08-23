package com.ghrer.commerce.eventor.agent

import com.ghrer.commerce.eventor.agent.service.port.PaymentService
import com.ghrer.commerce.eventor.agent.service.port.ProcessPaymentRequest
import com.ghrer.commerce.eventor.event.model.OrderCreatedEvent
import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class PaymentServiceAgent() {

    val logger = KotlinLogging.logger { }

    @EventListener
    fun on(orderCreatedEvent: OrderCreatedEvent) {
        logger.info { "Process payment for order ${orderCreatedEvent.order.id}" }
    }
}
