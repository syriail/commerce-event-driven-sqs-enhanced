package com.ghrer.commerce.eventor.agent.adaptor

import io.awspring.cloud.sqs.operations.SqsTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class OrderServiceSqsSender(
    sqsTemplate: SqsTemplate,
    @Value("\${aws-resources.orderServiceEventsQueueUrl}")
    private val queueUrl: String,
) : SqsEventSenderAdaptor(sqsTemplate, queueUrl)
