package com.mycompany.DB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mycompany.Rows.LegacyRow;




public class LegacyDB {
	LegacyRow legacyrow;
	static int RowsNumber=0;
	static MultiValuedMap<String, Integer> map = new ArrayListValuedHashMap<>();
	static MultiValuedMap<String, Integer> MapLegacyRows = new ArrayListValuedHashMap<>();

	public void read() {
			  
		try {
	        FileInputStream file = new FileInputStream(new File("..\\Legacy DB.xlsx"));

	        //Create Workbook instance holding reference to .xlsx file
	        XSSFWorkbook workbook = new XSSFWorkbook(file);

	        //Get first/desired sheet from the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0);

	        //Iterate through each rows one by one
	        
	        Iterator<Row> rowIterator = sheet.iterator();
	        Row row= rowIterator.next();
	        RowsNumber++;
	        while (rowIterator.hasNext())
	        	
	        {
	        	RowsNumber++;
	            row = rowIterator.next();

	            Iterator<Cell> cellIterator = row.cellIterator();	            
	            // save identifers inn map ( <id> <dates> )
	           if (row.getCell(25) != null && row.getCell(2) != null || row.getCell(25) != null ) {
	        	   map.put(row.getCell(25).getStringCellValue(),(int) row.getCell(2).getNumericCellValue());
	        	   
	        	   MapLegacyRows.put(row.getCell(25).getStringCellValue(),RowsNumber);
	        	   
	           }
	            
	           
	            while (cellIterator.hasNext()) 
	            {
	            	
	                Cell cell = cellIterator.next();

	                switch (cell.getCellType()) 
	                {
	                    case Cell.CELL_TYPE_NUMERIC:
	                        System.out.print(cell.getNumericCellValue() + "\t");
	                        break;
	                    case Cell.CELL_TYPE_STRING:
	                        System.out.print(cell.getStringCellValue() + "\t");
	                        
	                        int columnIndex = cell.getColumnIndex();
	                      

	                        break;
	                }
	            }
	            System.out.println("");
	        }
	        file.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		 
		
	
	}
	
	public int getRowN() {
		return RowsNumber;
	}
	

	public MultiValuedMap<String, Integer> getIdentifiers() {
		return map;

	}
	
	
	public MultiValuedMap<String, Integer> getIdentifiersRows() {
		
		return MapLegacyRows;
	}

}
