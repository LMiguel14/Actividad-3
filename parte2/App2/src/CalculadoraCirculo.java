import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase define la interfaz gráfica para calcular el área y el perímetro de un círculo.
 */
public class CalculadoraCirculo extends JFrame {
    private JTextField radioField;
    private JLabel areaLabel;
    private JLabel perimetroLabel;

    /**
     * Constructor de la clase CalculadoraCirculoGUI.
     * Configura la interfaz gráfica.
     */
    public CalculadoraCirculo() {
        setTitle("Calculadora de Círculo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Crear componentes
        JLabel radioLabel = new JLabel("Radio del Círculo:");
        radioField = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        areaLabel = new JLabel("Área: ");
        perimetroLabel = new JLabel("Perímetro: ");

        // Añadir componentes al JFrame
        add(radioLabel);
        add(radioField);
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
     * Método que calcula el área y el perímetro del círculo.
     */
    private void calcular() {
        try {
            int radio = Integer.parseInt(radioField.getText());
            Círculo circulo = new Círculo(radio);

            double area = circulo.calcularArea();
            double perimetro = circulo.calcularPerímetro();

            areaLabel.setText(String.format("Área: %.2f", area));
            perimetroLabel.setText(String.format("Perímetro: %.2f", perimetro));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico válido para el radio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraCirculo().setVisible(true);
            }
        });
    }
}


class Círculo {
    int radio; // Atributo que define el radio de un círculo

    Círculo(int radio) {
        this.radio = radio;
    }

    double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

   
    double calcularPerímetro() {
        return 2 * Math.PI * radio;
    }
}
