package cn.shh.demo.sca.payment.service.impl;

import cn.shh.demo.sca.common.entity.Payment;
import cn.shh.demo.sca.payment.dao.PaymentDao;
import cn.shh.demo.sca.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
