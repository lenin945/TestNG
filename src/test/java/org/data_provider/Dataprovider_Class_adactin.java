package org.data_provider;

import org.testng.annotations.DataProvider;

public class Dataprovider_Class_adactin {

	@DataProvider(name = "logindata")
	private Object[][] login() {

		return new Object[][] { { "RajaGanap", "4L2JD8" } };
	}

	@DataProvider(name = "searchHotel")
	private Object[][] searchHotel() {
		return new Object[][] { { "Brisbane","Hotel Hervey","Standard","2","13/10/2021","14/10/2021","1","0", } };
	}

	@DataProvider(name = "bookhotel")
	private Object[][] bookHotel() {
		return new Object[][] {
				{ "Ganapathy", "Raja", "F1, Murugan flats, MIT road, Chromepet", "1234567890123450","VISA","January","2022", "322" } };
	}
}
