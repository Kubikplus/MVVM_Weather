package com.example.dp_infotech.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending:OrderType()

}
