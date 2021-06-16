package cn.shh.demo.sca.payment.dao;

import cn.shh.demo.sca.common.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int add(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
