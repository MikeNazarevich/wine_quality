package com.wineQuality.view;
import com.wineQuality.pack.NeuralNetwork;
import com.wineQuality.util.ImageUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class MainWindow extends JFrame
{
    private javax.swing.JLabel alcoholLabel;
    private javax.swing.JSpinner alcoholSpinner;
    private javax.swing.JButton btnProcess;
    private javax.swing.JLabel chloridesLabel;
    private javax.swing.JSpinner chloridesSpinner;
    private javax.swing.JLabel citricAcidityLabel;
    private javax.swing.JSpinner citricAciditySpinner;
    private javax.swing.JLabel densityLabel;
    private javax.swing.JSpinner densitySpinner;
    private javax.swing.JLabel fixedAcidityLabel;
    private javax.swing.JSpinner fixedAciditySpinner;
    private javax.swing.JLabel freeSulfurDioxideLabel;
    private javax.swing.JSpinner freeSulfurDioxideSpinner;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JLabel phLabel;
    private javax.swing.JSpinner phSpinner;
    private javax.swing.JLabel residualSugarLabel;
    private javax.swing.JSpinner residualSugarSpinner;
    private javax.swing.JLabel sulphatesLabel;
    private javax.swing.JSpinner sulphatesSpinner;
    private javax.swing.JLabel totalSulfurDioxideLabel;
    private javax.swing.JSpinner totalSulfurDioxideSpinner;
    private javax.swing.JLabel volatileAcidityLabel;
    private javax.swing.JSpinner volatileAciditySpinner;


    public MainWindow()
    {
        initComponents();
        uiSetup();
    }

    private void uiSetup()
    {
        setIconImage(new ImageUtil().loadIcon("icons/wine-app.png").getImage());
        for (Object object : inputPanel.getComponents())
        {
            if (object instanceof JSpinner)
            {
                JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor)((JSpinner) object).getEditor();
                spinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
            }
        }
    }



    @SuppressWarnings("unchecked")
    private void initComponents() {
        ArrayList<Double> arr = new ArrayList<>();
        java.awt.GridBagConstraints gridBagConstraints;

        inputPanel = new javax.swing.JPanel();
        fixedAcidityLabel = new javax.swing.JLabel();
        volatileAcidityLabel = new javax.swing.JLabel();
        citricAcidityLabel = new javax.swing.JLabel();
        residualSugarLabel = new javax.swing.JLabel();
        fixedAciditySpinner = new javax.swing.JSpinner();
        volatileAciditySpinner = new javax.swing.JSpinner();
        citricAciditySpinner = new javax.swing.JSpinner();
        residualSugarSpinner = new javax.swing.JSpinner();
        chloridesLabel = new javax.swing.JLabel();
        chloridesSpinner = new javax.swing.JSpinner();
        freeSulfurDioxideLabel = new javax.swing.JLabel();
        freeSulfurDioxideSpinner = new javax.swing.JSpinner();
        totalSulfurDioxideLabel = new javax.swing.JLabel();
        totalSulfurDioxideSpinner = new javax.swing.JSpinner();
        densityLabel = new javax.swing.JLabel();
        densitySpinner = new javax.swing.JSpinner();
        sulphatesLabel = new javax.swing.JLabel();
        phSpinner = new javax.swing.JSpinner();
        phLabel = new javax.swing.JLabel();
        sulphatesSpinner = new javax.swing.JSpinner();
        alcoholLabel = new javax.swing.JLabel();
        alcoholSpinner = new javax.swing.JSpinner();
        btnProcess = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Wine Quality");
        setMaximumSize(new java.awt.Dimension(750, 360));
        setMinimumSize(new java.awt.Dimension(750, 360));
        setPreferredSize(new java.awt.Dimension(750, 360));
        setResizable(false);

        inputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));
        inputPanel.setLayout(new java.awt.GridBagLayout());

        fixedAcidityLabel.setText("Fixed Acidity");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        inputPanel.add(fixedAcidityLabel, gridBagConstraints);

        volatileAcidityLabel.setText("Volatile Acidity");
        volatileAcidityLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        inputPanel.add(volatileAcidityLabel, gridBagConstraints);

        citricAcidityLabel.setText("Citric Acidity");
        citricAcidityLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        inputPanel.add(citricAcidityLabel, gridBagConstraints);

        residualSugarLabel.setText("Residual Sugar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        inputPanel.add(residualSugarLabel, gridBagConstraints);

        fixedAciditySpinner.setModel(new javax.swing.SpinnerNumberModel(7.0d, 3.8d, 14.2d, 0.1d));
        fixedAciditySpinner.setToolTipText("Min: 3.8 - Max: 14.2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
        inputPanel.add(fixedAciditySpinner, gridBagConstraints);

        volatileAciditySpinner.setModel(new javax.swing.SpinnerNumberModel(0.27d, 0.08d, 1.1d, 0.001d));
        volatileAciditySpinner.setToolTipText("Min: 0.08 - Max: 1.1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
        inputPanel.add(volatileAciditySpinner, gridBagConstraints);

        citricAciditySpinner.setModel(new javax.swing.SpinnerNumberModel(0.36d, 0.0d, 1.66d, 0.01d));
        citricAciditySpinner.setToolTipText("Min: 0 - Max: 1.66");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
        inputPanel.add(citricAciditySpinner, gridBagConstraints);

        residualSugarSpinner.setModel(new javax.swing.SpinnerNumberModel(20.7d, 0.6d, 65.8d, 0.01d));
        residualSugarSpinner.setToolTipText("Min: 0.6 - Max: 65.8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
        inputPanel.add(residualSugarSpinner, gridBagConstraints);

        chloridesLabel.setText("Chlorides");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        inputPanel.add(chloridesLabel, gridBagConstraints);

        chloridesSpinner.setModel(new javax.swing.SpinnerNumberModel(0.045d, 0.009d, 0.346d, 0.001d));
        chloridesSpinner.setToolTipText("Min: 0.009 - Max: 0.346");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
        inputPanel.add(chloridesSpinner, gridBagConstraints);

        freeSulfurDioxideLabel.setText("Free Sulfur Dioxide");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        inputPanel.add(freeSulfurDioxideLabel, gridBagConstraints);

        freeSulfurDioxideSpinner.setModel(new javax.swing.SpinnerNumberModel(45.0d, 2.0d, 289.0d, 1.0d));
        freeSulfurDioxideSpinner.setToolTipText("Min: 2 - Max: 289");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
        inputPanel.add(freeSulfurDioxideSpinner, gridBagConstraints);

        totalSulfurDioxideLabel.setText("Total Sulfur Dioxide");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        inputPanel.add(totalSulfurDioxideLabel, gridBagConstraints);

        totalSulfurDioxideSpinner.setModel(new javax.swing.SpinnerNumberModel(170.0d, 9.0d, 440.0d, 0.5d));
        totalSulfurDioxideSpinner.setToolTipText("Min: 9 - Max: 440");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
        inputPanel.add(totalSulfurDioxideSpinner, gridBagConstraints);

        densityLabel.setText("Density");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        inputPanel.add(densityLabel, gridBagConstraints);

        densitySpinner.setModel(new javax.swing.SpinnerNumberModel(1.001d, 0.98711d, 1.0389d, 0.001d));
        densitySpinner.setToolTipText("Min: 0.98711 - Max: 1.0389");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
        inputPanel.add(densitySpinner, gridBagConstraints);

        sulphatesLabel.setText("Sulphates");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        inputPanel.add(sulphatesLabel, gridBagConstraints);

        phSpinner.setModel(new javax.swing.SpinnerNumberModel(3.0d, 2.72d, 3.82d, 0.01d));
        phSpinner.setToolTipText("Min: 2.72 - Max: 3.82");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
        inputPanel.add(phSpinner, gridBagConstraints);

        phLabel.setText("pH");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        inputPanel.add(phLabel, gridBagConstraints);

        sulphatesSpinner.setModel(new javax.swing.SpinnerNumberModel(0.45d, 0.22d, 1.08d, 0.01d));
        sulphatesSpinner.setToolTipText("Min: 0.22 - Max: 1.08");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 5);
        inputPanel.add(sulphatesSpinner, gridBagConstraints);

        alcoholLabel.setText("Alcohol");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        inputPanel.add(alcoholLabel, gridBagConstraints);

        alcoholSpinner.setModel(new javax.swing.SpinnerNumberModel(8.8d, 8.0d, 14.2d, 0.01d));
        alcoholSpinner.setToolTipText("Min: 8 - Max: 14.2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 5);
        inputPanel.add(alcoholSpinner, gridBagConstraints);


        btnProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/wineQuality/view/assets/icons/actions_32x32/process.png"))); // NOI18N
        ActionListener actionListener = new TestActionListener();
        btnProcess.addActionListener(actionListener);

        btnProcess.setMnemonic('p');
        btnProcess.setToolTipText("Process");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        inputPanel.add(btnProcess, gridBagConstraints);

        getContentPane().add(inputPanel, java.awt.BorderLayout.CENTER);


        pack();
    }


    private ArrayList<Double> btnProcessActionPerformed() {
        double alcoholSpin = (Double)alcoholSpinner.getValue();
        double chloridSpin = (Double)chloridesSpinner.getValue();
        double citricSpin = (Double)citricAciditySpinner.getValue();
        double densitSpin = (Double)densitySpinner.getValue();
        double fixedAcidSpin = (Double) fixedAciditySpinner.getValue();
        double freeSulfSpin = (Double)freeSulfurDioxideSpinner.getValue();
        double phSpin = (Double)phSpinner.getValue();
        double residualSpin = (Double)residualSugarSpinner.getValue();
        double sulphatesSpin = (Double) sulphatesSpinner.getValue();
        double totalSulfSpin = (Double)totalSulfurDioxideSpinner.getValue();
        double volatileSpin = (Double)volatileAciditySpinner.getValue();

        ArrayList<Double> arr = new ArrayList<>();
        arr.add(fixedAcidSpin);
        arr.add(volatileSpin);
        arr.add(citricSpin);
        arr.add(residualSpin);
        arr.add(chloridSpin);
        arr.add(freeSulfSpin);
        arr.add(totalSulfSpin);
        arr.add(densitSpin);
        arr.add(phSpin);
        arr.add(sulphatesSpin);
        arr.add(alcoholSpin);
        return arr;
    }

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Double> arrayList = new ArrayList<>();
            arrayList = btnProcessActionPerformed();

            NeuralNetwork neuralNetwork  = new NeuralNetwork();
            double mark;
            mark = neuralNetwork.forButton(arrayList);

            JOptionPane.showConfirmDialog(null,
                    mark,
                    "TITLE",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

}