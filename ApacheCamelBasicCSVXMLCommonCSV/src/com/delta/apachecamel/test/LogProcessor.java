package com.delta.apachecamel.test;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LogProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println("Processing File Data:::" + exchange.getIn().getBody(String.class));
		
		if(exchange.getIn().getBody(String.class).contains("Ravi")){
			throw new Exception("Contains Ravi");
		}
	}

}
