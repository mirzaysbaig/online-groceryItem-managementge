package online.grocery.management.model;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;


import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private int customer_id;
    private String name;
    private String email;
    @Column(name="customer_num")
    private String phoneNumber;

}
