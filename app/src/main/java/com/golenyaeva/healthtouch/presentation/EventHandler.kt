package com.golenyaeva.healthtouch.presentation

interface EventHandler<T> {
    fun obtainEvent(event: T)
}
