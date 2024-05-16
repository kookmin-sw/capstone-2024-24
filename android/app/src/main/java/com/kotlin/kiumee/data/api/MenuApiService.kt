package com.kotlin.kiumee.data.api

import com.kotlin.kiumee.core.util.KeyStorage.BILLING
import com.kotlin.kiumee.core.util.KeyStorage.BUSINESS
import com.kotlin.kiumee.core.util.KeyStorage.BUSINESS_ID
import com.kotlin.kiumee.core.util.KeyStorage.ITEMS
import com.kotlin.kiumee.core.util.KeyStorage.ORDERS
import com.kotlin.kiumee.core.util.KeyStorage.SESSION_ID
import com.kotlin.kiumee.core.util.KeyStorage.V1
import com.kotlin.kiumee.data.dto.request.RequestBillingDto
import com.kotlin.kiumee.data.dto.response.ResponseBillingDto
import com.kotlin.kiumee.data.dto.response.ResponseItemsDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface MenuApiService {
    @GET("$V1/$BUSINESS/{$BUSINESS_ID}/$ITEMS")
    suspend fun getItems(
        @Path(value = BUSINESS_ID) businessId: Int
    ): ResponseItemsDto

    @PUT("$V1/$ORDERS/{$BUSINESS_ID}/$BILLING/{$SESSION_ID}")
    suspend fun putBilling(
        @Path(value = BUSINESS_ID) businessId: Int,
        @Path(value = SESSION_ID) sessionId: String,
        @Body requestBillingDto: RequestBillingDto
    ): ResponseBillingDto
}