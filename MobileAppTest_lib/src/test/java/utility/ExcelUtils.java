package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

//import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	//private static XSSFRow Row;
	
	public static void setExcelFile(String Path,String SheetName) throws Exception 
	{
		try 
		{
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(Path);

		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} 
		catch (Exception e)
		{
			System.out.println("Exception: " + e);
			throw (e);
		}
	}
	
	
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception 
	{
		String[][] tabArray = null;
		
		try
		{
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			 
		    // Access the required test data sheet
		 
		    ExcelWBook = new XSSFWorkbook(ExcelFile);
		 
		    ExcelWSheet = ExcelWBook.getSheet(SheetName);
		 
		    int startRow = 1;
		 
		    int startCol = 1;
		 
		    int ci,cj;
		 
		    int totalRows = getRowCountInSheet();
		    
		 
		    // you can write a function as well to get Column count
		 
		    int totalCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
		 
		    tabArray=new String[totalRows][totalCols];
		 
		    ci=0;
		 
		    for (int i=startRow;i<=totalRows;i++, ci++) 
		    {        
		      
			    cj=0;
			 
			    for (int j=startCol;j<=totalCols;j++, cj++)
			    {			 
				    tabArray[ci][cj]=String.valueOf(getCellData(i,j));				 
				    System.out.println(tabArray[ci][cj]); 
			    }
		    }
		}
		
		catch (FileNotFoundException e)
		{
			 
			System.out.println("Could not read the Excel sheet");			 
			e.printStackTrace();
		 
		}
		catch (IOException e)
		{			 
			System.out.println("Could not read the Excel sheet");			 
			e.printStackTrace();		 
		}
		return(tabArray);
	}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception 
	{
		try
		{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			Cell.setCellType(CellType.STRING);
			CellType type = Cell.getCellType();			
			 
			 if  (type == CellType.BLANK) 
			 {			 
				 return "";			 
			 }
			 else
			 {			                
				 String CellData = Cell.getStringCellValue();				 
				 return CellData;			 
			 }
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());			 
			e.printStackTrace();	
		}
		return null;
	}


	public static String getTestCaseName(String TC_Name) 
	{
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Error Message:-"+e.getMessage());
		}
		return null;
	}


	public static int getRowContains(String TC_Name, int row_no) 
	{
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Error Message:-"+e.getMessage());
		}
		return 0;
	}
	
	public static int getRowCountInSheet()
	{
	    int rowcount = ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
	    return rowcount;
	 }
	
	 public void setCellValue(int rowNum,int cellNum,String cellValue,String excelFilePath) throws IOException 
	 {		 
			//creating a new cell in row and setting value to it      
			 ExcelWSheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);
			    
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			ExcelWBook.write(outputStream);		
	  }
	
	
}

