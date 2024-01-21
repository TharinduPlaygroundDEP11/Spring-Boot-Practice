package lk.ijse.dep11.pos.service.impl;

import lk.ijse.dep11.pos.dto.CustomerDTO;
import lk.ijse.dep11.pos.entity.Customer;
import lk.ijse.dep11.pos.repository.CustomerRepo;
import lk.ijse.dep11.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumbers(),
                customerDTO.getNic(),
                customerDTO.isActiveStatus()
        );

        customerRepo.save(customer);
        return customerDTO.getCustomerName() + " Saved";
    }
}
