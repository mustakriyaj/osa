package com.project.osa.service;

import com.project.osa.dto.CustomerDto;
import com.project.osa.model.Customer;
import com.project.osa.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomer(){
        return this.customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public Customer updateCustomer(CustomerDto customerDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerDto.getId());

        Customer updatedCustomer = optionalCustomer.get();
        updatedCustomer.setFirstName(customerDto.getFirstName());
        updatedCustomer.setLastName(customerDto.getLastName());
        updatedCustomer.setUserId(customerDto.getUserId());
        updatedCustomer.setPassword(customerDto.getPassword());
        updatedCustomer.setGender(customerDto.getGender());
        updatedCustomer.setStreetNo(customerDto.getStreetNo());
        updatedCustomer.setCity(customerDto.getCity());
        updatedCustomer.setState(customerDto.getState());
        updatedCustomer.setCountry(customerDto.getCountry());
        updatedCustomer.setPinCode(customerDto.getPinCode());

        return this.customerRepository.save(updatedCustomer);
    }
}
