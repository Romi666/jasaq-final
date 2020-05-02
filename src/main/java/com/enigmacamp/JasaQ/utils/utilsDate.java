package com.enigmacamp.JasaQ.utils;

import java.sql.Date;

public class utilsDate {
	public Date dateNow() {
		long millis=System.currentTimeMillis();
		Date date = new Date(millis);
		return date;
	}
}
