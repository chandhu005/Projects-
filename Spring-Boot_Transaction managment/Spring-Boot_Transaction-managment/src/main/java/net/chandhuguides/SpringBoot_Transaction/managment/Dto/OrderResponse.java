package net.chandhuguides.SpringBoot_Transaction.managment.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderResponse {
    private String orderTrackingNumber;
    private String status;
    private String message;

}
