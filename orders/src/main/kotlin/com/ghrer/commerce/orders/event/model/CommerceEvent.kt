package com.ghrer.commerce.orders.event.model

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
    JsonSubTypes.Type(value = OrderPaymentSuccessfulEvent::class, name = "ORDER_PAYMENT_SUCCESSFUL"),
    JsonSubTypes.Type(value = OrderPaymentFailedEvent::class, name = "ORDER_PAYMENT_FAILED"),
)
abstract class CommerceEvent(
    open val eventType: OrderEventType,
    val timestamp: Instant = Instant.now(),
) {
    abstract val eventGroupId: String
}
