package com.stackroute.fitnesszone.productservice.entity;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Program {

    @Id
    private String programCode;
    private String programName;
    private String description;
    private int durationInMonths;
    private float price;
    private float discountRate;
    private float discountedPrice;
    private boolean active;

    public void calculateDiscountedPrice() {
        this.discountedPrice = price - ((price*discountRate)/100);
    }

}
