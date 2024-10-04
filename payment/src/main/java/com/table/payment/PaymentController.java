package com.table.payment;

import com.table.payment.request.PaymentRequest;
import com.table.payment.response.PaymentResponse;
import com.table.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @ResponseBody
    @PostMapping("/authorize-payment")
    public PaymentResponse authorizePayment(@RequestBody PaymentRequest paymentRequest)
    {
        PaymentResponse response=new PaymentResponse();
        if(paymentRequest!=null)
        {
            return paymentService.authorizePayment(paymentRequest);
        }

        return response;
    }
}
