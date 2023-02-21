package com.user.customer_management_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.customer_management_service.entity.Customer;
import com.user.customer_management_service.entity.account;
import com.user.customer_management_service.repo.CustomerRepo;

import antlr.collections.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepo customerrepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		return ResponseEntity.ok(customerrepo.save(customer));
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getSingleCustomer(@PathVariable String id){
		return ResponseEntity.ok(customerrepo.findById(id).get());
	}
	
	@GetMapping("/all")
	public ResponseEntity<java.util.List<Customer>> getAllCustomer(){
		return ResponseEntity.ok(customerrepo.findAll());
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable String id){
		
		account acc=restTemplate.getForObject("http://ACCOUNT-SERVICE/delete/"+id,account.class);
		Customer customer=customerrepo.findById(id).get();
				if(customer!=null) {
					customerrepo.delete(customer);
					
					customer.setAccount(acc);
			
				}
				else {
					//return null;
				}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		return ResponseEntity.ok(customerrepo.save(customer));
	}
	
	
	

}
