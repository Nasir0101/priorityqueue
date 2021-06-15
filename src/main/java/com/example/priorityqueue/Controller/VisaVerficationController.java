package com.example.priorityqueue.Controller;


import com.example.priorityqueue.DbModel.VisaInformation;
import com.example.priorityqueue.Producer.Producer;
import com.example.priorityqueue.Service.VisaSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VisaVerficationController {


    @Autowired
    private final VisaSrevice visaSrevice;
    private final Producer producer;


    public VisaVerficationController(VisaSrevice visaSrevice, Producer producer) {
        this.visaSrevice = visaSrevice;
        this.producer = producer;
    }

    @PostMapping("/verify/visa/request")
    public ResponseEntity verifyVisaRequest(@RequestBody VisaInformation visaInfo) {
        String cnic = visaSrevice.saveUserDetailInDb(visaInfo);
        producer.sendMessage("inbound.queue", visaInfo);
        return ResponseEntity.ok("Your Visa Verification request is in progress, you can check your Visa status by CNIC : " + cnic);

    }

    @GetMapping("/check/status/{cnic}")
    public String verifyVisaRequest(@PathVariable String cnic) {
        return visaSrevice.getStatusOfVisaByCnic(cnic);

    }


}
