package com.cybertek.tests.d18_data_driven_testing;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilityDemo {

    @Test
    public void readExcelTest() {

        // create an instatnce of the excel utility
        // argument 1: location of the file
        // argument 2: sheet we want to open
        // whem we create object of this utility it means we opened the file and accesses certain sheet inside it
        ExcelUtil qa1Short = new ExcelUtil("src/test/resources/Vytrack testusers.xlsx", "QA1-short");
        // get number of columns
        System.out.println("Column count: " + qa1Short.columnCount());
        // get all column names
        System.out.println(qa1Short.getColumnsNames());

        // get all data
        List<Map<String, String>> dataList = qa1Short.getDataList();

        for (Map<String, String> stringStringMap : dataList) {
            System.out.println(stringStringMap);


            String[][] dataArray = qa1Short.getDataArray();
            System.out.println("==========================");

            System.out.println(Arrays.deepToString(dataArray));

        }
    }
}
