package com.softcaribbean.challenge.elverarroyave;

import com.softcaribbean.challenge.elverarroyave.model.Client;
import com.softcaribbean.challenge.elverarroyave.repository.ClientRepository;
import com.softcaribbean.challenge.elverarroyave.service.BST;
import com.softcaribbean.challenge.elverarroyave.service.BSTImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SoftwareDevelopmentExamApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(SoftwareDevelopmentExamApplication.class, args);

		//Beans
		ClientRepository clientRepository = configurableApplicationContext.getBean(ClientRepository.class);

		//We create the tree
		BSTImpl bst = new BSTImpl();

		List<Client> clients = clientRepository.findAll();

		clients.forEach(bst::insert);

		System.out.println("Amount: " + bst.getAmount());

		System.out.println("Get client: " + bst.get(999).fullName());
	}
}
