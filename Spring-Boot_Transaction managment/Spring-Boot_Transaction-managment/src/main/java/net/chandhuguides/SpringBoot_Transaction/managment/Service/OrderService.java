package net.chandhuguides.SpringBoot_Transaction.managment.Service;

import net.chandhuguides.SpringBoot_Transaction.managment.Dto.OrderRequest;
import net.chandhuguides.SpringBoot_Transaction.managment.Dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);

}
