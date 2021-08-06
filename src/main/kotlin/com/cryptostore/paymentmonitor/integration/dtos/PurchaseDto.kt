package com.cryptostore.paymentmonitor.integration.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class PurchaseDto(

        @JsonProperty("id_compra")
        val purchaseId: Long,

        @JsonProperty("user_id")
        val userId: String,

        @JsonProperty("content_id")
        val contentId: Long,

        @JsonProperty("value")
        val value: Double,

        @JsonProperty("data_hora_compra")
        val creationDateTime: LocalDateTime,

        @JsonProperty("data_hora_vencimento_pagamento")
        val expirationDateTime: LocalDateTime,

        @JsonProperty("data_hora_pagamento")
        var paymentDateTime: LocalDateTime?
)