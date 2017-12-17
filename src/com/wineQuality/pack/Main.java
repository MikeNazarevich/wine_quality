package com.wineQuality.pack;

import com.wineQuality.view.MainWindow;

/**
 * Created by mikhail on 20.11.17.
 */
public class Main {
    public static void main(String[] args) {
        NeuralNetwork nn = new NeuralNetwork();
        //nn.network();
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }


//    public static void main(String[] args) {
//        Date currentTime = new Date();
//        NN nn = new NN(4,11);
//        nn.createLayer();
//        Date newTime = new Date();
//        long msDelay = newTime.getTime() - currentTime.getTime();
//        System.out.println("Time distance is: " + msDelay + " in ms");
//    }
}
