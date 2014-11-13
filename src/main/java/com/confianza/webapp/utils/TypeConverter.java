package com.confianza.webapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hoglyrubio
 * Clase utilitaria para la conversión de tipos de datos desde y hacia String,
 * establece el formato para el manejo interno del formato de fechas así:
 * yyyy/MM/dd HH:mm:ss y yyyy/MM/dd.
 */
public class TypeConverter {
	
	private final String DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
	private final String DATE_FORMAT = "yyyy/MM/dd";
	private SimpleDateFormat sdfDate;
	private SimpleDateFormat sdfDateTime;
	
	public TypeConverter() {
		sdfDate = new SimpleDateFormat(DATE_FORMAT);
		sdfDateTime = new SimpleDateFormat(DATETIME_FORMAT);
	}
	
	public Date stringToDate(String date) throws ParseException {
		return sdfDate.parse(date);
	}

	public Date stringToDateTime(String datetime) throws ParseException {
		return sdfDateTime.parse(datetime);
	}
	
	public String dateToString(Date date) {
		return sdfDate.format(date);
	}

	public String dateTimeToString(Date datetime) {
		return sdfDateTime.format(datetime);
	}
	
	public Integer stringToInteger(String valor) {
		return Integer.parseInt(valor);
	}
	
	public Double stringToDouble(String valor) {
		return Double.parseDouble(valor);
	}
	
	public Long stringToLong(String valor) {
		return Long.parseLong(valor);
	}
	
	public Boolean stringToBoolean(String valor) {
		return Boolean.parseBoolean(valor.toLowerCase());
	}
}
