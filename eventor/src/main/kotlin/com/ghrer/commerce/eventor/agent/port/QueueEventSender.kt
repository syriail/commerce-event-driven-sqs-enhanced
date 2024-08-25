package com.ghrer.commerce.eventor.agent.port

import com.ghrer.commerce.eventor.event.model.CommerceEvent

interface QueueEventSender {
    fun send(event: CommerceEvent)
}
