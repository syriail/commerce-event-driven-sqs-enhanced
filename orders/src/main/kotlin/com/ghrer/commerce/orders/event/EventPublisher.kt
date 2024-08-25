package com.ghrer.commerce.orders.event

import com.ghrer.commerce.orders.event.model.CommerceEvent

interface EventPublisher {
    fun publish(event: CommerceEvent)
}
