package lk.ijse.dep11.pos.controller;

import lk.ijse.dep11.pos.dto.CustomerDTO;
import lk.ijse.dep11.pos.dto.request.CustomerUpdateDTO;
import lk.ijse.dep11.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return "Customer Saved";
    }

    @PutMapping("/update") // if you want you can write this as @PutMapping({"/update"})
    public CustomerDTO updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        return customerService.updateCustomer(customerUpdateDTO);
    }

    @GetMapping(
            path = {"/get-by-id"},
            params = {"id"}
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping(
            path = {"/get-all-customers"}
    )
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(
            path = "/delete-by-id/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }
}
