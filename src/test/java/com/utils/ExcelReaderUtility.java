package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.user;

public class ExcelReaderUtility {

	public static Iterator<user> readExcelFile(String fileName) {

		File excelFile = new File(System.getProperty("user.dir") + "//testData//" + fileName);

		XSSFWorkbook xssfWorkBook = null;
		List<user> userList = null;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;

		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		user user;
		try {
			xssfWorkBook = new XSSFWorkbook(excelFile);

			userList = new ArrayList<user>();
			xssfSheet = xssfWorkBook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next(); // skipping column names of test datas

			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new user(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);

				xssfWorkBook.close();

			}

		} catch (IOException | org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();

	}

}
