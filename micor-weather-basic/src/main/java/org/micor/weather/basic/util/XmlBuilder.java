package org.micor.weather.basic.util;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlBuilder {
	private static final Logger LOG = LoggerFactory.getLogger(XmlBuilder.class);

	public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws JAXBException, IOException {
		LOG.info("xmlStrToObject method param :{}",xmlStr);
		Object xmlObject = null;
		Reader reader = null;
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		reader = new StringReader(xmlStr);
		xmlObject = unmarshaller.unmarshal(reader);
		if(reader != null) {
			reader.close();
		}
		
		
		return xmlObject;
	}
}
