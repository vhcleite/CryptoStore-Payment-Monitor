package com.cryptostore.paymentmonitor.integration.services

import com.cryptostore.paymentmonitor.integration.clients.PurchaseClient
import com.cryptostore.paymentmonitor.integration.dtos.PurchaseDto
import com.cryptostore.paymentmonitor.integration.dtos.PurchaseStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class PurchaseService {

    @Autowired
    lateinit var purchaseClient: PurchaseClient;

    fun getAllOpenPurchases(): List<PurchaseDto>? {
        val response = purchaseClient.getOpenPurchases(PurchaseStatus.PENDING_PAYMENT);
        return if(response.statusCode == HttpStatus.OK) response.body else arrayListOf<PurchaseDto>()
    }

    fun updatePurchase(purchase: PurchaseDto) {
        purchaseClient.update(purchase.purchaseId, purchase.userId, purchase);
    }

}