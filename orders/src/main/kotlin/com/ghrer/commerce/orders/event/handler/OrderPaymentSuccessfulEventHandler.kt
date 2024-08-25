package com.ghrer.commerce.orders.event.handler

import com.ghrer.commerce.orders.business.OrderHandler
import com.ghrer.commerce.orders.event.model.CommerceEvent
import com.ghrer.commerce.orders.event.model.OrderPaymentSuccessfulEvent
import com.ghrer.commerce.orders.model.OrderStatus
import org.springframework.stereotype.Service
import kotlin.reflect.KClass

@Service
class OrderPaymentSuccessfulEventHandler(
    private val orderHandler: OrderHandler
) : EventHandler {
    override fun handleEvent(event: CommerceEvent) {
        val paymentSuccessfulEvent = event as OrderPaymentSuccessfulEvent
        orderHandler.updateOrderPaymentStatus(
            id = paymentSuccessfulEvent.orderId,
            paymentId = paymentSuccessfulEvent.paymentId.toString(),
            status = OrderStatus.PAID
        ).block()
    }

    override fun getSupportedClass(): KClass<OrderPaymentSuccessfulEvent> {
        return OrderPaymentSuccessfulEvent::class
    }
}
