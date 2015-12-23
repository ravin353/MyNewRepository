package com.delta.apachecamel.core;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("insurance")
public class Insurance {

	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	@XStreamAsAttribute
	@XStreamAlias("policy_id")
	private String policyID;
	
	@XStreamAlias("statecode")
	private String statecode;
	
	@XStreamAlias("county")
	private String county;
	
	@XStreamAlias("eq_site_limit")
	private String eq_site_limit;
	
	@XStreamAlias("hu_site_limit")
	private String hu_site_limit;
	
	@XStreamAlias("fl_site_limit")
	private String fl_site_limit;
	
	@XStreamAlias("fr_site_limit")
	private String fr_site_limit;
	
	@XStreamAlias("tiv_2011")
	private String tiv_2011;
	
	@XStreamAlias("tiv_2012")
	private String tiv_2012;
	
	@XStreamAlias("eq_site_deductible")
	private String eq_site_deductible;
	
	@XStreamAlias("hu_site_deductible")
	private String hu_site_deductible;
	
	@XStreamAlias("fl_site_deductible")
	private String fl_site_deductible;
	
	@XStreamAlias("fr_site_deductible")
	private String fr_site_deductible;
	
	@XStreamAlias("point_latitude")
	private String point_latitude;
	
	@XStreamAlias("point_longitude")
	private String point_longitude;
	
	@XStreamAlias("line")
	private String line;
	
	@XStreamAlias("construction")
	private String construction;
	
	@XStreamAlias("point_granularity")
	private String point_granularity;

	public Insurance(String policyID, String statecode, String county, String eq_site_limit, String hu_site_limit,
			String fl_site_limit, String fr_site_limit, String tiv_2011, String tiv_2012, String eq_site_deductible,
			String hu_site_deductible, String fl_site_deductible, String fr_site_deductible, String point_latitude,
			String point_longitude, String line, String construction, String point_granularity) {
		this.policyID = policyID;
		this.statecode = statecode;
		this.county = county;
		this.eq_site_limit = eq_site_limit;
		this.hu_site_limit = hu_site_limit;
		this.fl_site_limit = fl_site_limit;
		this.fr_site_limit = fr_site_limit;
		this.tiv_2011 = tiv_2011;
		this.tiv_2012 = tiv_2012;
		this.eq_site_deductible = eq_site_deductible;
		this.hu_site_deductible = hu_site_deductible;
		this.fl_site_deductible = fl_site_deductible;
		this.fr_site_deductible = fr_site_deductible;
		this.point_latitude = point_latitude;
		this.point_longitude = point_longitude;
		this.line = line;
		this.construction = construction;
		this.point_granularity = point_granularity;
	}

	public String getPolicyID() {
		return policyID;
	}

	public void setPolicyID(String policyID) {
		this.policyID = policyID;
	}

	public String getStatecode() {
		return statecode;
	}

	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getEq_site_limit() {
		return eq_site_limit;
	}

	public void setEq_site_limit(String eq_site_limit) {
		this.eq_site_limit = eq_site_limit;
	}

	public String getHu_site_limit() {
		return hu_site_limit;
	}

	public void setHu_site_limit(String hu_site_limit) {
		this.hu_site_limit = hu_site_limit;
	}

	public String getFl_site_limit() {
		return fl_site_limit;
	}

	public void setFl_site_limit(String fl_site_limit) {
		this.fl_site_limit = fl_site_limit;
	}

	public String getFr_site_limit() {
		return fr_site_limit;
	}

	public void setFr_site_limit(String fr_site_limit) {
		this.fr_site_limit = fr_site_limit;
	}

	public String getTiv_2011() {
		return tiv_2011;
	}

	public void setTiv_2011(String tiv_2011) {
		this.tiv_2011 = tiv_2011;
	}

	public String getTiv_2012() {
		return tiv_2012;
	}

	public void setTiv_2012(String tiv_2012) {
		this.tiv_2012 = tiv_2012;
	}

	public String getEq_site_deductible() {
		return eq_site_deductible;
	}

	public void setEq_site_deductible(String eq_site_deductible) {
		this.eq_site_deductible = eq_site_deductible;
	}

	public String getHu_site_deductible() {
		return hu_site_deductible;
	}

	public void setHu_site_deductible(String hu_site_deductible) {
		this.hu_site_deductible = hu_site_deductible;
	}

	public String getFl_site_deductible() {
		return fl_site_deductible;
	}

	public void setFl_site_deductible(String fl_site_deductible) {
		this.fl_site_deductible = fl_site_deductible;
	}

	public String getFr_site_deductible() {
		return fr_site_deductible;
	}

	public void setFr_site_deductible(String fr_site_deductible) {
		this.fr_site_deductible = fr_site_deductible;
	}

	public String getPoint_latitude() {
		return point_latitude;
	}

	public void setPoint_latitude(String point_latitude) {
		this.point_latitude = point_latitude;
	}

	public String getPoint_longitude() {
		return point_longitude;
	}

	public void setPoint_longitude(String point_longitude) {
		this.point_longitude = point_longitude;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getConstruction() {
		return construction;
	}

	public void setConstruction(String construction) {
		this.construction = construction;
	}

	public String getPoint_granularity() {
		return point_granularity;
	}

	public void setPoint_granularity(String point_granularity) {
		this.point_granularity = point_granularity;
	}

}
