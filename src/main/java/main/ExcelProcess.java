package main;

import service.ExcelReaderService;
import service.ExcelServiceHandler;

import java.io.IOException;

public class ExcelProcess {

    public static void main(String[] args) throws IOException {
     //   ExcelServiceHandler excelServiceHandler=new ExcelServiceHandler();
    //    excelServiceHandler.readExcel("F:\\Microservice\\LargeFileExcelReaderDemo\\src\\main\\resources\\500000-Sales-Records.xlsx");
        ExcelReaderService excelReaderService=new ExcelReaderService();
        excelReaderService.readLargeExcel("F:\\Microservice\\LargeFileExcelReaderDemo\\src\\main\\resources\\500000-Sales-Records.xlsx");
    }
}
