package com.ghrer.commerce.inventory.event.handler

import com.ghrer.commerce.inventory.business.InventoryProcessor
import com.ghrer.commerce.inventory.controller.dto.ReserveItemRequest
import com.ghrer.commerce.inventory.event.model.CommerceEvent
import com.ghrer.commerce.inventory.event.model.OrderCreatedEvent
import org.springframework.stereotype.Service
import kotlin.reflect.KClass

@Service
class OrderCreatedEventHandler(
    private val inventoryProcessor: InventoryProcessor
) : EventHandler {
    override fun handleEvent(event: CommerceEvent) {
        val orderCreatedEvent = event as OrderCreatedEvent
        inventoryProcessor.commitReservedItems(
            orderCreatedEvent.order.items.map {
                ReserveItemRequest(it.id, it.quantity)
            }
        ).block()
    }

    override fun getSupportedClass(): KClass<OrderCreatedEvent> {
        return OrderCreatedEvent::class
    }
}
