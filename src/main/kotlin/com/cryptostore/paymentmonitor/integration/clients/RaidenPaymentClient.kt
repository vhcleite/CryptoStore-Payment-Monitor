package com.cryptostore.paymentmonitor.integration.clients

import com.cryptostore.paymentmonitor.integration.dtos.RaidenPaymentDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("payments", url = "http://localhost:5001/api/v1/payments")
interface RaidenPaymentClient {

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = ["/{token_id}"])
    fun getOpenPurchases(@PathVariable("token_id") tokenId: String,): List<RaidenPaymentDto>
}