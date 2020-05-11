package com.spring.calculator.webservice.endpoint;



import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.spring.calculator.webservice.application.generated.AdditionInput;
import com.spring.calculator.webservice.application.generated.BatuxInput;
import com.spring.calculator.webservice.application.generated.BatuxOutput;
import com.spring.calculator.webservice.application.generated.DivisionInput;
import com.spring.calculator.webservice.application.generated.ModInput;
import com.spring.calculator.webservice.application.generated.ModOutput;
import com.spring.calculator.webservice.application.generated.MultiplicationInput;
import com.spring.calculator.webservice.application.generated.ObjectFactory;
import com.spring.calculator.webservice.application.generated.Output;
import com.spring.calculator.webservice.application.generated.SubtractionInput;



@Endpoint("calculatorEndPoint")
public class CalculatorSoapServiceEndpoint {

	private static final String NAMESPACE_URI = "http://kodluyoruz.com/types/calculator";
	
	
	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "BatuxInput")
	public BatuxOutput batuxOperation(
			@RequestPayload BatuxInput batuxInput) {
		
		ObjectFactory objectFactory =new ObjectFactory() ;
		
		BatuxOutput output = objectFactory.createBatuxOutput();
		
		long result = (batuxInput.getNumber1() + batuxInput.getNumber2()) * 2;
		
		output.setResult(result);
		return output;
	}
	
	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ModInput")
	public ModOutput modOperation(
			@RequestPayload ModInput modInput) {
	//	
 ObjectFactory objectFactory = new ObjectFactory();
		
		ModOutput output = objectFactory.createModOutput();
		
		long result = (modInput.getNumber1() + modInput.getNumber2());
		
		output.setResult(result);
		return output;
	}
	
	@ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AdditionInput")
    public Output addition(@RequestPayload AdditionInput input){
		
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() + input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SubtractionInput")
    public Output subtraction(@RequestPayload SubtractionInput input){
    	
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() - input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "MultiplicationInput")
    public Output multiplication(@RequestPayload MultiplicationInput input){
    	
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() * input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DivisionInput")
    public Output division(@RequestPayload DivisionInput input){
    	
        if(input.getNumber2() == 0){
            throw new IllegalArgumentException("Divisor can't be null");
        }
        
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() + input.getNumber2());
        return output;
    }
}
