package com.ghrer.commerce.payments.event

import com.ghrer.commerce.payments.event.model.CommerceEvent

interface EventPublisher {
    fun publish(event: CommerceEvent)
}
