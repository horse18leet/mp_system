package com.bytebusters.android.mpsystem.models

sealed class ComposeError {
    object SendingGeneric : ComposeError()
}