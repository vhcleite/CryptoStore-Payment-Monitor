package com.cryptostore.paymentmonitor.integration.services

import com.cryptostore.paymentmonitor.integration.clients.RaidenPaymentClient
import com.cryptostore.paymentmonitor.integration.dtos.RaidenPaymentDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class RaidenPaymentService {


    val tokenAddress: String = "0x95B2d84De40a0121061b105E6B54016a49621B44";

    @Autowired
    lateinit var paymentClient: RaidenPaymentClient;

    fun getPayments() : List<RaidenPaymentDto> {
        return paymentClient.getOpenPurchases(tokenAddress);
    }


}