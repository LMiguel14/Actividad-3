import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase define la interfaz gráfica para calcular el área y el perímetro de un cuadrado.
 */
public class CalculadoraCuadradoGUI extends JFrame {
    private JTextField ladoField;
    private JLabel areaLabel;
    private JLabel perimetroLabel;

    /**
     * Constructor de la clase CalculadoraCuadradoGUI.
     * Configura la interfaz gráfica.
     */
    public CalculadoraCuadradoGUI() {
        setTitle("Calculadora de Cuadrado");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Crear componentes
        JLabel ladoLabel = new JLabel("Lado del Cuadrado:");
        ladoField = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        areaLabel = new JLabel("Área: ");
        perimetroLabel = new JLabel("Perímetro: ");

        // Añadir componentes al JFrame
        add(ladoLabel);
        add(ladoField);
        add(new JLabel()); // Espacio vacío
        add(calcularButton);
        add(areaLabel);
        add(perimetroLabel);

        // Configurar el botón de cálculo
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
    }

    /**
     * Método que calcula el área y el perímetro del cuadrado.
     */
    private void calcular() {
        try {
            int lado = Integer.parseInt(ladoField.getText());
            Cuadrado cuadrado = new Cuadrado(lado);

            double area = cuadrado.calcularArea();
            double perimetro = cuadrado.calcularPerímetro();

            areaLabel.setText(String.format("Área: %.2f", area));
            perimetroLabel.setText(String.format("Perímetro: %.2f", perimetro));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico válido para el lado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraCuadradoGUI().setVisible(true);
            }
        });
    }
}

/**
 * Esta clase define objetos de tipo Cuadrado con un lado como atributo.
 * @version 1.2/2020
 */
class Cuadrado {
    int lado; // Atributo que define el lado de un cuadrado

    /**
     * Constructor de la clase Cuadrado
     * @param lado Parámetro que define la longitud de la base de un cuadrado
     */
    public Cuadrado(int lado) {
        this.lado = lado;
    }

    /**
     * Método que calcula y devuelve el área de un cuadrado como el lado elevado al cuadrado
     * @return Área de un Cuadrado
     */
    double calcularArea() {
        return lado * lado;
    }

    /**
     * Método que calcula y devuelve el perímetro de un cuadrado como cuatro veces su lado
     * @return Perímetro de un cuadrado
     */
    double calcularPerímetro() {
        return 4 * lado;
    }
}
