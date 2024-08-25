package com.ghrer.commerce.eventor.event.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class OrderCreatedEvent(
    override val eventType: OrderEventType = OrderEventType.ORDER_CREATED,
    val order: Order
) : CommerceEvent(eventType) {
    override val eventGroupId: String
        get() = order.id.toString()
}
