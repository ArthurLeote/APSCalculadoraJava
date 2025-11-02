
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame implements ActionListener {

    private JTextField visor;
    private JPanel painelDeBotoes; 

    private double num1 = 0;
    private double num2 = 0;
    private double resultado = 0;
    private String operador = ""; 
    
    private boolean limpandoVisor = true; 

    public CalculadoraGUI() {
        setTitle("Calculadora Java");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        visor = new JTextField();
        visor.setEditable(false);
        visor.setFont(new Font("Arial", Font.PLAIN, 40));
        visor.setHorizontalAlignment(JTextField.RIGHT); 
        add(visor, BorderLayout.NORTH); 

        
        painelDeBotoes = new JPanel();
        painelDeBotoes.setLayout(new GridLayout(6, 4, 5, 5));
        add(painelDeBotoes, BorderLayout.CENTER);

        String[] botoes = {
            "C", "x√y", "∛", "√",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String textoDoBotao : botoes) {
            JButton botao = new JButton(textoDoBotao);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            botao.addActionListener(this); 
            painelDeBotoes.add(botao);
        }

        setVisible(true);
    }

 

    public static double somar(double a, double b) { return a + b; }
    public static double subtrair(double a, double b) { return a - b; }
    public static double multiplicar(double a, double b) { return a * b; }
    public static double dividir(double a, double b) {
        if (b == 0) { return Double.NaN; }
        return a / b;
    }
    public static double calcularRaizQuadrada(double base) { return Math.sqrt(base); }
    public static double calcularRaizCubica(double base) { return Math.cbrt(base); }
    public static double calcularRaizEnesima(double base, int indice) {
        return Math.pow(base, 1.0 / indice);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand(); 

        try {

            if (comando.matches("[0-9]") || comando.equals(".")) {
                if (limpandoVisor) {
                    visor.setText("");
                    limpandoVisor = false;
                }
                visor.setText(visor.getText() + comando);
            
            } else if (comando.equals("C")) {
                visor.setText("");
                num1 = 0;
                num2 = 0;
                operador = "";
                limpandoVisor = true;


            } else if (comando.equals("√") || comando.equals("∛")) {
                num1 = Double.parseDouble(visor.getText());
                
                if (comando.equals("√")) {
                    resultado = calcularRaizQuadrada(num1);
                } else { // "∛"
                    resultado = calcularRaizCubica(num1);
                }
                
                visor.setText(String.valueOf(resultado));
                limpandoVisor = true;

            } else if (comando.equals("+") || comando.equals("-") || comando.equals("*") || comando.equals("/") || comando.equals("x√y")) {
                num1 = Double.parseDouble(visor.getText()); 
                operador = comando;
                limpandoVisor = true;

         
            } else if (comando.equals("=")) {
                num2 = Double.parseDouble(visor.getText()); 

                switch (operador) {
                    case "+":
                        resultado = somar(num1, num2);
                        break;
                    case "-":
                        resultado = subtrair(num1, num2);
                        break;
                    case "*":
                        resultado = multiplicar(num1, num2);
                        break;
                    case "/":
                        resultado = dividir(num1, num2);
                        break;
                    case "x√y": 
                        int indice = (int) num2; 
                        resultado = calcularRaizEnesima(num1, indice);
                        break;
                }

                if (Double.isNaN(resultado)) {
                    visor.setText("Erro: Div por 0");
                } else {
                    visor.setText(String.valueOf(resultado));
                }
                
                limpandoVisor = true;
                operador = "";
            }

        } catch (NumberFormatException ex) {
            visor.setText("Erro");
            limpandoVisor = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraGUI(); 
            }
        });
    }
}