package com.ghrer.commerce.eventor.agent

import com.ghrer.commerce.eventor.agent.adaptor.OrderServiceSqsSender
import com.ghrer.commerce.eventor.event.model.OrderPaymentFailedEvent
import com.ghrer.commerce.eventor.event.model.OrderPaymentSuccessfulEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class OrderServiceAgent(
    private val orderServiceSqsSender: OrderServiceSqsSender
) {

    @EventListener
    fun on(paymentSuccessfulEvent: OrderPaymentSuccessfulEvent) {
        orderServiceSqsSender.send(paymentSuccessfulEvent)
    }

    @EventListener
    fun on(paymentFailedEvent: OrderPaymentFailedEvent) {
        orderServiceSqsSender.send(paymentFailedEvent)
    }
}
