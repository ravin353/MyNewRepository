package com.delta.apachecamel.test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.delta.apachecamel.core.CSVFileHeaders;
import com.delta.apachecamel.core.Insurance;
import com.delta.apachecamel.core.InsuranceList;
import com.thoughtworks.xstream.XStream;

public class XMLCreator {

	public String csvtoxml(String csvData) {

		StringReader sr = new StringReader(csvData); // wrap your String
		String xmlString = null;
		ArrayList<Insurance> javaObjectList = null;
		CSVParser csvParser = null;

		try {

			CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(CSVFileHeaders.FILE_HEADER_MAPPING);
			csvParser = new CSVParser(sr, csvFormat);
			List<CSVRecord> csvRecords = csvParser.getRecords();

			javaObjectList = new ArrayList<Insurance>();

			for (CSVRecord record : csvRecords) {
				Insurance insurance = new Insurance(record.get(CSVFileHeaders.policyID),
						record.get(CSVFileHeaders.statecode), record.get(CSVFileHeaders.county),
						record.get(CSVFileHeaders.eq_site_limit), record.get(CSVFileHeaders.hu_site_limit),
						record.get(CSVFileHeaders.fl_site_limit), record.get(CSVFileHeaders.fr_site_limit),
						record.get(CSVFileHeaders.tiv_2011), record.get(CSVFileHeaders.tiv_2012),
						record.get(CSVFileHeaders.eq_site_deductible), record.get(CSVFileHeaders.fr_site_deductible),
						record.get(CSVFileHeaders.hu_site_deductible), record.get(CSVFileHeaders.fl_site_deductible),
						record.get(CSVFileHeaders.point_latitude), record.get(CSVFileHeaders.point_longitude),
						record.get(CSVFileHeaders.line), record.get(CSVFileHeaders.construction),
						record.get(CSVFileHeaders.point_granularity));
				javaObjectList.add(insurance);
			}

			XStream xstream = new XStream();
			xstream.processAnnotations(Insurance.class); // inform XStream to
															// parse annotations
															// in Insurance
															// class
			xstream.processAnnotations(InsuranceList.class); // and in two other
																// classes...
			xstream.addImplicitCollection(InsuranceList.class, "insuranceList");

			xmlString = xstream.toXML(javaObjectList);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (javaObjectList != null) {
				javaObjectList.clear();
			}
		}
		return xmlString;
	}
}
