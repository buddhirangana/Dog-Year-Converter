package DogYearConverter;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DogYearConverter extends JFrame {

    private static final int DOG_YEARS_PER_HUMAN_YEAR = 7;
    private final JTextField _humanYearsTF = new JTextField(3);
    private final JTextField _dogYearsTF = new JTextField(3);

    public static void main(String[] args) {
        DogYearConverter window = new DogYearConverter();
        window.setVisible(true);
    }

    public DogYearConverter() {
        JButton convertBtn = new JButton("Convert");
        convertBtn.addActionListener(new ConvertBtnListener());
        _dogYearsTF.addActionListener(new ConvertBtnListener());
        _humanYearsTF.setEditable(false);

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());

        content.add(new JLabel("Dog Years"));
        content.add(_dogYearsTF);
        content.add(convertBtn);
        content.add(new JLabel("Human Years"));
        content.add(_humanYearsTF);
        setContentPane(content);
        pack();
        setTitle("Dog Year Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    class ConvertBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String dyStr = _dogYearsTF.getText();
            int dogYears = Integer.parseInt(dyStr);
            int humanYears = dogYears * DOG_YEARS_PER_HUMAN_YEAR;
            _humanYearsTF.setText("" + humanYears);
        }

    }
}
