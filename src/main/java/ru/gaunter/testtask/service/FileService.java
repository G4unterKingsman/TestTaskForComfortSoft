package ru.gaunter.testtask.service;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import ru.gaunter.testtask.util.MinFinder;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    public int readFile(String path, int n) {
        List<Integer> numbers = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(path);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                    numbers.add((int) cell.getNumericCellValue());
            }

        } catch (Exception e) {
            throw new RuntimeException("Ошибка чтения файла" + e.getMessage());
        }

        int[] arr = numbers
                .stream()
                .mapToInt(i -> i)
                .toArray();

        return MinFinder.getMin(arr, n);
    }
}
