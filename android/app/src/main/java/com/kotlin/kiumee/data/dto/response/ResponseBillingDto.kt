package com.kotlin.kiumee.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBillingDto(
    @SerialName("orderInfo")
    val orderInfo: ResponseBillingOrderInfoDto,
    @SerialName("totalPrice")
    val totalPrice: Int
)

@Serializable
data class ResponseBillingOrderInfoDto(
    @SerialName("items")
    val items: List<ResponseBillingItemsDto>
)

@Serializable
data class ResponseBillingItemsDto(
    @SerialName("id")
    val id: Int,
    @SerialName("category")
    val category: String,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Int,
    @SerialName("quantity")
    val quantity: Int
)