package com.delta.apachecamel.core;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("insurance_list")
public class InsuranceList {

	@XStreamImplicit
	private List<Insurance> insuranceList;


}
