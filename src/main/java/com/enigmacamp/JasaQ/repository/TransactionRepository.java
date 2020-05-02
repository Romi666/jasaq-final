package com.enigmacamp.JasaQ.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigmacamp.JasaQ.entity.Client;
import com.enigmacamp.JasaQ.entity.Mitra;
import com.enigmacamp.JasaQ.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	void deleteById(Long Id);
	
	List<Transaction> findByTransactionClient(Client transactionClient);
	
	List<Transaction> findByTransactionMitra(Mitra transactionMitra);
	

}
