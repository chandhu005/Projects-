package net.chandhuguides.SpringBoot_Transaction.managment.Service.Impl;

import jakarta.transaction.Transactional;
import net.chandhuguides.SpringBoot_Transaction.managment.Dto.OrderRequest;
import net.chandhuguides.SpringBoot_Transaction.managment.Dto.OrderResponse;
import net.chandhuguides.SpringBoot_Transaction.managment.Exception.PaymentException;
import net.chandhuguides.SpringBoot_Transaction.managment.Repository.OrderRepository;
import net.chandhuguides.SpringBoot_Transaction.managment.Repository.PaymentRepository;
import net.chandhuguides.SpringBoot_Transaction.managment.Service.OrderService;
import net.chandhuguides.SpringBoot_Transaction.managment.entity.Order;
import net.chandhuguides.SpringBoot_Transaction.managment.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }
@Transactional
    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        //To save the order Details
        Order order=orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        orderRepository.save(order);
        Payment payment=orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")){
throw new PaymentException("Payment card Type do not Support");
        }
        // TO save Payment Details
        payment.setOrderId(order.getId());//need to get payment for Particular order
        paymentRepository.save(payment);
        OrderResponse orderResponse=new OrderResponse();
        orderResponse.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
