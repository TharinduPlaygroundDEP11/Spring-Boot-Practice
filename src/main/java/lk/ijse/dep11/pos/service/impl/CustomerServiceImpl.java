package lk.ijse.dep11.pos.service.impl;

import lk.ijse.dep11.pos.dto.CustomerDTO;
import lk.ijse.dep11.pos.dto.request.CustomerUpdateDTO;
import lk.ijse.dep11.pos.entity.Customer;
import lk.ijse.dep11.pos.repository.CustomerRepo;
import lk.ijse.dep11.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepo.findAll();

        if (customerList.size() > 0) {
            List<CustomerDTO> customerDTOList = new ArrayList<>();
            for (Customer customer : customerList) {
                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getContactNumbers(),
                        customer.getNic(),
                        customer.isActiveStatus()
                );
                customerDTOList.add(customerDTO);
            }
            return customerDTOList;
        } else {
          throw new RuntimeException("No Customers in the database");
        }
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "Customer Deleted";
        } else {
            throw new RuntimeException("No Customer Records to delete");
        }
    }
}
