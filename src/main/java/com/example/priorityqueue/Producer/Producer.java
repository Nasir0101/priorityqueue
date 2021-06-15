package com.example.priorityqueue.Producer;

import com.example.priorityqueue.DbModel.VisaInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Producer {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final String queueName, final VisaInformation message) {
        try {
            HashMap<String, String> mappedObject = new HashMap<>();
            mappedObject.put("username", message.getUsername());
            mappedObject.put("cnic", message.getCnic());
            mappedObject.put("status", message.getStatus());
            mappedObject.put("country", message.getCountry());

            jmsTemplate.convertAndSend(queueName, mappedObject);
        } catch (Exception exception) {
            System.out.println("Recieved Exception during send Message: " + exception);
        }
    }

}
