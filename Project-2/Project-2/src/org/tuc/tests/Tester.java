package org.tuc.tests;

import java.util.Random;
import java.io.*;
import org.tuc.avl.*;
import org.tuc.bst.*;
import org.tuc.btree.*;
import org.tuc.linearhashing.*;
import org.tuc.interfaces.*;
import org.tuc.utils.*;

public class Tester {
    private static final String[] structureNames = {"AVLTree", "BSTree", "BTree (100)", "BTree (600)", "LinearHashing (40,500)", "LinearHashing(1000,500)"};
    private static final int STRUCTURE_COUNT = structureNames.length;


    public static void runTest(String fileNamePrefix, int[] nValues) throws IOException {
        double[][] insertTimes = new double[nValues.length][STRUCTURE_COUNT];
        double[][] searchTimes = new double[nValues.length][STRUCTURE_COUNT];
        double[][] levelsCounts = new double[nValues.length][STRUCTURE_COUNT];

        for (int i = 0; i < nValues.length; i++) {
            int n = nValues[i];
            String fileName = fileNamePrefix + n + ".bin";

            int[] keys = RandomNumbersToFiles.readInts(fileName);
            
            SearchInsert[] structures = createInstances();

            insertNKeys(keys, structures);

            for (int j = 0; j < structures.length; j++) {
                SearchInsert structure = structures[j];
                int counterIndex = getCounterIndex(structure);
                PerformanceResult result = measurePerformance(structure, n, counterIndex);

                insertTimes[i][j] = result.avgInsertTime;
                searchTimes[i][j] = result.avgSearchTime;
                levelsCounts[i][j] = result.avgLevels;
            }
        }
        
        printResults("Average Insert Times (ns)", nValues, insertTimes);
        printResults("Average Search Times (ns)", nValues, searchTimes);
        printResults("Average Levels Count", nValues, levelsCounts);
    }

    private static int getCounterIndex(SearchInsert structure) {
        if (structure instanceof AVLTree) return 1;
        if (structure instanceof BSTree) return 2;
        if (structure instanceof BTree) return 3;
        if (structure instanceof LinearHashing) return 4;
        return 0; // Default case, shouldn't occur
    }
    
    public static void insertNKeys(int[] keys, SearchInsert[] structures) {
        for (SearchInsert structure : structures) {
            for (int key : keys) {
                structure.insert(key);
            }
        }
    }

    public static PerformanceResult measurePerformance(SearchInsert structure, int n, int counterIndex) {
        Random random = new Random();
        int k = getK(n);
        int[] insertKeys = random.ints(1, 3 * n + 1).distinct().limit(k).toArray();
        int[] searchKeys = random.ints(1, 3 * n + 1).distinct().limit(k).toArray();

        long totalInsertTime = 0;
        long totalSearchTime = 0;
        int totalLevels = 0;

        for (int key : insertKeys) {
            totalInsertTime += measureInsertTime(structure, key);
        }
        
        for (int key : searchKeys) {
        	MultiCounter.resetCounter(counterIndex);
            totalSearchTime += measureSearchTime(structure, key);
            totalLevels += MultiCounter.getCount(counterIndex);
        }

        double avgInsertTime = (double) totalInsertTime / k;
        double avgSearchTime = (double) totalSearchTime / k;
        double avgLevels = (double) totalLevels / k;

        return new PerformanceResult(avgInsertTime, avgSearchTime, avgLevels);
    }

    private static long measureInsertTime(SearchInsert structure, int key) {
        long startTime = System.nanoTime();
        structure.insert(key);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long measureSearchTime(SearchInsert structure, int key) {
        long startTime = System.nanoTime();
        structure.searchKey(key);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }


    private static int getK(int n) {
        if (n < 201) return 10;
        if (n < 1001) return 50;
        return 100;
    }


    public static SearchInsert[] createInstances() {
        return new SearchInsert[]{
            new AVLTree(),
            new BSTree(),
            new BTree(100),
            new BTree(600),
            new LinearHashing(40, 500),
            new LinearHashing(1000, 500)
        };
    }

    static class PerformanceResult {
        double avgInsertTime;
        double avgSearchTime;
        double avgLevels;

        PerformanceResult(double avgInsertTime, double avgSearchTime, double avgLevels) {
            this.avgInsertTime = avgInsertTime;
            this.avgSearchTime = avgSearchTime;
            this.avgLevels = avgLevels;
        }
    }
    
    public static void printResults(String title, int[] nValues, double[][] results) {
        System.out.println(title);
        System.out.println("**********************************************************************************"
                + "*******************************************************************************************");
        
        System.out.print("N\\Structure\t");
        for (String name : structureNames) {
            System.out.printf("| %-23s ", name);  
        }
        System.out.println("|");
        
        System.out.print("---------------\t");
        for (String name : structureNames) {
            System.out.print("|-------------------------");  
        }
        System.out.println("|");
        
        for (int i = 0; i < nValues.length; i++) {
            System.out.printf("N=%-8d\t", nValues[i]);
            for (int j = 0; j < STRUCTURE_COUNT; j++) {
                System.out.printf("| %-23.2f ", results[i][j]); 
            }
            System.out.println("|");
        }
        System.out.println();
    }
}
