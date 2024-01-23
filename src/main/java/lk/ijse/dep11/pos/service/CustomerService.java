package lk.ijse.dep11.pos.service;

import lk.ijse.dep11.pos.dto.CustomerDTO;
import lk.ijse.dep11.pos.dto.request.CustomerUpdateDTO;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    public CustomerDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    public CustomerDTO getCustomerById(int customerId);
}
