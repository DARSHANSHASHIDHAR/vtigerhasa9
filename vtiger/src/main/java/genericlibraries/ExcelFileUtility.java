package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains all the reusable methods to perform operations on excel
 * @author Darshan S
 *
 */
public class ExcelFileUtility {
	private FileInputStream fis = null;
	private Workbook wb = null;
	private Sheet sh = null;
	private DataFormatter df;
	private Row r = null;
	private Cell c = null;
	private FileOutputStream fos = null;
	public Sheet getSh(String sheet) {
		return sh;
	}
	public Row getR() {
		return r;
	}
	public Cell getC() {
		return c;
	}
	public void setSh(String sheet) {
		sh = wb.getSheet(sheet);
	}
	public void setR(int row) {
		r = sh.getRow(row);
	}
	public void setC(int cell) {
		c = r.getCell(cell);
	}
	
	/**
	 * This method initializes excel workbook
	 * @param path
	 */
	public void excelInitialization(String path) {
		try {
			fis= new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to fetch single data from excel
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 */
	public String readingSingleData(String sheet,int row,int cell) {
		df = new DataFormatter();
		sh = wb.getSheet(sheet);
		return df.formatCellValue(sh.getRow(row).getCell(cell));
	}
	/**
	 * This method sets key data into the choosen excel cell 
	 * @param data
	 * @param cell
	 * @param row
	 * @param path
	 */
	public void setDataToExcel(String data, int cell, int row,String path) {
		c = sh.getRow(row).createCell(cell);
		c.setCellValue(data);
		try {
			fos = new FileOutputStream(path);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb.write(fos);
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			fos.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("null")
	public String[][] readingMultipleData(String path, String sheet,int[] row,int[] cell) {
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		String[][] str = null;
		for (int i=0; sh.getRow(row[i])!=null;i++) {
			r = sh.getRow(row[i]);
			for(int j=0; r.getCell(cell[j])!=null; j++) {
				c = r.getCell(cell[j]);
				str[i][j]= c.toString();
			}
		}
		return str;
	}
	
}
