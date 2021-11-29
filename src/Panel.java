import javax.swing.*;
import java.awt.event.*;

public class Panel extends JPanel implements  ActionListener {
    public static JTextField output = new JTextField();

    private JButton buttonNumber[] = new JButton[11];
    private JButton buttonRomanNumber[] = new JButton[]{
            new JButton("I"),
            new JButton("V"),
            new JButton("X"),
            new JButton("L"),
            new JButton("C"),
            new JButton("D"),
            new JButton("M")
    };
    private JButton plusMinus = new JButton("+/-");
    private JButton minus = new JButton("-");
    private JButton plus = new JButton("+");
    private JButton multi = new JButton("*");
    private JButton dev = new JButton("/");
    private JButton remain = new JButton("%");
    private JButton result = new JButton("=");
    private JButton delete = new JButton("<");
    protected static String input = "";
    protected static int romanOne = 0;
    protected static int romanTwo = 0;
    protected static String romanResult = "";
    protected static String numberOne;
    protected static double numberTwo = 0d;
    protected static double arabicResult = 0;
    protected static char operation;

    public Panel() {
        setLayout(null);
        setFocusable(true);
        grabFocus();
        buttonRomanNumber[0].setBounds(330, 70, 50, 50);
        add(buttonRomanNumber[0]);
        buttonRomanNumber[1].setBounds(390, 70, 50, 50);
        add(buttonRomanNumber[1]);
        buttonRomanNumber[2].setBounds(330, 130, 50, 50);
        add(buttonRomanNumber[2]);
        buttonRomanNumber[3].setBounds(390, 130, 50, 50);
        add(buttonRomanNumber[3]);
        buttonRomanNumber[4].setBounds(330, 190, 50, 50);
        add(buttonRomanNumber[4]);
        buttonRomanNumber[5].setBounds(390, 190, 50, 50);
        add(buttonRomanNumber[5]);
        buttonRomanNumber[6].setBounds(390, 250, 50, 50);
        add(buttonRomanNumber[6]);

        plus.setBounds(200, 70, 50, 50);
        add(plus);
        plus.addActionListener(this);
        minus.setBounds(260, 70, 50, 50);
        add(minus);
        minus.addActionListener(this);
        dev.setBounds(260, 130, 50, 50);
        add(dev);
        dev.addActionListener(this);
        remain.setBounds(260, 190, 50, 50);
        add(remain);
        remain.addActionListener(this);
        multi.setBounds(200, 130, 50, 50);
        add(multi);
        multi.addActionListener(this);
        result.setBounds(260, 250, 110, 50);
        add(result);
        result.addActionListener(this);
        delete.setBounds(200, 190, 50, 110);
        add(delete);
        delete.addActionListener(this);


        plusMinus.setBounds(70, 250, 50, 50);
        add(plusMinus);
        plusMinus.addActionListener(this);

        buttonNumber[10] = new JButton(".");
        buttonNumber[10].setBounds(130, 250, 50, 50);
        add(buttonNumber[10]);

        buttonNumber[0] = new JButton("0");
        buttonNumber[0].setBounds(10, 250, 50, 50);
        add(buttonNumber[0]);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                buttonNumber[x + y * 3 + 1] = new JButton((x + y * 3 + 1) + "");
                buttonNumber[x + y * 3 + 1].setBounds(x * (50 + 10) + 10, y * (50 + 10) + 70, 50, 50);
                add(buttonNumber[x + y * 3 + 1]);
            }
        }
        for (JButton button : buttonNumber) {
            button.addActionListener(this);
        }
        for (JButton button : buttonRomanNumber) {
            button.addActionListener(this);
        }
        output.setBounds(10, 10, 440, 50);
        output.setEditable(false);
        add(output);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : buttonNumber) {
            if (e.getSource() == button) {
                input += button.getText();
                output.setText(input);
            }
        }
        for (JButton button : buttonRomanNumber) {
            if (e.getSource() == button) {
                input += button.getText();
                output.setText(input);
            }
        }
        if (e.getSource() == delete) {
            input = "";
            output.setText(input);
        }
        if (e.getSource() == plusMinus) {
            Operations.plusMinus(input);

        }
        if (e.getSource() == plus) {
            Operations.plus(input);
            input = "";
        }
        if (e.getSource() == minus) {
            Operations.minus(input);
            input = "";
        }
        if (e.getSource() == multi) {
            Operations.multi(input);
            input = "";
        }
        if (e.getSource() == dev) {
            Operations.dev(input);
            input = "";
        }
        if (e.getSource() == remain) {
            Operations.remain(input);
            input = "";
        }

        if (e.getSource() == result) {
            Operations.result(input, operation,numberOne, romanOne);
            numberOne=null;
            romanOne=0;
            input="";
        }

    }

}
