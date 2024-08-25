package com.ghrer.commerce.eventor.agent

import com.ghrer.commerce.eventor.agent.adaptor.PaymentServiceSqsSender
import com.ghrer.commerce.eventor.event.model.OrderCreatedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class PaymentServiceAgent(
    private val paymentServiceSqsSender: PaymentServiceSqsSender
) {
    @EventListener
    fun on(orderCreatedEvent: OrderCreatedEvent) {
        paymentServiceSqsSender.send(orderCreatedEvent)
    }
}
