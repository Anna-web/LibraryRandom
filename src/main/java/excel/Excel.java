package excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    private Workbook wb;
    private FileInputStream fis;

    public Excel(String filename) {
        initWorkbook(filename);
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initWorkbook(String filename) {
        try {
            fis = new FileInputStream(filename);
            this.wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getMaleNameList() { return readSheet(0, true); }
    public ArrayList<String> getFemaleNameList() { return readSheet(0, false); }
    public ArrayList<String> getMaleStudentLastNameList() {
        return readSheet(1, true);
    }
    public ArrayList<String> getFemaleStudentLastNameList() {
        return readSheet(1, false);
    }
    public ArrayList<String> getMaleProfLastNameList() {
        return readSheet(2, true);
    }
    public ArrayList<String> getFemaleProfLastNameList() {
        return readSheet(2, false);
    }
    public ArrayList<String> getMaleFathersName() { return readSheet(3, true); }
    public ArrayList<String> getFemaleFathersName() {
        return readSheet(3, false);
    }

    private ArrayList<String> readSheet(int sheetNum, boolean male) {
        Sheet sheet = wb.getSheetAt(sheetNum);
        ArrayList<String> list = new ArrayList<String>();
        for (Row row : sheet) {
            if (male ? row.getCell(1).getBooleanCellValue()
                    : !row.getCell(1).getBooleanCellValue())
                list.add(row.getCell(0).getStringCellValue());
        }
        return list;
    }
}