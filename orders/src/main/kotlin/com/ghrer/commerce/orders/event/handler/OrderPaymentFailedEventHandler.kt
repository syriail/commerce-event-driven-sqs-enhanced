package com.ghrer.commerce.orders.event.handler

import com.ghrer.commerce.orders.business.OrderHandler
import com.ghrer.commerce.orders.event.model.CommerceEvent
import com.ghrer.commerce.orders.event.model.OrderPaymentFailedEvent
import com.ghrer.commerce.orders.model.OrderStatus
import org.springframework.stereotype.Service
import kotlin.reflect.KClass

@Service
class OrderPaymentFailedEventHandler(
    private val orderHandler: OrderHandler
) : EventHandler {
    override fun handleEvent(event: CommerceEvent) {
        val paymentFailedEvent = event as OrderPaymentFailedEvent
        orderHandler.updateOrderPaymentStatus(
            id = paymentFailedEvent.orderId,
            status = OrderStatus.PAYMENT_FAILED
        ).block()
    }

    override fun getSupportedClass(): KClass<OrderPaymentFailedEvent> {
        return OrderPaymentFailedEvent::class
    }
}
