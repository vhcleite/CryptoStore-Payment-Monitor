package com.cryptostore.paymentmonitor.scheduler

import com.cryptostore.paymentmonitor.integration.dtos.RaidenPaymentEvent
import com.cryptostore.paymentmonitor.integration.services.PurchaseService
import com.cryptostore.paymentmonitor.integration.services.RaidenPaymentService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class PaymentMonitor {

    private val logger = LoggerFactory.getLogger(PaymentMonitor::class.java)

    @Autowired
    lateinit var paymentService: RaidenPaymentService;

    @Autowired
    lateinit var purchaseService: PurchaseService

    @Scheduled(fixedDelay = 1000)
    fun reportTime() {
        logger.info("The time is now ${DateTimeFormatter.ISO_LOCAL_TIME.format(LocalDateTime.now())}")

        //consultar os boletos pendentes não vencidos
        val purchases = purchaseService.getAllOpenPurchases();

        //consultar os pagamentos feitos no raiden
        val paymentIds = paymentService.getPayments()
                .filter {pa -> pa.paymentEvent == RaidenPaymentEvent.EventPaymentReceivedSuccess}
                .map { pa -> pa.identifier }

        // filtra compras pagas
        val purchasesToUpdate = purchases?.filter { pu -> paymentIds.contains(pu.purchaseId.toString()) }

        //atualizar os pagamentos novos
        purchasesToUpdate?.forEach { purchase ->
            purchase.paymentDateTime = LocalDateTime.now();
            purchaseService.updatePurchase(purchase);
        }
    }

}