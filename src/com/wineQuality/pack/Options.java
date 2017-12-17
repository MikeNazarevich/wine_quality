package com.wineQuality.pack;

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

    private ArrayList<Double> mass = new ArrayList<>();
    private ArrayList<Double> minValues = new ArrayList<>();
    private ArrayList<Double> maxValues = new ArrayList<>();

    public void  minMaxVal() {
        CsvWrite csvWrite = new CsvWrite();
        addMinValues();
        addMaxValues();
        csvWrite.writeMinMax("minmaxVal.csv", 11, minValues, maxValues);
    }

    public void addMinValues() {

        minValues.add(min_value(fix_acidity));
        minValues.add(min_value(vol_acidity));
        minValues.add(min_value(citr_acid));
        minValues.add(min_value(resid_sugar));
        minValues.add(min_value(chlorides));
        minValues.add(min_value(free_sulful_diox));
        minValues.add(min_value(total_sulfur_diox));
        minValues.add(min_value(density));
        minValues.add(min_value(pH));
        minValues.add(min_value(sulphates));
        minValues.add(min_value(alcohol));
    }

    public void addMaxValues() {
        maxValues.add(max_value(fix_acidity));
        maxValues.add(max_value(vol_acidity));
        maxValues.add(max_value(citr_acid));
        maxValues.add(max_value(resid_sugar));
        maxValues.add(max_value(chlorides));
        maxValues.add(max_value(free_sulful_diox));
        maxValues.add(max_value(total_sulfur_diox));
        maxValues.add(max_value(density));
        maxValues.add(max_value(pH));
        maxValues.add(max_value(sulphates));
        maxValues.add(max_value(alcohol));
    }

    public void addToOptions(String[] opt){
        fix_acidity.add(Double.parseDouble(opt[0]));
        vol_acidity.add(Double.parseDouble(opt[1]));
        citr_acid.add(Double.parseDouble(opt[2]));
        resid_sugar.add(Double.parseDouble(opt[3]));
        chlorides.add(Double.parseDouble(opt[4]));
        free_sulful_diox.add(Double.parseDouble(opt[5]));
        total_sulfur_diox.add(Double.parseDouble(opt[6]));
        density.add(Double.parseDouble(opt[7]));
        pH.add(Double.parseDouble(opt[8]));
        sulphates.add(Double.parseDouble(opt[9]));
        alcohol.add(Double.parseDouble(opt[10]));
        quality.add(Double.parseDouble(opt[11]));
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
    }

    public void normalization(ArrayList<Double> arr) {
        ArrayList<Double> norm = new ArrayList<>();
        norm = (ArrayList<Double>)arr.clone();
        arr.clear();
        for (int i = 0; i < norm.size(); i++){
            arr.add(((norm.get(i) - min_value(norm)) * (1 - 0)) / (max_value(norm) - min_value(norm)));
        }
    }

    public ArrayList<Double> normalizVhodn(ArrayList<Double> arr) {
        ArrayList<Double> minmax = new ArrayList<>();
        CVSReader cvsReader = new CVSReader();
        minmax = cvsReader.CSVReader3("minmaxVal.csv");

        for (int i = 0; i < arr.size(); i++) {
            mass.add(i, ((arr.get(i) - minmax.get(i) * (1 - 0)) / (minmax.get(i + 11) - minmax.get(i))));
        }
        return mass;
    }

    public void normalizeQuality(ArrayList<Double> arr) {
        ArrayList<Double> norm = new ArrayList<>();
        norm = (ArrayList<Double>)arr.clone();
        arr.clear();
        for (int i = 0; i < norm.size(); i++) {
            arr.add(norm.get(i) / 10);
        }
    }

    public void normalizeAttrib() {
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
        normalizeQuality(quality);
    }

    public ArrayList<Double> allOptionsInArray(){
        minMaxVal();
        normalizeAttrib();
        for (int i = 0; i < 50; i++) {
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
        return all_options;
    }
}
