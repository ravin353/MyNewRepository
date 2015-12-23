package com.delta.apachecamel.core;

@SuppressWarnings("serial")
public class MyParseExcetion extends Exception {

	public MyParseExcetion(){
		super("Parsing exception occured");
	}
	
	public MyParseExcetion(String message){
		super(message);
	}
}
