package com.ghrer.commerce.eventor.agent

import com.ghrer.commerce.eventor.agent.service.port.OrderService
import com.ghrer.commerce.eventor.agent.service.port.UpdateOrderPaymentStatusRequest
import com.ghrer.commerce.eventor.event.model.OrderPaymentFailedEvent
import com.ghrer.commerce.eventor.event.model.OrderPaymentSuccessfulEvent
import com.ghrer.commerce.eventor.model.OrderStatus
import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class OrderServiceAgent() {

    private val logger = KotlinLogging.logger { }

    @EventListener
    fun on(paymentSuccessfulEvent: OrderPaymentSuccessfulEvent) {
        logger.info { "Update order ${paymentSuccessfulEvent.orderId} with status ${OrderStatus.PAID}" }
    }

    @EventListener
    fun on(paymentFailedEvent: OrderPaymentFailedEvent) {
        logger.info { "Update order ${paymentFailedEvent.orderId} with status ${OrderStatus.PAYMENT_FAILED}" }
    }
}
