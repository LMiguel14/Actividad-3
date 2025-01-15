import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase define la interfaz gráfica para calcular el área y el perímetro de un rectángulo.
 */
public class CalculadoraRectangulo extends JFrame {
    private JTextField baseField;
    private JTextField alturaField;
    private JLabel areaLabel;
    private JLabel perimetroLabel;

    /**
     * Constructor de la clase CalculadoraRectangulo.
     * Configura la interfaz gráfica.
     */
    public CalculadoraRectangulo() {
        setTitle("Calculadora de Rectángulo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Crear componentes
        JLabel baseLabel = new JLabel("Base del Rectángulo:");
        baseField = new JTextField();
        JLabel alturaLabel = new JLabel("Altura del Rectángulo:");
        alturaField = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        areaLabel = new JLabel("Área: ");
        perimetroLabel = new JLabel("Perímetro: ");

        // Añadir componentes al JFrame
        add(baseLabel);
        add(baseField);
        add(alturaLabel);
        add(alturaField);
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
     * Método que calcula el área y el perímetro del rectángulo.
     */
    private void calcular() {
        try {
            int base = Integer.parseInt(baseField.getText());
            int altura = Integer.parseInt(alturaField.getText());
            Rectángulo rectangulo = new Rectángulo(base, altura);

            double area = rectangulo.calcularArea();
            double perimetro = rectangulo.calcularPerímetro();

            areaLabel.setText(String.format("Área: %.2f", area));
            perimetroLabel.setText(String.format("Perímetro: %.2f", perimetro));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos para la base y la altura", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraRectangulo().setVisible(true);
            }
        });
    }
}


class Rectángulo {
    int base; // Atributo que define la base de un rectángulo
    int altura; // Atributo que define la altura de un rectángulo


    Rectángulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }


    double calcularArea() {
        return base * altura;
    }

  
    double calcularPerímetro() {
        return (2 * base) + (2 * altura);
    }
}
