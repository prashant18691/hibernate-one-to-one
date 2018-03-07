package com.prs.hibernateonetoone;

import com.prs.hibernateonetoone.dao.TestDao;
import com.prs.hibernateonetoone.entity.Customer;
import com.prs.hibernateonetoone.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HibernateOneToOneApplication implements CommandLineRunner{

	@Autowired
	TestDao dao;

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneToOneApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		dao.saveData(buildDemoTransaction());
	}

	private static Transaction buildDemoTransaction() {
		Transaction txn = new Transaction();
		txn.setDate(new Date());
		txn.setTotal(100);

		Customer cust = new Customer();
		cust.setAddress("San Jose, USA");
		cust.setEmail("pankaj@yahoo.com");
		cust.setName("Pankaj Kr");

		txn.setCustomer(cust);

		cust.setTxn(txn);
		return txn;
	}
}
