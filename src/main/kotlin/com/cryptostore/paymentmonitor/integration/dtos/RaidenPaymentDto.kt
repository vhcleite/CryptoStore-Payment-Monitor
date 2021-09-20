package com.cryptostore.paymentmonitor.integration.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class RaidenPaymentDto(
        @JsonProperty("event")
        var paymentEvent: RaidenPaymentEvent,

        @JsonProperty("amount")
        var amount: String?,

        @JsonProperty("initiator")
        var initiator: String?,

        @JsonProperty("identifier")
        var identifier: String?,

        @JsonProperty("log_time")
        var paymentDateTime: LocalDateTime,

        @JsonProperty("token_address")
        var tokenAddress: String,

        @JsonProperty("target")
        var targetAccount: String?
)