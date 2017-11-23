package com.wine_quality;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CVSReader reader = new CVSReader();
        ArrayList<Double> arrayList = reader.CVSRead();

        for (int i = 0; i < arrayList.size(); i++) {

            if (i < 10) System.out.println(arrayList.get(i));
        }
    }
}
