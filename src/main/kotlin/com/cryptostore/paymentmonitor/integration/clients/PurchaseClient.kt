package com.cryptostore.paymentmonitor.integration.clients

import com.cryptostore.paymentmonitor.integration.dtos.PurchaseDto
import com.cryptostore.paymentmonitor.integration.dtos.PurchaseStatus
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("purchase", url = "http://localhost:8083/")
interface PurchaseClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["store/v1/purchase"])
    fun getOpenPurchases(@RequestParam("status") purchaseStatus: PurchaseStatus): ResponseEntity<List<PurchaseDto>>

    @RequestMapping(method = [RequestMethod.PUT], value = ["store/v1/users/{userId}/purchase/{purchaseId}"])
    fun update(@RequestParam("purchaseId") purchaseId: Long,
               @RequestParam("userId") userId: String,
               @RequestBody purchase: PurchaseDto);
}