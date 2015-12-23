package com.delta.apachecamel.test;

import java.util.List;

import org.apache.camel.Exchange;

public class DataTransformer {
	/*public String transformContent(List<Exchange> body) {
		System.out.println("invoking the transformContent method : "+body.size());
		//String xml = new XMLCreator().csvtoxml(body);
		// String upperCaseContent=body.toUpperCase();
		// System.out.println(object);
		return body.toString();
	}*/
	
	private String finalStringError = "";
	private String finalStringContent = "";
	
	public String transformError(Exchange body){
		StringBuilder builder = new StringBuilder(finalStringError);
		builder.append(body.getIn().getBody().toString()).append("\n");
		finalStringError = builder.toString();
		//System.out.println(finalStringError);
		
		/*@SuppressWarnings("unchecked")
		List<Exchange> grouped = body.getIn().getBody(List.class);
		System.out.println("Exchanges are combined "+grouped.size());*/
		return finalStringError;
	}
	
	public String transformContent(Exchange body){
		StringBuilder builder = new StringBuilder(finalStringContent);
		builder.append(body.getIn().getBody().toString()).append("\n");
		finalStringContent = builder.toString();
		//System.out.println(finalStringContent);
		
		/*@SuppressWarnings("unchecked")
		List<Exchange> grouped = body.getIn().getBody(List.class);
		System.out.println("Exchanges are combined "+grouped.size());*/
		return finalStringContent;
	}
	
}
