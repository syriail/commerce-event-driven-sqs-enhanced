package com.ghrer.commerce.payments.event.handler

import com.ghrer.commerce.payments.event.model.CommerceEvent
import kotlin.reflect.KClass

interface EventHandler {

    fun handleEvent(event: CommerceEvent)

    fun getSupportedClass(): KClass<*>
}
