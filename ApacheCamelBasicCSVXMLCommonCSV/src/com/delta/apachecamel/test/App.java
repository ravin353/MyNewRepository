package com.delta.apachecamel.test;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/*
 * Ref Link : http://www.javavillage.in/apache-camel.php
 */
public class App {
	public static void main(String args[]) {
		FirstRouteBuilder routeBuilder = new FirstRouteBuilder();
		CamelContext ctx = new DefaultCamelContext();
		try {
			ctx.addRoutes(routeBuilder);
			ctx.start();
			Thread.sleep(20000);
			ctx.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
