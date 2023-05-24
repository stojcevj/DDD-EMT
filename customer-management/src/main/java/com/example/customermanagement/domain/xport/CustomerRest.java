package com.example.customermanagement.domain.xport;

import com.example.customermanagement.domain.model.Customer;
import com.example.customermanagement.domain.model.CustomerID;
import com.example.customermanagement.domain.model.valueobjects.TotalReservations;
import com.example.customermanagement.domain.service.CustomerService;
import com.example.customermanagement.domain.service.form.CustomerForm;
import com.example.sharedkernel.domain.valueobjects.Address;
import com.example.sharedkernel.domain.valueobjects.Phone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import javax.management.InvalidAttributeValueException;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CustomerRest {
    private final CustomerService customerService;

    @GetMapping("/increaseCustomer")
    public void increaseCustomer(@RequestParam String customerId) throws InvalidAttributeValueException {
        customerService.increaseReservations(new CustomerID(customerId));
    }

    @GetMapping("/decreaseCustomer")
    public void decreaseCustomer(@RequestParam String customerId) throws InvalidAttributeValueException {
        customerService.decreaseReservations(new CustomerID(customerId));
    }

    @GetMapping("/createCustomer")
    public void createCustomer(@RequestParam String id,
                               @RequestParam String name,
                               @RequestParam String phone,
                               @RequestParam String streetName,
                               @RequestParam Integer number){
        customerService.addCustomer(id, name, Phone.of(phone), Address.of(streetName, number), new TotalReservations(0));
    }
}
