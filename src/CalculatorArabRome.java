import javax.swing.*;

public class CalculatorArabRome {
    private JFrame window;
public CalculatorArabRome(){
    window = new JFrame("Calculator");
    window.setSize(470,350);
    window.add(new Panel());
    window.setLocationRelativeTo(null);
    window.setResizable(false);
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setVisible(true);


}

    public static void main(String[] args) {

           SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorArabRome();
            }
        });
    }
}
