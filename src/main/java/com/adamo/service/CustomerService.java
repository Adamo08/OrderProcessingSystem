package com.adamo.service;

import com.adamo.dao.CustomerDao;
import com.adamo.model.Customer;

public class CustomerService {

    private final CustomerDao customerDao = new CustomerDao();

    public boolean validateCustomer(String customerId) {
        Customer customer = customerDao.getCustomerById(customerId);
        return customer != null;
    }

    public Customer getCustomerDetails(String customerId) {
        return customerDao.getCustomerById(customerId);
    }
}
