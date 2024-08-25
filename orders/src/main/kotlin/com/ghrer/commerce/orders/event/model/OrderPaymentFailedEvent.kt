package com.ghrer.commerce.orders.event.model

import java.util.UUID

data class OrderPaymentFailedEvent(
    override val eventType: OrderEventType = OrderEventType.ORDER_PAYMENT_FAILED,
    val orderId: UUID,
    val reason: String,
) : CommerceEvent(eventType) {
    override val eventGroupId: String
        get() = orderId.toString()
}
