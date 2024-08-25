package com.ghrer.commerce.inventory.event.model

import java.time.LocalDateTime
import java.util.UUID

data class Order(
    val id: UUID,
    val customerId: String,
    val customerAddress: Address,
    val paymentId: String? = null,
    val shipmentId: String? = null,
    val totalPrice: Double,
    val status: OrderStatus,
    val createDate: LocalDateTime,
    val items: List<Item>
)

data class Address(
    val firstName: String,
    val lastName: String,
    val street: String,
    val houseNumber: String,
    val postCode: String,
    val city: String,
)

data class Item(
    val id: UUID,
    val quantity: Int,
    val price: Double
)

enum class OrderStatus {
    PLACED,
    PAID,
    PAYMENT_FAILED,
    DISPATCHED,
    SHIPPED,
    DELIVERED,
}
