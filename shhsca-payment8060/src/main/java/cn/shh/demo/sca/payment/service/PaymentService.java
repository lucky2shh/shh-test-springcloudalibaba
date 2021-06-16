package cn.shh.demo.sca.payment.service;

import cn.shh.demo.sca.common.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * 接口特点：
 *   - 其属性默认被 public static final 修饰，可省略，但必须赋初值；
 *   - 其方法被 public abstract 修饰，可省略；
 */
public interface PaymentService {
    public abstract int add(Payment payment);
    public abstract Payment getPaymentById(@Param("id") Long id);
}
