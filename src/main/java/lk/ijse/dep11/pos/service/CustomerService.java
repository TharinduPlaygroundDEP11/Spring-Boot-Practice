package lk.ijse.dep11.pos.service;

import lk.ijse.dep11.pos.dto.CustomerDTO;
import lk.ijse.dep11.pos.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    public CustomerDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    public CustomerDTO getCustomerById(int customerId);

    public List<CustomerDTO> getAllCustomers();

    public String deleteCustomer(int customerId);

    public List<CustomerDTO> getCustomersByActiveState(boolean status);
}
