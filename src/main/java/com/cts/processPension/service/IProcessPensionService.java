package com.cts.processPension.service;

import com.cts.processPension.model.PensionDetail;
import com.cts.processPension.model.PensionerDetail;
import com.cts.processPension.model.PensionerInput;
import com.cts.processPension.model.ProcessPensionInput;
import com.cts.processPension.model.ProcessPensionResponse;


 // Implementaion class for Process Pension
 
public interface IProcessPensionService {

	
	// This method is responsible to get the pension details if input details are valid
	 
	public PensionDetail getPensionDetails(PensionerInput pensionerInput);


	 // Calculate the pension amount and return the pensioner details according to the type of pension "self" or "family"
	 
	public PensionDetail calculatePensionAmount(PensionerDetail pensionDetail);

	
	 // Method to check the details entered by the user
	
	public boolean checkdetails(PensionerInput pensionerInput, PensionerDetail pensionerDetail);
	
	
	 // Method to get status code from the disbursement micro-service
	 
	public ProcessPensionResponse processPension(String token, ProcessPensionInput processPensionInput);
}
