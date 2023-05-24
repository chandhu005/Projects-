package net.chandhuguides.SpringBoot_Transaction.managment.Controller;

import net.chandhuguides.SpringBoot_Transaction.managment.Dto.OrderRequest;
import net.chandhuguides.SpringBoot_Transaction.managment.Dto.OrderResponse;
import net.chandhuguides.SpringBoot_Transaction.managment.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/orders")
@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }

}
