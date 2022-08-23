package com.cts.processPension;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import com.cts.processPension.controller.ProcessPensionController;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProcessPensionApplicationTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	ProcessPensionController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}