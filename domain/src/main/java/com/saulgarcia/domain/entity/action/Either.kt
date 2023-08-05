package com.saulgarcia.domain.entity.action

import com.saulgarcia.domain.entity.action.error.ErrorEntity

sealed interface Either {
    data class Success (private val data: Any) : Either {
        @Suppress("UNCHECKED_CAST")
        fun <R> getData() = data as R//Developer error let it throw exception...
    }
    data class Error(val error: ErrorEntity): Either
}