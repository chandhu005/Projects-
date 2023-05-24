package net.chandhuguides.SpringBoot_Transaction.managment.Exception;

public class PaymentException extends RuntimeException{
    public PaymentException(String message){
        super(message);
    }
}
