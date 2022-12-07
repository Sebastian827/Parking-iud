package com.iudigital.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.models.ReceiptPayment;

@Repository
public interface ReceiptPaymentRepository extends CrudRepository<ReceiptPayment, Long> {

}
