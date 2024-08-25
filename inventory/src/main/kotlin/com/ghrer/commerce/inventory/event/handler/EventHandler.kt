package com.ghrer.commerce.inventory.event.handler

import com.ghrer.commerce.inventory.event.model.CommerceEvent
import kotlin.reflect.KClass

interface EventHandler {

    fun handleEvent(event: CommerceEvent)

    fun getSupportedClass(): KClass<*>
}
