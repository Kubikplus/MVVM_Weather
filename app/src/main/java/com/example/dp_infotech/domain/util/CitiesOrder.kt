package com.example.dp_infotech.domain.util

sealed class CitiesOrder(val orderType:OrderType){
    class Title(orderType: OrderType):CitiesOrder(orderType)
    class Date(orderType: OrderType):CitiesOrder(orderType)

    fun copy(orderType: OrderType):CitiesOrder{
        return when(this){
            is Title ->Title(orderType)
            is Date -> Date(orderType)
        }
    }

}

