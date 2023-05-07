package com.nopcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
		File src= new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);

		}
		catch (Exception e) {
			System.out.println("Exception is" +e.getMessage());
		}
	}
	public String getURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}

	public String getEdgePath()
	{
		String driverpath=pro.getProperty("driverpath");
		return  driverpath;
	}

	public String getfirstname()
	{
		String firstname=pro.getProperty("firstname");

		return firstname;
	}

	public String getlastname()
	{
		String lastname=pro.getProperty("lastname");

		return lastname;
	}

	public String getmail()
	{
		String mail=pro.getProperty("mail");

		return mail;
	}

	public String getcity()
	{
		String city=pro.getProperty("city");

		return city;
	}

	public String getaddress()
	{
		String address=pro.getProperty("address");

		return address;
	}

	public String getzipcode()
	{
		String zipcode=pro.getProperty("zipcode");

		return zipcode;
	}
	public String getphoneNumber()
	{
		String phoneNumber=pro.getProperty("phoneNumber");

		return phoneNumber;


	}

}
