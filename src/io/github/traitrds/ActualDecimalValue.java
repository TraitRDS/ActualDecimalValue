package io.github.traitrds;

import javax.swing.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ActualDecimalValue extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField inputValue;
    private JButton getActualValueButton;
    private JTextArea actualValue;
    private JTextArea jreVersion;
    private JTextArea formattedValue;

    private DecimalFormat df = new DecimalFormat("#.###");

    public ActualDecimalValue() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(getActualValueButton);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        getActualValueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputValue.getText();
                Double inputDouble = Double.parseDouble(inputText);

                actualValue.setText(" " + new BigDecimal(inputDouble).toPlainString());
//                actualValue.setText(" " + BigDecimal.valueOf(inputDouble).toPlainString());


                // String.format("%.3f", inputDouble));

                jreVersion.setText(" " + System.getProperty("java.version"));

                formattedValue.setText("Formatted double value = " + df.format(inputDouble) + "\nFormatted big decimal value = " + df.format(BigDecimal.valueOf(inputDouble)));


            }
        });
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ActualDecimalValue dialog = new ActualDecimalValue();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
