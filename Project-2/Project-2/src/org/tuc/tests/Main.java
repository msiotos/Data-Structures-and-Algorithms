package org.tuc.tests;

import java.io.IOException;
import org.tuc.utils.*;

public class Main{
	
public static void main(String[] args) {
        System.out.printf("Starting tests...\n\n");
        String fileNamePrefix = "D:\\Downloads\\randomnumbers\\numbers-";

        int[] nValues = {20, 50, 100, 200, 1000, 2500, 5000, 10000, 20000, 40000, 60000, 80000, 100000, 200000, 1000000, 1500000, 2000000, 2500000, 3000000};

        RandomNumbersToFiles.main(new String[]{});
        
        try {
            Tester.runTest(fileNamePrefix, nValues);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}