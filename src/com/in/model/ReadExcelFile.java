package com.in.model;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.in.controller.Controller;

public class ReadExcelFile {
	
	private Controller controller;
	
    public List<String> readExcelFileToEmails(String pathFile) {
    	
    	List<String> emailsList = new ArrayList<String>();
 
        try (FileInputStream file = new FileInputStream(new File(pathFile))) {
            
        	HSSFWorkbook book = new HSSFWorkbook(file);
        	HSSFSheet sheet = book.getSheetAt(0);
            String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
            Pattern pattern = Pattern.compile(regex);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row;
            int columnIndex = 0;
            int rowIndex = 0;
            
            while (rowIterator.hasNext()) {
            	
                row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                
                while (cellIterator.hasNext()) {
                	
                    cell = cellIterator.next();
                    
                    if (new String(cell.getStringCellValue()).equals("CORREO_E")) {
                    	
                    	columnIndex = cell.getColumnIndex();
                    	rowIndex = cell.getRowIndex();
                    	
                    }

                	Matcher matcher = pattern.matcher(new String(cell.getStringCellValue()));
                	
                    if (cell.getColumnIndex() == columnIndex && cell.getRowIndex() > rowIndex && matcher.matches()) {
                    	
                    	emailsList.add(new String(cell.getStringCellValue()));
                    	break;
                    	
                    }
                }
            }
            
            book.close();
            
        } catch (Exception e) {
            emailsList.add("Error al Importar.\nIntente cambiando el formato de celdas a texto en el Documento.");
        }
        return emailsList;
    }

	public void setController(Controller controller) {
		this.controller = controller;
	}
}