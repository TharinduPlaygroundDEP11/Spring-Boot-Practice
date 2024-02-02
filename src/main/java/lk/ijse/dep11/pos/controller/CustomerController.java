package lk.ijse.dep11.pos.controller;

import lk.ijse.dep11.pos.dto.CustomerDTO;
import lk.ijse.dep11.pos.dto.request.CustomerUpdateDTO;
import lk.ijse.dep11.pos.service.CustomerService;
import lk.ijse.dep11.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    @PostMapping("/save")
//    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
//        customerService.saveCustomer(customerDTO);
//        return "Customer Saved";
//    }

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        String message = customerService.saveCustomer(customerDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201,
                        "Successfully Saved!",
                        message),
                HttpStatus.CREATED
        );
        return responseEntity;
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

//    @GetMapping(
//            path = {"/get-all-customers"}
//    )
//    public List<CustomerDTO> getAllCustomers() {
//        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
//        return allCustomers;
//    }

    @GetMapping(
            path = {"/get-all-customers"}
    )
    public ResponseEntity<StandardResponse> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "Success!",
                        allCustomers
                ) , HttpStatus.OK
        );
        return responseEntity;
    }

    @DeleteMapping(
            path = "/delete-by-id/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }

    @GetMapping(
            path = {"/get-all-customers-by-active-state"},
            params = {"status"}
    )
    public List<CustomerDTO> getCustomerByActiveState(@RequestParam(value = "status") boolean status) {
        List<CustomerDTO> customerList = customerService.getCustomersByActiveState(status);
        return customerList;
    }
}
