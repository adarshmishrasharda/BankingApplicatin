package com.user.customer_management_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.customer_management_service.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer ,String> {

}
