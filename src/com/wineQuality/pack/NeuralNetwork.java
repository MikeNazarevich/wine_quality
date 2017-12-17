package com.wineQuality.pack;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class NeuralNetwork {

    public double param (ArrayList<Double> arr1, ArrayList<Double> arr, int hid, int inp) {
        double[][] w1 = new double[hid][inp];
        double[] w2 = new double[hid];
        ArrayList<Double> T1 = new ArrayList<>();
        double T2 = 0;
        int temp = 0;
        int kek = 11;

        for (int i = 0, k = 0, j = 0; i < arr.size(); i++) {
            if (i < (inp * hid + hid)) {
                if (i % kek == 0 && i != 0){
                    T1.add(arr.get(i));
                    k++;
                    j = 0;
                    kek += 12;
                }

                else {
                    w1[k][j] = arr.get(i);
                    j++;
                }
            } else {
                if (i < (inp * hid + 2 * hid)) {
                    w2[temp] = arr.get(i);
                    temp++;
                }
                else T2 = arr.get(i);
            }
        }

        return determQual(arr1, hid, inp, w1, w2, T1, T2);
    }

    public double determQual (ArrayList<Double> arr1, int hid, int inp, double[][] w1, double[] w2, ArrayList<Double> T1, double T2) {
        ArrayList<Double> mass = new ArrayList<>();
        ArrayList<Double> y1 = new ArrayList<>();
        mass = arr1;
        double y2, sum1 = 0.0;
//        mass.add(7.0);
//        mass.add(0.27);
//        mass.add(0.36);
//        mass.add(20.7);
//        mass.add(0.045);
//        mass.add(45.0);
//        mass.add(170.0);
//        mass.add(1.001);
//        mass.add(3.0);
//        mass.add(0.45);
//        mass.add(8.8);
        double sum = 0;
        Options options1 = new Options();
        mass = options1.normalizVhodn(mass);

        for (int i = 0; i < hid; i++) {
            sum = 0;
            for (int j = 0; j < inp; j++)
                sum += mass.get(j) * w1[i][j];

            y1.add(1 / (1 + Math.pow(Math.E, -(sum - T1.get(i)))));
        }

        for (int j = 0; j < hid; j++)
            sum1 += y1.get(j) * w2[j];

        y2 = sum1 - T2;
        y2 *= 10;
        return y2;
    }

    public double forButton(ArrayList<Double> arr) {
        CVSReader cvsReader = new CVSReader();
        ArrayList<Double> vhodn = new ArrayList<>();
        vhodn = cvsReader.CSVReader2("kek.csv");
        return param(arr, vhodn, 5, 11);
    }

    public void network(ArrayList<Double> arr) {
        Date currentTime = new Date();
        Random rnd = new Random(System.currentTimeMillis());

        String fileName = "db/winequality-white.csv";
        double a = 0.1, b = 0.1, c = 0.05, d = 0.1, alfa = 0.1, shag = 0.1;
        int input_layer = 11, hidden_layer = 5;


        Options options = new Options();
        CVSReader cvsReader = new CVSReader();




        ArrayList<Double> vhodn = new ArrayList<>();
        vhodn = cvsReader.CSVReader2("kek.csv");
        param(arr, vhodn, hidden_layer, input_layer);

        ArrayList<Double> x = new ArrayList<>();
        x = cvsReader.CVSRead(fileName, options);


        double[][] w1 = new double[hidden_layer][input_layer];
        for (int i = 0; i < hidden_layer; i++)
            for (int j = 0; j < input_layer; j++)
                w1[i][j] = rnd.nextDouble() - 0.5;

        double[] w2 = new double[hidden_layer];

        for (int i = 0; i < hidden_layer; i++)
            w2[i] = rnd.nextDouble() - 0.5;

        double[] T1 = new double[hidden_layer];
        for (int i = 0; i < hidden_layer; i++)
            T1[i] = 0;

        double T2 = 0;


        double[] y1 = new double[hidden_layer];
        double y2;
        double sum, sum1;
        double error_exit;
        double[] error_middle = new double[hidden_layer];
        long iteration = 0;
        double MeanSqErr = 0;




        while (true) {
            for (int i = 0; i < (x.size() - hidden_layer - 12);) {
                for (int j = 0; j < hidden_layer; j++) {
                    sum = 0;
                    for (int k = 0; k < input_layer; k++) {
                        sum += x.get(k + i) * w1[j][k];
                    }
                    y1[j] = 1 / (1 + Math.pow(Math.E, -(sum - T1[j])));

                }
                sum1 = 0;
                for (int j = 0; j < hidden_layer; j++) {
                    sum1 += y1[j] * w2[j];
                }
                y2 = sum1 - T2;
                error_exit = y2 - x.get(i + input_layer);


                for (int k = 0; k < hidden_layer; k++) {
                    error_middle[k] = error_exit * w2[k];
                }


                for (int j = 0; j < hidden_layer; j++) {
                    w2[j] -= alfa * error_exit * y2;
                }
                T2 += alfa * error_exit;


                for (int j = 0; j < hidden_layer; j++) {
                    for (int k = 0; k < input_layer; k++) {
                        w1[j][k] -= alfa * error_middle[j] * y1[j] * (1 - y1[j]) * x.get(i + k);
                    }
                    T1[j] += alfa * y1[j] * (1 - y1[j]) * error_middle[j];
                }
                i += 12;
            }
            iteration++;


            //АШИПКА
            for (int i = 0; i < (x.size() - hidden_layer - 12);) {
                for (int j = 0; j < hidden_layer; j++) {
                    sum = 0;
                    for (int k = 0; k < input_layer; k++) {
                        sum += x.get(k + i) * w1[j][k];
                    }
                    y1[j] = 1 / (1 + Math.pow(Math.E, -(sum - T1[j])));

                }
                sum1 = 0;
                for (int j = 0; j < hidden_layer; j++) {
                    sum1 += y1[j] * w2[j];
                }
                y2 = sum1 - T2;
                error_exit = y2 - x.get(i + input_layer);
                MeanSqErr += Math.pow(error_exit, 2);
                i += 12;
            }
            MeanSqErr /= 2;


            if (iteration % 100000 == 0) {
                System.out.println("Ideal: " + MeanSqErr);
                System.out.println("iteration: " + iteration);

            }

            if (MeanSqErr <= 0.1) {
                System.out.println("Ideal: " + MeanSqErr);
                System.out.println("iteration  : " + iteration);

                break;
            }
            MeanSqErr = 0;


        }

        CsvWrite csvWrite = new CsvWrite();
        csvWrite.writeCsvFile("kek.csv", w1, w2, T1, T2, input_layer, hidden_layer);


        Date newTime = new Date();
        long msDelay = newTime.getTime() - currentTime.getTime();
        System.out.println("Time distance is: " + msDelay + " in ms");
    }
}


    








//
//
//    private double[][] w1;
//    private ArrayList<Double> w2;
//
//    private ArrayList<Double> T1;
//    private double T2 = 0;
//
//    private ArrayList<Double> y1;
//    private ArrayList<Double> y2;
//
//    private ArrayList<Double> middleError;
//    private double exitError;
//
//    private ArrayList<Double> x;
//    private int numberAllInput;
//    private int numberHiddenLayer;
//    private int inputLayer;
//
//    private double alfa;
//
//
//    NN() {}
//    NN(int hiddenLayer, int inputLayer) {
//        alfa = 0.1;
//        this.inputLayer = inputLayer;
//        middleError = new ArrayList<>();
//        w1 = new double[hiddenLayer][inputLayer];
//        w2 = new ArrayList<>();
//        T1 = new ArrayList<>();
//        y1 = new ArrayList<>();
//        x = new ArrayList<>();
//        y2 = new ArrayList<>();
//        numberHiddenLayer = hiddenLayer;
//        Random rnd = new Random(System.currentTimeMillis());
//        com.wineQuality.pack.CVSReader cvsReader = new com.wineQuality.pack.CVSReader();
//        x = cvsReader.CVSRead();
//
////        System.out.println(x.size());
////        int l = 0;
////        while (l != x.size()){
////            System.out.println(x.get(l) + " ");
////            l++;
////        }
//        numberAllInput = cvsReader.CVSRead().size();
//
//        //ИНИЦИЛИЗИРУЕМ ВЕСОВЫЕ КОЭФИЦИЕНТЫ И ПОРОГОВЫЕ ЗНАЧЕНИЯ
//        for (int i = 0; i < hiddenLayer; i++) {
//            for (int j = 0; j < inputLayer; j++) {
////                w1.add(new ArrayList<Double>());
//                w1[i][j] = rnd.nextDouble() - 0.5;
//            }
//            T1.add(0.0);
//            w2.add(rnd.nextDouble() - 0.5);
//        }
//    }
//
//    public void createLayer() {
//        ArrayList<Double> hiddenError = new ArrayList<>();
//        double MeanSqErr = 0;
//        int iteration = 0;
//
//
//        while (true) {
//            for (int i = 0; i < numberAllInput - inputLayer; i++) {
//                setY1(i);
//                setY2();
//
//                setExitError(i);
//                setMiddleError(i);
//
//                changeProp(i);
//            }
//            System.out.println("iter+1");
//            iteration++;
//
//            for (int i = 0; i < numberAllInput - inputLayer; i++) {
//
//                setY1(i);
//                setY2();
//
//                setExitError(i);
//
//                MeanSqErr += Math.pow(exitError, 2);
//            }
//            MeanSqErr /= 2;
//
//            if (iteration % 10000  == 0) {
//                System.out.println("Ideal: " + MeanSqErr);
//                System.out.println("iteration: " + iteration);
//            }
//
//            if (MeanSqErr <= 0.001) {
//                System.out.println("Ideal: " + MeanSqErr);
//
//                System.out.println("iteration: " + iteration);
//                System.out.println("ggwp");
//                break;
//            }
//            System.out.println("lolkek");
//        }
//    }
//
//    public void setY1(int i) {
//        double sum;
//        for (int j = 0; j < numberHiddenLayer; j++) {
//            sum = 0;
//
//            for (int k = 0; k < inputLayer; k++)
//                sum += x.get(k + i) * w1[j][k];
//
//            y1.add(sigmfuncActiv(sum, j));
//        }
//    }
//
//    public void setY2() {
//        double sum = 0;
//        for (int j = 0; j < numberHiddenLayer; j++)
//            sum += y1.get(j) * w2.get(j);
//
//        y2.add(sum - T2);
//    }
//
//    public double sigmfuncActiv(double sum, int j) {
//        return (1 / (1 + Math.pow(Math.E, -(sum - T1.get(j)))));
//    }
//
//    public double setExitError(int i) {
//        return y2.get(i) - x.get(i + inputLayer);
//    }
//
//    public void setMiddleError(int i) {
//        for (int j = 0; j < numberHiddenLayer; j++)
//            middleError.add(j, setExitError(i) * w2.get(j));
//    }
//
//    public void changeProp(int i) {
//        for (int j = 0; j < numberHiddenLayer; j++)
//            w2.add(j, w2.get(j) - alfa * setExitError(i) * y2.get(i));
//
//        T2 += alfa * setExitError(i);
//
//        for (int j = 0; j < numberHiddenLayer; j++) {
//            for (int k = 0; k < inputLayer; k++)
//                w1[j][k] -= alfa * middleError.get(j) * y1.get(j) * (1 - y1.get(j)) * x.get(i + k);
//            T1.add(T1.get(j) + alfa * y1.get(j) * (1 - y1.get(j)) * middleError.get(j));
//        }
//    }
//}








//            if (iteration % 10000 == 0) {
//                System.out.println("Ideal: " + MeanSqErr);
//                System.out.println("iteration: " + iteration);
//
//            }
//
//            if (MeanSqErr <= 0.000_1) {
//                System.out.println("Ideal: " + MeanSqErr);
//                System.out.println("iteration  : " + iteration);
//
//
//                //ТУТ ТИПА ПРАГНАЗИРУЕМ
//                for (int i = (vxod_obr - input_layer); i < prognoz + vxod_obr - input_layer; i++) {
//                    for (int j = 0; j < hidden_layer; j++) {
//                        sum = 0;
//                        for (int k = 0; k < input_layer; k++) {
//                            sum += y2.get(k + i) * w1[j][k];
//                        }
//                        S[j] = sum - T1[j];
//                        y1[j] = 1 / (1 + Math.pow(Math.E, -S[j]));
//
//                    }
//                    sum1 = 0;
//                    for (int j = 0; j < hidden_layer; j++) {
//                        sum1 += y1[j] * w2[j];
//                    }
//                    S1[i] = sum1 - T2;
//                    y2.add(i + input_layer, S1[i]);
//                }
//
//                break;
//            }
//            MeanSqErr = 0;
//
//
//        }
//
//
////        for (int i = vxod_obr - input_layer; i < prognoz + vxod_obr; i++) {
////            x[i] = a * Math.cos(b * i * shag) + c * Math.sin(d * i * shag);
////        }
//
//
//        for (int i = vxod_obr; i < prognoz + vxod_obr; i++) {
//            System.out.println(i + ") " + x.get(i) + "  " + y2.get(i) + " " + (x.get(i) - y2.get(i)));
//        }
//
//        Date newTime = new Date();
//        long msDelay = newTime.getTime() - currentTime.getTime();
//        System.out.println("Time distance is: " + msDelay + " in ms");
//    }
//}
//
//
