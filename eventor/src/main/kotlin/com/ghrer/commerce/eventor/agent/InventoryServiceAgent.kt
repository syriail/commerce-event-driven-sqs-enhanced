package com.ghrer.commerce.eventor.agent

import com.ghrer.commerce.eventor.agent.adaptor.InventoryServiceSqsSender
import com.ghrer.commerce.eventor.event.model.OrderCreatedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class InventoryServiceAgent(
    private val inventoryServiceSqsSender: InventoryServiceSqsSender
) {
    @EventListener
    fun on(orderCreatedEvent: OrderCreatedEvent) {
        inventoryServiceSqsSender.send(orderCreatedEvent)
    }
}
