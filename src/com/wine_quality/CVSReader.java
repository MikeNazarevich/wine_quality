package com.wine_quality;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CVSReader {

    public void CVSRead() {
        Options options = new Options();

        String csvFile = ".//db/winequality-white.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int count = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
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
    }
}
