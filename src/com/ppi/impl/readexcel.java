package com.ppi.impl;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexcel {
	
	public static void main(String[] args) 
    {
		Connection con=null;
        try
        {        	
                   Class.forName("com.mysql.jdbc.Driver");
                   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppi","root","root");
                   con.setAutoCommit(false);
                   PreparedStatement pstm = null;
                   
                   String sql = "DELETE FROM RECORDS";
                   pstm = con.prepareStatement(sql);
                   pstm.execute();
                   
            FileInputStream file = new FileInputStream(new File("C:\\Users\\Harshit\\Desktop\\data.xlsx"));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            //Row row;
 
            for(int i=0; i<=sheet.getLastRowNum(); i++)
            {
                //row = sheet.getRow(i);
                
                DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
                Cell cell = sheet.getRow(i).getCell(0);
                String rno = formatter.formatCellValue(cell);
                
                 Cell cell1 = sheet.getRow(i).getCell(1);
                String name = formatter.formatCellValue(cell1);
                
          //      String rno = row.getCell(0).getStringCellValue();
             //   double name = row.getCell(1).getNumericCellValue();
                sql = "INSERT INTO records VALUES('"+name+"','"+rno+"')";
                pstm = con.prepareStatement(sql);
                pstm.execute();
                System.out.println("Import rows "+i);
            }
            file.close();
            workbook.close();
        con.commit();
        pstm.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

}
