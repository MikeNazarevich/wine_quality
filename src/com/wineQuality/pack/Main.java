package com.wineQuality.pack;

import com.wineQuality.view.MainWindow;

//First of all, you should comment out the lines with mainWindow
//After first compilling you get weight coefficients, threshold values and other
//After you comment out nn.network , and uncomment lines with mainWindow
public class Main {
    public static void main(String[] args) {
        NeuralNetwork nn = new NeuralNetwork();
        nn.network(); //For get parametres from neural network

        MainWindow mainWindow = new MainWindow(); //For show gui
        mainWindow.setVisible(true);
    }
}
