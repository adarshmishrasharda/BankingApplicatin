package com.user1.account_management_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user1.account_management_service.entity.Customer;
import com.user1.account_management_service.entity.account;
import com.user1.account_management_service.repo.Account_repo;

@RestController
//@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private Account_repo accountrepo;
	
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/accounts/{acc_id}")
	public ResponseEntity<account> getSingleAccount(@PathVariable Integer acc_id){
		Customer customer=restTemplate.getForObject("http://USER-SERVICE/customer/"+acc_id,Customer.class);
		
		account ac=accountrepo.findById(acc_id).get();
		ac.setCustomer(customer);
		return ResponseEntity.ok(ac);
	}
	
	@GetMapping("/delete/{acc_id}")
	public void deleteAccount(@PathVariable Integer acc_id){
	account accou=accountrepo.findById(acc_id).get();
	if(accou!=null) {
	accountrepo.deleteById(acc_id);}
	else {}
	}
	
	@PutMapping("/deposite/{acNo}")
	public ResponseEntity<account> depositeMoney(@PathVariable Integer acNo, @RequestBody account ac) {
		
		account acc=accountrepo.getOne(acNo);
		
		if(null!=acc) {
			
			acc.setBalance(ac.getBalance()+acc.getBalance());
			return ResponseEntity.ok(accountrepo.save(acc));
			
		}
		return null;
	}
		
		@PutMapping("/withdraw/{acNo}")
		public ResponseEntity<account> withdrawMoney(@PathVariable Integer acNo, @RequestBody account ac) {
			
			account acc=accountrepo.getOne(acNo);
			
			if(null!=acc) {
				
				acc.setBalance(acc.getBalance()-ac.getBalance());
				return ResponseEntity.ok(accountrepo.save(acc));
				
			}
		return null;
	}
	

}
