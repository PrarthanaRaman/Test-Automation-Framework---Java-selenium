package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.user;

public class CSVReaderUtility {

	public static Iterator<user> readCSVFile(String fileName) {

		File csvFile = new File(System.getProperty("user.dir") + "\\testData\\"+ fileName);
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<user> userList = null;
		user userData;
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext(); // to skip row 1 which has "emailaddress" and "password" fields
			userList = new ArrayList<user>();
			while ((line = csvReader.readNext()) != null) {
				userData = new user(line[0], line[1]);
				userList.add(userData);
			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}

}
