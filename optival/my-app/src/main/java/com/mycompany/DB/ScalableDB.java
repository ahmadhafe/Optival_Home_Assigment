package com.mycompany.DB;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mycompany.Rows.LegacyRow;

public class ScalableDB {

	LegacyRow legacyrow;
	static int RowsNumber=0;
	static MultiValuedMap<String, Integer> mapScale = new ArrayListValuedHashMap<>();
	static MultiValuedMap<String, Integer> MapScaleRows = new ArrayListValuedHashMap<>();

	
	public void read() {

		  
		try {
	        FileInputStream file = new FileInputStream(new File("..\\Scale DB.xlsx"));

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
	            if (row.getCell(6) != null && row.getCell(4) != null || row.getCell(6) != null  ) {
	            	mapScale.put(row.getCell(6).getStringCellValue(),(int) row.getCell(4).getNumericCellValue());
	            	MapScaleRows.put(row.getCell(6).getStringCellValue(),RowsNumber);
	            	
	            }
	            
	            
	            //For each row, iterate through all the columns
	            Iterator<Cell> cellIterator = row.cellIterator();

	            while (cellIterator.hasNext()) 
	            {
	                Cell cell = cellIterator.next();
	                //Check the cell type and format accordingly
	                switch (cell.getCellType()) 
	                {
	                    case Cell.CELL_TYPE_NUMERIC:
	                        System.out.print(cell.getNumericCellValue() + "\t");
	                        break;
	                    case Cell.CELL_TYPE_STRING:
	                        System.out.print(cell.getStringCellValue() + "\t");
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
		return mapScale;
	}
	
	
	public MultiValuedMap<String, Integer> getIdentifiersRows() {
		return MapScaleRows;
	}


	



}
