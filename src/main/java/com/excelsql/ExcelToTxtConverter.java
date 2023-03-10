package com.excelsql;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.commons.csv.*;

public class ExcelToTxtConverter {

    public static void main(String[] args) throws Exception {
        
        // Open excel file
        String filePath = "path/file.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(inputStream);

        // Read table
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        FileWriter writer = new FileWriter("sql.txt");

        // Write each line in a text file
        for (Row row : sheet) {
            String id = dataFormatter.formatCellValue(row.getCell(0)); //table columm
            String opo = dataFormatter.formatCellValue(row.getCell(2)); //table columm
            if (!id.equals("") && !opo.equals("")) {
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
                csvPrinter.printRecord("UPDATE tabela SET colunaX = 1  WHERE id =" + id + " AND colunaY IS NULL;");
                csvPrinter.flush();
            }
        }
        
        // Close arquives
        writer.close();
        workbook.close();
        inputStream.close();
    }
}