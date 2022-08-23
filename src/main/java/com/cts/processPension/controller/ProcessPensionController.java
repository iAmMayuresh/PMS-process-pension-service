package com.cts.processPension.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.processPension.exception.InvalidTokenException;
import com.cts.processPension.feign.AuthorisationClient;
import com.cts.processPension.model.PensionDetail;
import com.cts.processPension.model.PensionerInput;
import com.cts.processPension.model.ProcessPensionInput;
import com.cts.processPension.model.ProcessPensionResponse;
import com.cts.processPension.service.ProcessPensionServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class ProcessPensionController {

	@Autowired
	ProcessPensionServiceImpl processPensionService; 

	@Autowired
	AuthorisationClient authorisationClient;

	
	@PostMapping("/pensionerInput")
	public ResponseEntity<PensionDetail> getPensionDetails(@RequestHeader(name = "Authorization") String token,
			@RequestBody @Valid PensionerInput pensionerInput) {
		log.info("START - getPensionDetails()");
		if (!authorisationClient.validate(token)) {
			throw new InvalidTokenException("You are not allowed to access this resource");
		}
		log.info("END - getPensionDetails()");
		return new ResponseEntity<>(processPensionService.getPensionDetails(pensionerInput), HttpStatus.OK);
	}


	@PostMapping("/processPension")
	public ResponseEntity<ProcessPensionResponse> processPension(@RequestHeader(name = "Authorization") String token,
			@RequestBody @Valid ProcessPensionInput processPensionInput) {
		log.info("START - processPension()");

		if (!authorisationClient.validate(token)) {
			throw new InvalidTokenException("You are not allowed to access this resource");
		}
		log.info("END - processPension()");
		return new ResponseEntity<>(processPensionService.processPension(token, processPensionInput), HttpStatus.OK);
	}
	@GetMapping(value = "/statusCheck")
	public String statusCheck() {
		log.info("OK");
		return "Process pension microservice running successfully";
	}
}