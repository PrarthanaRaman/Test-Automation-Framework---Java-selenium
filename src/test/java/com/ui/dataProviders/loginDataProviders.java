package com.ui.dataProviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.user;
import com.utils.CSVReaderUtility;
import com.utils.ExcelReaderUtility;

public class loginDataProviders {
	
	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> Logindataproviders() throws FileNotFoundException {
		
		Gson gson = new Gson();
		File file = new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
		FileReader reader = new FileReader(file);
		TestData testdata = gson.fromJson(reader, TestData.class);

		
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for(user user : testdata.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();
		
	}
	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<user> LoginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("loginData.csv");
	}
	
	@DataProvider(name = "LoginTestExcelDataProvider")
	public Iterator<user> LoginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
	}

}
