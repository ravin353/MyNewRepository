package com.delta.apachecamel.test;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ValidProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(exchange.getIn().getBody().toString());
		
	}
}
