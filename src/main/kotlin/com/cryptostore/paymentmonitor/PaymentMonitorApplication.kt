package com.cryptostore.paymentmonitor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class PaymentMonitorApplication

fun main(args: Array<String>) {
	runApplication<PaymentMonitorApplication>(*args)
}
