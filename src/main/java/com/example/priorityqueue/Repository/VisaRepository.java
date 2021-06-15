package com.example.priorityqueue.Repository;

import com.example.priorityqueue.DbModel.VisaInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VisaRepository extends CrudRepository<VisaInformation, Integer> {

    VisaInformation findByCnic(String cnic);
}
