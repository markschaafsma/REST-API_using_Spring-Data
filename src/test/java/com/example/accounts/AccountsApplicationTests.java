package com.example.accounts;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AccountsApplicationTests {

	@Autowired
	private AccountsApplication accountsApplication;

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	public void testContextLoads() throws Exception {
		assertThat(accountsApplication).isNotNull();
	}

	@Test
	public void testGetAccountById() throws Exception {

		WebTestClient
			.bindToServer()
			.baseUrl("http://localhost:" + port)
			.build()
			.get()
			.uri("/accounts/1")
			.exchange()
			.expectStatus().isOk()
			.expectHeader().valueEquals("Content-Type", "application/hal+json")
			.expectBody().jsonPath("acctNo").isEqualTo("585309209");
	}

	@Test
	public void testGetAccountByAcctNoA() throws Exception {

		WebTestClient
			.bindToServer()
			.baseUrl("http://localhost:" + port)
			.build()
			.get()
			.uri("/accounts/search/findByAcctNo?acctNo=585309209")
			.exchange()
			.expectStatus().isOk()
			.expectHeader().valueEquals("Content-Type", "application/hal+json")
			.expectBody().jsonPath("acctNo").isEqualTo("585309209");
	}

	@Test
	public void testGetAccountByAcctNoB() throws Exception {

		WebTestClient
			.bindToServer()
			.baseUrl("http://localhost:" + port)
			.build()
			.get()
			.uri("/accounts/search/findByAcctNo?acctNo=000001")
			.exchange()
			.expectStatus().isNotFound()
			.expectHeader().valueEquals("Content-Length", 0);
	}

	@Test
	public void testDeleteAccountById() throws Exception {

		WebTestClient
			.bindToServer()
			.baseUrl("http://localhost:" + port)
			.build()
			.delete()
			.uri("/accounts/1")
			.exchange()
			.expectStatus().isEqualTo(405)
			.expectHeader().valueEquals("Content-Length", 0);
	}

	@Test
	public void testGetTransactions() throws Exception {

		WebTestClient
			.bindToServer()
			.baseUrl("http://localhost:" + port)
			.build()
			.get()
			.uri("/transactions/")
			.exchange()
			.expectStatus().isOk()
			.expectHeader().valueEquals("Content-Type", "application/hal+json")
			.expectBody().jsonPath("transactions");
	}

}
