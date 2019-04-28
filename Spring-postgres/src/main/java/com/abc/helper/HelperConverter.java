package com.abc.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class HelperConverter {

	public Date StringToDateConverter(String inputdate) {
		Date date = null;
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = format.parse(inputdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public String DateToStringConverter(Date inputdate) {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String reportDate = df.format(inputdate);

		return reportDate;
	}

	public Date getTodaysDate() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date today = Calendar.getInstance().getTime();
		System.out.println(df);
		System.out.println(today);
		return today;
	}
	
}
