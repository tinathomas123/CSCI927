package com.table.payment.service;

import com.table.payment.repository.PaymentRepository;
import com.table.payment.request.PaymentRequest;
import com.table.payment.response.PaymentResponse;
import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentService {

    @Autowired
    private PaymentRepository tableRepo;

    @Autowired
    private ModelMapper mapper;

    public PaymentResponse authorizePayment(PaymentRequest paymentRequest)
    {
        PaymentResponse paymentResponse=new PaymentResponse();

        String cardNumber=paymentRequest.getCardNumber();
        String cvv=paymentRequest.getCvv();
        String cardExpiryDate=paymentRequest.getCardExpiryDate();
        String customerName=paymentRequest.getCustomerName();
        if(Strings.isNotBlank(cardNumber) && Strings.isNotBlank(cvv)
                && Strings.isNotBlank(cardExpiryDate) && Strings.isNotBlank(customerName))
        {
            paymentResponse.setAuthorized(true);
        }

        return paymentResponse;
    }
}
