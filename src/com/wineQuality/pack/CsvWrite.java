package com.wineQuality.pack;

import java.io.*;
import java.util.ArrayList;

public class CsvWrite {
    private static final String DELIMETER = ",";
    private static final String SEPARATOR = "\n";

    private static final String HEADER = "KEK";

    public void writeCsvFile(String fileName, double[][] w1, double[] w2, double[] T1, double T2, int inp, int h) {
        FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(fileName);

            for (int i = 0; i < h; i++) {
                String kek = "";
                String lol = "";
                for (int j = 0; j < inp; j++) {
                    kek += w1[i][j] + ",";
                }
                fileWriter.append(kek);
                fileWriter.append(SEPARATOR);
                fileWriter.append(lol + T1[i]);
                fileWriter.append(SEPARATOR);
            }
            String kek = "";
            for (int i = 0; i < h; i++) {
                kek += w2[i] + ",";
            }
            fileWriter.append(kek);
            fileWriter.append(SEPARATOR);
            fileWriter.append("" + T2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeMinMax(String fileName, int inp, ArrayList<Double> minVal, ArrayList<Double> maxVal) {
        FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(fileName);


            String kek = "";
            String lol = "";
            String cheburek = "";
            for (int j = 0; j < inp; j++) {
                kek +=  minVal.get(j) + ",";
            }
            fileWriter.append(kek);

            fileWriter.append(SEPARATOR);

            kek = "";
            for (int i = 0; i < inp; i++) {
                kek += maxVal.get(i) + ",";
            }
            fileWriter.append(kek);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
