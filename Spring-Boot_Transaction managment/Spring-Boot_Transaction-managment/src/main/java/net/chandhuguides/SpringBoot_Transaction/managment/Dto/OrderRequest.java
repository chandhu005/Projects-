package net.chandhuguides.SpringBoot_Transaction.managment.Dto;

import lombok.Getter;
import lombok.Setter;
import net.chandhuguides.SpringBoot_Transaction.managment.entity.Order;
import net.chandhuguides.SpringBoot_Transaction.managment.entity.Payment;
@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
