package com.ghrer.commerce.payments.event.handler

import com.ghrer.commerce.payments.business.Address
import com.ghrer.commerce.payments.business.Item
import com.ghrer.commerce.payments.business.PaymentProcessor
import com.ghrer.commerce.payments.business.ProcessPaymentRequest
import com.ghrer.commerce.payments.event.model.CommerceEvent
import com.ghrer.commerce.payments.event.model.OrderCreatedEvent
import org.springframework.stereotype.Service
import kotlin.reflect.KClass

@Service
class OrderCreatedEventHandler(
    private val paymentProcessor: PaymentProcessor
) : EventHandler {
    override fun handleEvent(event: CommerceEvent) {
        val orderCreatedEvent = event as OrderCreatedEvent
        paymentProcessor.processPayment(
            mapToProcessEventRequest(orderCreatedEvent)
        )
    }

    override fun getSupportedClass(): KClass<OrderCreatedEvent> {
        return OrderCreatedEvent::class
    }

    private fun mapToProcessEventRequest(event: OrderCreatedEvent) = ProcessPaymentRequest(
        orderId = event.order.id,
        customerId = event.order.customerId,
        customerAddress = with(event.order.customerAddress) {
            Address(
                firstName,
                lastName,
                street,
                houseNumber,
                postCode,
                city
            )
        },
        totalPrice = event.order.totalPrice,
        items = event.order.items.map {
            Item(it.id, it.price, it.quantity)
        }
    )
}
