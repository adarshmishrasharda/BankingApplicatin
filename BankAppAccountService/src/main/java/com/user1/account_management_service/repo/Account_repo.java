package com.user1.account_management_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user1.account_management_service.entity.account;

public interface Account_repo extends JpaRepository<account, Integer>{

}
