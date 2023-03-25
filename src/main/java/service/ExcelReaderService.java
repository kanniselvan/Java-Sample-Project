package service;

import com.monitorjbl.xlsx.StreamingReader;
import model.SalesRecord;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExcelReaderService {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public List<SalesRecord> readLargeExcel(String xlsxFile) throws IOException {

        System.out.println("starting to file reader.......");
        long start=System.currentTimeMillis();

        List<SalesRecord> result = new ArrayList<>();
        int rowCount = 1;
        try (InputStream is = new FileInputStream(new File(xlsxFile));
             Workbook workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(is)) {
            for (Sheet sheet : workbook) {
                for (Row row : sheet) {
                    if (rowCount == 1) {
                        rowCount++;
                    } else {
                        SalesRecord record = SalesRecord.builder()
                                .region(row.getCell(0).getStringCellValue().trim())
                                .country(row.getCell(1).getStringCellValue().trim())
                                .itemType(row.getCell(2).getStringCellValue().trim())
                                .salesChannel(row.getCell(3).getStringCellValue().trim())
                                .orderPriority(row.getCell(4).getStringCellValue().trim())
                                .orderDate(row.getCell(5).getStringCellValue().trim())
                                .orderID((double) row.getCell(8).getNumericCellValue())
                                .shipDate(row.getCell(7).getStringCellValue().trim())
                                .unitSold((double) row.getCell(8).getNumericCellValue())
                                .unitPrize((double) row.getCell(9).getNumericCellValue())
                                .unitCost((double) row.getCell(10).getNumericCellValue())
                                .totalRevenue((double) row.getCell(11).getNumericCellValue())
                                .totalCost((double) row.getCell(12).getNumericCellValue())
                                .totalProfit((double) row.getCell(13).getNumericCellValue())
                                .build();

                        result.add(record);
                    }
                }
            }
        } catch (IOException e) {
            throw new IOException("fail to read excel file : " + e.getMessage(), e);
        }
        System.out.println(" record size is ===>"+result.size());
        System.out.println("End of file reader......."+(System.currentTimeMillis()-start) +"  millisecond");
        return result;
    }
}
