package com.ghrer.commerce.orders.event.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.ghrer.commerce.orders.model.OrderAggregate

@JsonIgnoreProperties(ignoreUnknown = true)
data class OrderCreatedEvent(
    override val eventType: OrderEventType = OrderEventType.ORDER_CREATED,
    val order: OrderAggregate
) : CommerceEvent(eventType) {
    override val eventGroupId: String
        get() = order.id.toString()
}
