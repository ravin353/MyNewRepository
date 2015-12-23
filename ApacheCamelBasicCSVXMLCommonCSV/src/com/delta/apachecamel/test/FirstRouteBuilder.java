package com.delta.apachecamel.test;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.Processor;
import org.apache.camel.RuntimeCamelException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.log4j.helpers.Transform;

import com.delta.apachecamel.core.MyParseExcetion;

public class FirstRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * from("file://resources//inbox?fileName=sample.csv&noop=true").process
		 * (new LogProcessor()).bean(new DataTransformer(), "transformContent")
		 * .to("file://resources//outbox?fileName=trans_sample.xml").to(
		 * "stream:out");
		 */

		/*
		 * from("file://resources//inbox?fileName=sample1.csv&noop=true").split(
		 * body().tokenize("\n")).process(new ValidProcessor())
		 * .to("file://resources//outbox?fileName=trans_sample.txt");
		 */

		/*
		 * errorHandler(deadLetterChannel(
		 * "file://resources//outbox?fileName=trans_error.txt"));
		 * 
		 * onException(RuntimeCamelException.class).transform(simple(
		 * "${exception.stacktrace}")).to(
		 * "file://resources//outbox?fileName=trans_error.txt");
		 * //onException(ArrayIndexOutOfBoundsException.class).to("");
		 * 
		 * from("file://resources//inbox?fileName=sample2.csv&noop=true").
		 * process(new Processor() {
		 * 
		 * public void process(Exchange exchange) throws Exception { // TODO
		 * Auto-generated method stub
		 * 
		 * Exception
		 * e=(Exception)exchange.getProperty(Exchange.EXCEPTION_CAUGHT);
		 * 
		 * if(e != null) { throw new Exception("File specified not exists"); }
		 * 
		 * } }).onException(Exception.class).handled(true).to("direct:A");
		 */

		
		//Working fine --  This block is for validation of input
		
		onException(MyParseExcetion.class).handled(true).process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				//System.out.println(""+exchange.getIn().getBody().toString());
			}
		})
		.bean(new DataTransformer(),"transformError").to("file://resources//outbox?fileName=trans_error.txt","stream:out");
			//.to("bean:datatransformer");
		
		//from("direct:finalString").to("file://resources//outbox?fileName=trans_error.txt");
		
		from("file://resources//inbox?fileName=sample1.csv&noop=true")
			.split(body().tokenize("\n")).process(new Processor() {
				
				public void process(Exchange exchange) throws Exception {
					// TODO Auto-generated method stub
					
					if(exchange.getIn().getBody().toString().contains("Ravi")){
						throw new MyParseExcetion("Body contains error");
					}
				}
			})
			.bean(new DataTransformer(),"transformContent").to("file://resources//outbox?fileName=trans_sample.txt","stream:out");

		/*onException(Exception.class).handled(true).transform(constant("Error Occured")).to("file://resources//outbox?fileName=trans_error.txt");
		
		from("file://resources//inbox?fileName=sample2.csv&noop=true").process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				
				System.out.println(""+exchange.getIn().getBody().toString());
				
			}
		}).transform(constant("Working Fine")).to("file://resources//outbox?fileName=trans_sample.txt");*/
		
		/*
		 * from("file://resources//inbox?fileName=sample1.csv&noop=true")
		 * .onException(Exception.class) .handled(true)
		 * //.to("file://resources//outbox?fileName=trans_error.txt")
		 * .end().split(body().tokenize("\n")) .bean(LogProcessor.class)
		 * .to("file://resources//outbox?fileName=trans_sample.txt");
		 */

		/*
		 * from("file://resources//inbox?fileName=sample1.csv&noop=true").split(
		 * body().tokenize("\n")).process(new Processor() {
		 * 
		 * public void process(Exchange exchange) throws Exception { // TODO
		 * Auto-generated method stub
		 * 
		 * if (exchange.getIn().getBody().toString().contains("Ravi")) {
		 * exchange.getIn().setHeader("Value", "Ravi"); } else {
		 * exchange.getIn().setHeader("Value", "Other"); } } })
		 * .to("direct:category").end();
		 * 
		 * from("direct:category").aggregate(header("Value"),new
		 * MyAggregate()).completionTimeout(500L).bean(new
		 * DataTransformer()).to(
		 * "file://resources//outbox?fileName=trans_sample.txt");
		 */
		/*
		 * onException(ArrayIndexOutOfBoundsException.class).transform(simple(
		 * "${exception.stacktrace}")).to(
		 * "file://resources//outbox?fileName=trans_error.txt");
		 * from("file://resources//inbox?fileName=sample1.csv&noop=true").
		 * throwException(new ArrayIndexOutOfBoundsException("Exception occured"
		 * )) .to("direct:A");
		 */

		/*
		 * from("file://resources//inbox?fileName=books-extended.xml&noop=true")
		 * .split(xpath("/books/book")) .setHeader("category",
		 * xpath("/book/@category").stringResult())
		 * .transform(xpath("/book/@title").stringResult())
		 * .aggregate(header("category"), new
		 * MyAggregate()).completionTimeout(500) .to("seda:aggregate")
		 * .endParent() .end();
		 */

		/*
		 * from("file://resources//inbox?fileName=sample1.csv&noop=true")
		 * .split(body().tokenize("\n"), new AggregationStrategy() {
		 * 
		 * public Exchange aggregate(Exchange oldExchange, Exchange newExchange)
		 * { // TODO Auto-generated method stub
		 * 
		 * if (oldExchange == null) { // the first time we aggregate we only
		 * have the new exchange, // so we just return it return newExchange; }
		 * String orders = oldExchange.getIn().getBody(String.class); String
		 * newLine = newExchange.getIn().getBody(String.class);
		 * System.out.println("Aggregate old orders: " + orders);
		 * System.out.println("Aggregate new order: " + newLine); // put orders
		 * together separating by semi colon orders = orders + ";" + newLine; //
		 * put combined order back on old to preserve it
		 * oldExchange.getIn().setBody(orders); // return old as this is the one
		 * that has all the orders gathered until now return oldExchange; } })
		 * // each splitted message is then send to this bean where we can
		 * process it .to("bean:MyOrderService?method=handleOrder") // this is
		 * important to end the splitter route as we do not want to do more
		 * routing // on each splitted message .end() // after we have splitted
		 * and handled each message we want to send a single combined //
		 * response back to the original caller, so we let this bean build it
		 * for us // this bean will receive the result of the aggregate
		 * strategy: MyOrderStrategy
		 * .to("bean:MyOrderService?method=buildCombinedResponse");
		 */

		/*
		 * *
		 * from("file://resources//inbox?fileName=sample1.csv&noop=true").split(
		 * body().tokenize("\n")) .choice().when(new Predicate() {
		 * 
		 * public boolean matches(Exchange exchange) { // TODO Auto-generated
		 * method stub
		 * 
		 * String body = exchange.getIn().getBody().toString();
		 * 
		 * if(body.contains("Ravi")){ return true; }
		 * 
		 * return false; } }).to("direct:A").otherwise().to("direct:B");
		 * 
		 * from("direct:A").to(
		 * "file://resources//outbox?fileName=trans_error.txt");
		 * from("direct:B").to(
		 * "file://resources//outbox?fileName=trans_sample.txt");
		 */

	}

	public static class MyOrderService {
		private int counter = 0;

		/** * We just handle the order by returning a id line for the order */
		public String handleOrder(String line) {
			System.out.println("MyOrder is called");
			System.out.println("HandleOrder: " + line);
			return "(id=" + ++counter + ",item=" + line + ")";
		}

		/**
		 * * We use the same bean for building the combined response to send *
		 * back to the original caller
		 */
		public String buildCombinedResponse(String line) {
			System.out.println("BuildCombinedResponse: " + line);
			return "Response[" + line + "]";
		}
	}

}
