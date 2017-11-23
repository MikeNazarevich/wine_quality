package com.wine_quality;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class NN {
    private ArrayList<ArrayList<Double>> w1;
    private ArrayList<Double> w2;

    private ArrayList<Double> T1;
    private double T2 = 0;

    private ArrayList<Double> y1;
    private ArrayList<Double> y2;

    private ArrayList<Double> middleError;
    private double exitError;

    private ArrayList<Double> x;
    private int numberInput;
    private int numberHiddenLayer;

    private double alfa;


    NN() {
        ArrayList<ArrayList<Double>> w1 = new ArrayList<>();
        ArrayList<Double> w2 = new ArrayList<>();
        ArrayList<Double> T1 = new ArrayList<>();
        ArrayList<Double> y1 = new ArrayList<>();
        ArrayList<Double> x = new ArrayList<>();
    }

    NN(int hiddenLayer, int inputLayer) {
        alfa = 0.1;
        Random rnd = new Random(System.currentTimeMillis());
        CVSReader cvsReader = new CVSReader();
        x = cvsReader.CVSRead();
        numberInput = cvsReader.CVSRead().size();

        w1.add(new ArrayList<Double>());
        for (int i = 0; i < hiddenLayer; i++) {
            for (int j = 0; j < inputLayer; j++)
                w1.get(i).add(rnd.nextDouble() - 0.5);
            T1.add(0.0);
            w2.add(rnd.nextDouble() - 0.5);
        }
    }

    public void createLayer() {
        ArrayList<Double> hiddenError = new ArrayList<>();
        double MeanSqErr = 0;
        int iteration = 0;


        while (true) {
            for (int i = 0; i < numberInput; i++) {
                setY1(i);
                setY2();

                setExitError(i);
                setMiddleError(i);

                changeProp(i);
            }
            iteration++;

            for (int i = 0; i < numberInput; i++) {
                setY1(i);
                setY2();

                setExitError(i);

                MeanSqErr += Math.pow(exitError, 2);
            }
            MeanSqErr /= 2;

            if (iteration % 10000 == 0) {
                System.out.println("Ideal: " + MeanSqErr);
                System.out.println("iteration: " + iteration);
            }

        }
    }

    public void setY1(int i) {
        double sum;
        for (int j = 0; j < numberHiddenLayer; j++) {
            sum = 0;
            for (int k = 0; k < numberInput; k++)
                sum += x.get(k + i) * w1.get(j).get(k);
            y1.add(1 / (1 + Math.pow(Math.E, (sum - T1.get(j)))));
        }
    }

    public void setY2() {
        double sum1 = 0;
        for (int j = 0; j < numberHiddenLayer; j++) {
            sum1 += y1.get(j) * w2.get(j);
        }
        y2.add(sum1 - T2);
    }

    public double setExitError(int i) {
        return y2.get(i) - x.get(i + numberInput);
    }

    public void setMiddleError(int i) {
        for (int j = 0; j < numberHiddenLayer; j++)
            middleError.add(setExitError(i) * w2.get(j));
    }

    public void changeProp(int i) {
        for (int j = 0; j < numberHiddenLayer; j++) {
            w2.add(w2.get(j) - alfa * setExitError(i) * y2.get(i));
            for (int k = 0; k < numberInput; k++)
                w1.get(j).add(k, w1.get(j).get(k) - alfa * middleError.get(j) * y1.get(j) * (1 - y1.get(j)) * x.get(i + k));
            T1.add(j, T1.get(j) + alfa * y1.get(j) * (1 - y1.get(j)) * middleError.get(j));
        }
        T2 += alfa * setExitError(i);
    }
}
