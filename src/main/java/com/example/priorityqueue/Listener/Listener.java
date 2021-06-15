package com.example.priorityqueue.Listener;

import com.example.priorityqueue.Service.VisaSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.util.HashMap;

@Component
public class Listener {

    @Autowired
    private final VisaSrevice visaSrevice;


    public Listener(VisaSrevice visaSrevice) {
        this.visaSrevice = visaSrevice;
    }

    @JmsListener(destination = "inbound.queue")
    public void receiveMessage(final HashMap<String, String> object) throws JMSException {

        visaSrevice.verifyInformationAndUpdateResult(object);


    }


}
