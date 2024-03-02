package com.shop.ecommerce.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
public class PaimentRequestDto {

    private String amount;
    
    private String paymentMethod;
    
    private String cardNumber;
    
    private String expiryDate;
    
    private String cvv;
}
