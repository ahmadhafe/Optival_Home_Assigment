package com.mycompany.app;
import java.io.FileWriter;
import java.io.IOException;

import com.mycompany.DB.LegacyDB;
import com.mycompany.DB.ScalableDB;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.collections4.MultiValuedMap;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 



{
	public static LegacyDB Legacy = new LegacyDB();
	public static ScalableDB scale = new 	ScalableDB();
	
	
	
    /**
     * Rigorous Test :-)
     */
	@BeforeClass
	public static void beforeall() {
		Legacy.read();
		scale.read();
		
		
		
			
	}
	
	
    @Test
    public void shouldFaildCompareRows()
    //should failed 
    {
    	int ScaleRow = scale.getRowN();
    	int legacyRow = Legacy.getRowN();
    	assertEquals(ScaleRow,legacyRow);
    }
    
//    @Test
//    public void NotExsistinScale()
//    //should failed 
//    {
//    	MultiValuedMap ScaleHash = scale.getIdentifiers();
//    	MultiValuedMap legacyHash = Legacy.getIdentifiers();
//    	    	
//		for (Object name: legacyHash.keySet()) {
//	    String key = name.toString();
//	    
//	    if(ScaleHash.containsKey(key) == false){
//	    	String value = legacyHash.get(name).toString();
//		    System.out.println(key + " " + value);
//	    	
//	    }
//		}
//		
//		System.out.println("==================================================================================");
//    	
//
//    	//assertTrue(legacyHash.equals(ScaleHash));
//    	//assertEquals(ScaleRow,legacyRow);	
//    	
//    }
    /**
    
    @Test
    public void NotExsistInLegacy() {
    	
    	System.out.println("==============================================================================================================================");
    	
    
    	
    	MultiValuedMap ScaleHash = scale.getIdentifiers(); // this will retuen the MultiValuedMap with ID and list of dates (collection)
    	MultiValuedMap legacyHash = Legacy.getIdentifiers(); // this will retuen the MultiValuedMap with ID and list of dates (collection)
    	
    	
    	for (Object name: ScaleHash.keySet()) {
    	    String key = name.toString();
    	    
    	    if(legacyHash.containsKey(key) == false){
    	    	String value = ScaleHash.get(name).toString();
    		    System.out.println(key + " " + value);
    	    	
    	    }
    	}
    }
    
    **/
    
    
    
    
    @Test
    public void NotExsistInLegacy() {
    	
    	System.out.println("==============================================================================================================================");
    	
    
    	
    	MultiValuedMap ScaleHash = scale.getIdentifiersRows(); // this will retuen the MultiValuedMap with ID and list of dates (collection)
    	MultiValuedMap legacyHash = Legacy.getIdentifiersRows(); // this will retuen the MultiValuedMap with ID and list of dates (collection)
    	
    	
    	try {
    	FileWriter myWriter = new FileWriter("NotExsistInLegacyRows.txt");
    	for (Object name: ScaleHash.keySet()) {
    	    String key = name.toString();
    	    
    	    if(legacyHash.containsKey(key) == false){
    	    	String value = ScaleHash.get(name).toString();
    		    //System.out.println(key + "\t "+ " Rows are: " + value + "\t "+"Not exsist in Legacy But exsist in Scale" );
    		    myWriter.write(key + "\t "+ " Rows are: " + value + "\t "+"Not exsist in Legacy But exsist in Scale" +"\n" );
    	    	
    	    }
    	    
    	}
    	myWriter.close();
	    System.out.println("Successfully wrote to the file Not Exsist In Legacy Rows please check result there");
    	}catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    }
    
    
    
    @Test
    public void NotExsistScalable() {
    	
    	System.out.println("==============================================================================================================================");
    	
    
    	
    	MultiValuedMap ScaleHash = scale.getIdentifiersRows(); // this will retuen the MultiValuedMap with ID and list of dates (collection)
    	MultiValuedMap legacyHash = Legacy.getIdentifiersRows(); // this will retuen the MultiValuedMap with ID and list of dates (collection)
    	
    	
    	try {
    	FileWriter myWriter = new FileWriter("NotExsistInScalableRows.txt");
    	for (Object name: legacyHash.keySet()) {
    	    String key = name.toString();
    	    
    	    if(ScaleHash.containsKey(key) == false){
    	    	String value = legacyHash.get(name).toString();
    		    //System.out.println(key + "\t "+ " Rows are: " + value + "\t "+"Not exsist in Legacy But exsist in Scale" );
    		    myWriter.write(key + "\t "+ " Rows are: " + value + "\t "+"Not exsist in Scalable DB But exsist in Legacy DB" +"\n" );
    	    	
    	    }
    	    
    	}
    	myWriter.close();
	    System.out.println("Successfully wrote to the file Not Exsist In Scalable Rows.txt please check results there ");
    	}catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    }
}
