package com.ghrer.commerce.inventory.event.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import java.time.Instant

enum class OrderEventType {
    ORDER_CREATED,
    ORDER_PAYMENT_SUCCESSFUL,
    ORDER_PAYMENT_FAILED,
}
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "eventType")
@JsonSubTypes(
    JsonSubTypes.Type(value = OrderCreatedEvent::class, name = "ORDER_CREATED"),
)
abstract class CommerceEvent(
    open val eventType: OrderEventType,
    val timestamp: Instant = Instant.now(),
) {
    abstract val eventGroupId: String
}
