package com.ghrer.commerce.eventor.agent.adaptor

import com.ghrer.commerce.eventor.agent.port.QueueEventSender
import com.ghrer.commerce.eventor.event.model.CommerceEvent
import io.awspring.cloud.sqs.operations.SqsTemplate

abstract class SqsEventSenderAdaptor(
    private val sqsTemplate: SqsTemplate,
    private val queueUrl: String
) : QueueEventSender {
    override fun send(event: CommerceEvent) {
        sqsTemplate.send {
            it.queue(queueUrl)
            it.header(SQS_GROUP_ID_HEADER, event.eventGroupId)
            it.payload(event)
        }
    }

    companion object {
        const val SQS_GROUP_ID_HEADER = "message-group-id"
    }
}
