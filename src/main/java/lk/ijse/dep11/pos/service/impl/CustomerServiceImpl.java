package lk.ijse.dep11.pos.service.impl;

import lk.ijse.dep11.pos.dto.CustomerDTO;
import lk.ijse.dep11.pos.dto.request.CustomerUpdateDTO;
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

    @Override
    public CustomerDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo
                    .getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setNic(customerUpdateDTO.getNic());
            customerRepo.save(customer);

            return new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.isActiveStatus()
            );

        } else {
            throw new RuntimeException("No Customer found for that Id");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            return new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.isActiveStatus()
            );
        } else {
            throw new RuntimeException("No Customer found for that ID");
        }
    }
}
