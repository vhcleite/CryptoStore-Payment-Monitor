package com.cryptostore.paymentmonitor.scheduler

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class PaymentMonitor {

    private val logger = LoggerFactory.getLogger(PaymentMonitor::class.java)

    @Scheduled(fixedDelay = 5000)
    fun reportTime() {
        logger.info("The time is now ${DateTimeFormatter.ISO_LOCAL_TIME.format(LocalDateTime.now())}")
    }

}