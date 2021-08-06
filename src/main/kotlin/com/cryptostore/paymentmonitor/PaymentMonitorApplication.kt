package com.cryptostore.paymentmonitor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
class PaymentMonitorApplication

fun main(args: Array<String>) {
	runApplication<PaymentMonitorApplication>(*args)
}
