package com.enigmacamp.JasaQ;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.enigmacamp.JasaQ.dto.AccountAddBalance;
import com.enigmacamp.JasaQ.dto.ClientDto;
import com.enigmacamp.JasaQ.dto.MitraDto;
import com.enigmacamp.JasaQ.dto.PaymentToMitra;
import com.enigmacamp.JasaQ.dto.TransactionDto;
import com.enigmacamp.JasaQ.dto.WithdrawMitraDto;
import com.enigmacamp.JasaQ.entity.Client;
import com.enigmacamp.JasaQ.entity.Mitra;
import com.enigmacamp.JasaQ.entity.ServicesMitra;
import com.enigmacamp.JasaQ.entity.Transaction;
import com.enigmacamp.JasaQ.enums.Role;
import com.enigmacamp.JasaQ.enums.Status;
import com.enigmacamp.JasaQ.exceptions.NotFoundException;
import com.enigmacamp.JasaQ.repository.ClientRepository;
import com.enigmacamp.JasaQ.repository.MitraRepository;
import com.enigmacamp.JasaQ.repository.ServicesMitraRepository;
import com.enigmacamp.JasaQ.repository.TransactionRepository;
import com.enigmacamp.JasaQ.services.ClientServices;
import com.enigmacamp.JasaQ.services.MitraServices;
import com.enigmacamp.JasaQ.services.MitraServicesServices;
import com.enigmacamp.JasaQ.services.TransactionServices;

@RunWith(SpringRunner.class)
public class TransactionServicesTests {
	
	@TestConfiguration
	static class TransactionServiceContextConfiguration {
		@Bean
		public TransactionServices transactionService() {
			return new TransactionServices();
		}
	}
	
	@Autowired
	private TransactionServices transactionServices;
	
	@MockBean
	private MitraServicesServices mitraServicesServices;
	
	@MockBean
	private TransactionRepository transactionRepository;
	
	@MockBean
	private ClientServices clientServ;
	
	@MockBean
	private MitraServices mitraServ;
	
	@Before
	public void setup() {
		
		Date udate = new Date();
		java.sql.Date date = new java.sql.Date(udate.getTime());
		Client client = new Client("JasaQ", "jasaQ", "123123", "photo", "jasaQ@jasaQ.net", "08182834821", "Jln simatupang 21", 0.0);
		Mitra mitra = new Mitra("Mitra1"
				, "mitra"
				, "123234"
				, "mitra@mitra.com"
				, "mitraphoto"
				, Status.AVAILABLE
				, "08208252123"
				, "Jln Keturan 24 Jaksel", 
				0.0, 
				Role.ADMIN, 
				mitraServicesServices.convertEntity(mitraServicesServices.getByName("AC")), 1000.0);
		TransactionDto dto = new TransactionDto(date, 1000.0, "services AC");
		dto.setDate(java.sql.Date.valueOf("2020-04-25"));
		dto.setId(1L);
		dto.setDescription("Service AC");
		dto.setPrice(1000.0);
		Transaction tf = new Transaction();
		tf.setId(1L);
		tf.setDate(java.sql.Date.valueOf("2020-04-25"));
		tf.setDescription("Services AC");
		tf.setPrice(1000.0);
		tf.setTransactionClient(client);
		tf.setTransactionMitra(mitra);
		
		List<Transaction> dtos = new ArrayList<Transaction>();
		dtos.add(tf);
		Mockito.when(transactionRepository.save(tf)).thenReturn(tf);
		Mockito.when(transactionRepository.findAll()).thenReturn(dtos);
		Mockito.when(transactionRepository.findByTransactionClient(client)).thenReturn(dtos);
		Mockito.when(transactionRepository.findByTransactionMitra(mitra)).thenReturn(dtos);
		
		Client newClient = new Client(1L, "Test", "test", "password", "photoProfile", "test@test.com", "08182832451", "Jl simatupang 23 Jakarta Utara", 0.0);
		ClientDto dtoClient = clientServ.convertClientDto(newClient);
		List<Client> clientList = new ArrayList<Client>();
		clientList.add(newClient);
		Mockito.when(clientServ.getByUsernameIgnoreCase("test")).thenReturn(dtoClient);
		Mockito.when(clientServ.getByUsername("test", "password")).thenReturn(dtoClient);
		Mockito.when(clientServ.getAll()).thenReturn(clientList);
		
		Mitra newMitra = new Mitra(1L, "mitraTes", "mitraTest", "123123", "mitra@maira", "photo mitra", Status.AVAILABLE, "084283284123", "Jln jln Test", 0.0, Role.MITRA, mitraServicesServices.convertEntity(mitraServicesServices.getByName("AC")), 1000.0); 
		MitraDto dtoMitra = mitraServ.convertDto(newMitra);
		List<Mitra> mitraList = new ArrayList<Mitra>();
		Mockito.when(mitraServ.getByUsername("mitraTest")).thenReturn(dtoMitra);
		Mockito.when(mitraServ.getMitraByUsernameAndPassword("mitraTest", "123123")).thenReturn(dtoMitra);
		Mockito.when(mitraServ.getAll()).thenReturn(mitraList);
	}
	
	@Test
	public void whenFindAll_ReturnTransactionList() throws NotFoundException {
		List<Transaction> tf = transactionServices.getAll();
		assertEquals(tf.size(), 1);
		transactionServices.checkBalanceClient(new ClientDto(1L, "a", "a", "a", "adadada", "adadad", "0808088", "ayayayaya", 0.0), new MitraDto("b", "b", "b", "adad", "adad", Status.AVAILABLE, "00808080", "adad", 0.0, Role.MITRA, 1000.0));
	}
	
	@Test
	public void convertMethod_returnConvert() throws NotFoundException {
		Transaction tf = new Transaction();
		transactionServices.convertDto(tf);
		TransactionDto dtoTf = new TransactionDto();
		transactionServices.convertEntity(dtoTf);
	}
	
	@Test
	public void whenPayToMitra_returnPayToMitra()throws NotFoundException {
		transactionServices.deleteById(1L);
		Client newClient = new Client(1L, "Test", "test", "password", "photoProfile", "test@test.com", "08182832451", "Jl simatupang 23 Jakarta Utara", 0.0);
		Mitra newMitra = new Mitra(1L, "mitraTes", "mitraTest", "123123", "mitra@maira", "photo mitra", Status.AVAILABLE, "084283284123", "Jln jln Test", 0.0, Role.MITRA, mitraServicesServices.convertEntity(mitraServicesServices.getByName("AC")), 1000.0);
		assertEquals(transactionServices.payToMitra(new PaymentToMitra(newClient.getUsername(), newMitra.getUsername())),"Services Sepatu");
	}
	
	@Test
	public void whenPostBalance_ReturnBalance() throws NotFoundException {
		Client newClient = new Client(1L, "Test", "test", "password", "photoProfile", "test@test.com", "08182832451", "Jl simatupang 23 Jakarta Utara", 0.0);
		assertEquals(transactionServices.postBalance(new AccountAddBalance(newClient.getUsername(), 1000.0)), "Topup saldo " + 1000.0 + " berhasil");
	}
	
	@Test
	public void whenGetListTransactionByMitra_returnListTransaction() throws NullPointerException {
		Mitra newMitra = new Mitra(1L, "mitraTes", "mitraTest", "123123", "mitra@maira", "photo mitra", Status.AVAILABLE, "084283284123", "Jln jln Test", 0.0, Role.MITRA, mitraServicesServices.convertEntity(mitraServicesServices.getByName("AC")), 1000.0);
		assertEquals(transactionServices.getListTransactionByMitra(newMitra.getUsername()).size(), 0);
	}
	
	@Test
	public void whenGetListTransactionByClient_returnListTransaction() throws NotFoundException {
		Client newClient = new Client(1L, "Test", "test", "password", "photoProfile", "test@test.com", "08182832451", "Jl simatupang 23 Jakarta Utara", 0.0);
		assertEquals(transactionServices.getListTransactionByClient(newClient.getUsername()).size(), 0);
	}
	
//	@Test
//	public void whenWithDraw_getTransactionDto() throws NotFoundException {
//		Mitra newMitra = new Mitra(1L, "mitraTes", "mitraTest", "123123", "mitra@maira", "photo mitra", Status.AVAILABLE, "084283284123", "Jln jln Test", 1000.0, Role.MITRA, mitraServicesServices.convertEntity(mitraServicesServices.getByName("AC")), 1000.0);
//		assertEquals(transactionServices.withDraw(new WithdrawMitraDto("mitraTest", "123123", 1000.0)), "123123");
//	}
	
	@Test
	public void whenCheckBalanceMitra_returnBalance() {
		MitraDto newMitra = new MitraDto("Ada", "adad", "123123", "a", "photoProfile", Status.AVAILABLE, "08080808080", "Kkjera", 1000.0, Role.MITRA, 1000.0);
		transactionServices.checkBalanceMitra(newMitra);
	}
	
}
