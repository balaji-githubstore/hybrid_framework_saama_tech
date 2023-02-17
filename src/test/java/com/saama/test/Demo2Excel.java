package com.saama.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo2Excel {

	public static void main(String[] args) throws IOException {

		FileInputStream file=new FileInputStream("test_data/orange_test_data.xlsx");


		XSSFWorkbook book=new XSSFWorkbook(file);
		
		XSSFSheet sheet= book.getSheet("invalidLoginTest");
		
		DataFormatter format=new DataFormatter();
		
		Object[][] data=new Object[2][3];
		
		for(int r=1;r<3;r++)
		{
			for(int c=0;c<3;c++)
			{
				String cellValue=format.formatCellValue(sheet.getRow(r).getCell(c));
				System.out.println(cellValue);
				data[r-1][c]=cellValue;
			}
		}
		
		book.close();
		file.close();
	}

}
