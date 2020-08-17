package com.glodon.springcloud.controller;

import com.glodon.springcloud.entities.CommonResult;
import com.glodon.springcloud.entities.Payment;
import com.glodon.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "payment/create", method = RequestMethod.POST)
    public CommonResult createPayment(@RequestBody Payment payment){

        CommonResult commontResult;

        int result = paymentService.createPayment(payment);
        if(result > 0){
            commontResult = new CommonResult(200,"添加成功!端口号是："+serverPort, result);
        }else{
            commontResult = new CommonResult<Payment>(404,"添加失败!端口号是："+serverPort,null);
        }

        return  commontResult;
    }

    @RequestMapping(value = "payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        CommonResult commontResult;

        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            commontResult =  new CommonResult<Payment>(200, "查询成功!端口号是："+serverPort, payment);
        }else{
            commontResult =  new CommonResult<Payment>(404, "查询失败！端口号是："+serverPort, null);
        }

        return commontResult;
    }

}
