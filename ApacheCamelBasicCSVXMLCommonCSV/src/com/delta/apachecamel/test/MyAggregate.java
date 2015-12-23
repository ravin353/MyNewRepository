package com.delta.apachecamel.test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;

public class MyAggregate extends GroupedExchangeAggregationStrategy {

	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		// TODO Auto-generated method stub
		
		String body = newExchange.getIn().getBody(String.class);
        if (oldExchange == null) {
            Set<String> set = new HashSet<String>();
            set.add(body);
            newExchange.getIn().setBody(set);
            return newExchange;
        } else {
            @SuppressWarnings("unchecked")
            Set<String> set = Collections.checkedSet(oldExchange.getIn().getBody(Set.class), String.class);
            set.add(body);
            return oldExchange;
        }
	}

}
