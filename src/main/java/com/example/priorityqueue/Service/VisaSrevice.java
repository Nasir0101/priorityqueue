package com.example.priorityqueue.Service;


import com.example.priorityqueue.DbModel.VisaInformation;
import com.example.priorityqueue.Repository.VisaRepository;
import org.hibernate.JDBCException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class VisaSrevice {

    private final VisaRepository visaRepository;


    public VisaSrevice(VisaRepository visaRepository) {
        this.visaRepository = visaRepository;
    }


    public String saveUserDetailInDb(VisaInformation visaInformation) {
        visaInformation.setStatus("InProcess");
        try {
            visaRepository.save(visaInformation);
            return visaInformation.getCnic();
        } catch (JDBCException exception) {
            System.out.println("Exception while saving Object " + exception.getMessage());

        }

        return "Some Error Occurred, please try again!";

    }


    public void verifyInformationAndUpdateResult(HashMap<String, String> object) {

        VisaInformation visaInformation = visaRepository.findByCnic(object.get("cnic"));

        if (visaInformation != null) {

            if ((visaInformation.getStatus()).equals("InProcess")) {

                if ((visaInformation.getCountry()).equals("Pakistan")) {

                    visaInformation.setStatus("Successfull");
                    try {
                        visaRepository.save(visaInformation);
                    } catch (JDBCException exception) {
                        System.out.println("Exception while saving Object " + exception.getMessage());

                    }


                } else {

                    visaInformation.setStatus("pending");
                    try {
                        visaRepository.save(visaInformation);
                    } catch (JDBCException exception) {
                        System.out.println("Exception while saving Object " + exception.getMessage());

                    }

                }
            }

        }
    }


    public String getStatusOfVisaByCnic(String cnic) {
        try {

            VisaInformation visaInformation = visaRepository.findByCnic(cnic);

            if (visaInformation != null) {
                return visaInformation.getStatus();
            }
        } catch (JDBCException exception) {
            System.out.println("Exception while getting Object " + exception.getMessage());

        }

        return "Some Error Occurred, please try again!";

    }
}
