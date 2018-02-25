package com.wineQuality.pack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CVSReader {

    public ArrayList<Double> CVSRead(String fileName, Options options) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int count = 0;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                if (count == 0) {
                    count++;
                    continue;
                }
                String[] values = line.split(cvsSplitBy);
                options.addToOptions(values);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return options.allOptionsInArray();
    }

    public ArrayList<Double> CSVReader2(String fileName) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int count = 0;
        ArrayList<Double> mass = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(cvsSplitBy);

                for (int i = 0; i < values.length; i++)
                    mass.add(Double.parseDouble(values[i]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return mass;
    }


}
