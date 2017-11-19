package com.wine_quality;

import java.util.ArrayList;

public class Options {
    private ArrayList<Double> fix_acidity = new ArrayList<Double>();
    private ArrayList<Double> vol_acidity = new ArrayList<Double>();
    private ArrayList<Double> citr_acid = new ArrayList<Double>();
    private ArrayList<Double> resid_sugar = new ArrayList<Double>();
    private ArrayList<Double> chlorides = new ArrayList<Double>();
    private ArrayList<Double> free_sulful_diox = new ArrayList<Double>();
    private ArrayList<Double> total_sulfur_diox = new ArrayList<Double>();
    private ArrayList<Double> density = new ArrayList<Double>();
    private ArrayList<Double> pH = new ArrayList<Double>();
    private ArrayList<Double> sulphates = new ArrayList<Double>();
    private ArrayList<Double> alcohol = new ArrayList<Double>();
    private ArrayList<Double> quality = new ArrayList<Double>();
    private ArrayList<Double> all_options = new ArrayList<Double>();


    public void addToOptions(String[] country){
        fix_acidity.add(Double.parseDouble(country[0]));
        vol_acidity.add(Double.parseDouble(country[1]));
        citr_acid.add(Double.parseDouble(country[2]));
        resid_sugar.add(Double.parseDouble(country[3]));
        chlorides.add(Double.parseDouble(country[4]));
        free_sulful_diox.add(Double.parseDouble(country[5]));
        total_sulfur_diox.add(Double.parseDouble(country[6]));
        density.add(Double.parseDouble(country[7]));
        pH.add(Double.parseDouble(country[8]));
        sulphates.add(Double.parseDouble(country[9]));
        alcohol.add(Double.parseDouble(country[10]));
        quality.add(Double.parseDouble(country[11]));
    }

    public void show(ArrayList<Double> arr){
        for (Double d: arr) {
            System.out.print(d + " ");
        }
    }

    public ArrayList<Double> getAll_options(){
        return all_options;
    }

    public double average_value(ArrayList<Double> arr){
        double sum = 0;
        for(int i = 0; i < arr.size(); i++){
            sum += arr.get(i);
        }
        sum /= arr.size();
        return sum;
    }

    public double min_value(ArrayList<Double> arr){
        double min = arr.get(0);
        for (int i = 0; i < arr.size(); i++){
            if (min > arr.get(i))
                min = arr.get(i);
        }
        return min;
    }

    public double max_value(ArrayList<Double> arr){
        double max = arr.get(0);
        for (int i = 0; i < arr.size(); i++){
            if (max < arr.get(i))
                max = arr.get(i);
        }
        return max;
    }

    public void quartile_value(ArrayList<Double> arr){

        for(int i = arr.size() - 1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){

                if( arr.get(j) > arr.get(j + 1) ){
                    double tmp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set((j + 1), tmp);
                }
            }
        }
        int quartile25 = (arr.size() + 1) / 4;
        int quartile50= (arr.size() + 1) / 2;
        int quartile75 = 3 * (arr.size() + 1) / 4;


        System.out.println(quartile25 + " " + quartile50 + " " + quartile75);
    }
    public void standard_deviation(ArrayList<Double> arr, double aver){
        double sum = 0;
        for (int i = 0; i < arr.size(); i++){
            sum += Math.pow(arr.get(i) - aver, 2);
        }
        sum /= arr.size();
        sum = Math.sqrt(sum);
        //System.out.println(sum);
    }
    public void normalization(ArrayList<Double> arr){
        ArrayList<Double> norm = new ArrayList<>();
        norm = (ArrayList<Double>)arr.clone();
        arr.clear();
        for (int i = 0; i < norm.size(); i++){
            arr.add(((norm.get(i) - min_value(norm)) * (1 - 0)) / (max_value(norm) - min_value(norm)));
        }
    }
    public void normalizeAttrib(ArrayList<Double> arr) {
        normalization(fix_acidity);
        normalization(vol_acidity);
        normalization(citr_acid);
        normalization(resid_sugar);
        normalization(chlorides);
        normalization(free_sulful_diox);
        normalization(total_sulfur_diox);
        normalization(density);
        normalization(pH);
        normalization(sulphates);
        normalization(alcohol);
        normalization(quality);
    }
    public void allOptionsInArray(){
        for (int i = 0; i < fix_acidity.size() * 12; i++) {
            all_options.add(fix_acidity.get(i));
            all_options.add(vol_acidity.get(i));
            all_options.add(citr_acid.get(i));
            all_options.add(resid_sugar.get(i));
            all_options.add(chlorides.get(i));
            all_options.add(free_sulful_diox.get(i));
            all_options.add(total_sulfur_diox.get(i));
            all_options.add(density.get(i));
            all_options.add(pH.get(i));
            all_options.add(sulphates.get(i));
            all_options.add(alcohol.get(i));
            all_options.add(quality .get(i));
        }
    }
}
