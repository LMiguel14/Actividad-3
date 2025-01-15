import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase define la interfaz gráfica para calcular el área y el perímetro de un triángulo rectángulo.
 */
public class CalculadoraTrianguloRectangulo extends JFrame {
    private JTextField baseField;
    private JTextField alturaField;
    private JLabel areaLabel;
    private JLabel perimetroLabel;
    private JLabel hipotenusaLabel;
    private JLabel tipoLabel;

    /**
     * Constructor de la clase CalculadoraTrianguloRectangulo.
     * Configura la interfaz gráfica.
     */
    public CalculadoraTrianguloRectangulo() {
        setTitle("Calculadora de Triángulo Rectángulo");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Crear componentes
        JLabel baseLabel = new JLabel("Base del Triángulo:");
        baseField = new JTextField();
        JLabel alturaLabel = new JLabel("Altura del Triángulo:");
        alturaField = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        areaLabel = new JLabel("Área: ");
        perimetroLabel = new JLabel("Perímetro: ");
        hipotenusaLabel = new JLabel("Hipotenusa: ");
        tipoLabel = new JLabel("Tipo de Triángulo: ");

        // Añadir componentes al JFrame
        add(baseLabel);
        add(baseField);
        add(alturaLabel);
        add(alturaField);
        add(new JLabel()); // Espacio vacío
        add(calcularButton);
        add(areaLabel);
        add(perimetroLabel);
        add(hipotenusaLabel);
        add(tipoLabel);

        // Configurar el botón de cálculo
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
    }

    /**
     * Método que calcula el área, el perímetro y la hipotenusa del triángulo.
     * También determina el tipo de triángulo.
     */
    private void calcular() {
        try {
            int base = Integer.parseInt(baseField.getText());
            int altura = Integer.parseInt(alturaField.getText());
            TriánguloRectángulo triangulo = new TriánguloRectángulo(base, altura);

            double area = triangulo.calcularArea();
            double perimetro = triangulo.calcularPerímetro();
            double hipotenusa = triangulo.calcularHipotenusa();
            String tipo = triangulo.determinarTipoTriángulo();

            areaLabel.setText(String.format("Área: %.2f", area));
            perimetroLabel.setText(String.format("Perímetro: %.2f", perimetro));
            hipotenusaLabel.setText(String.format("Hipotenusa: %.2f", hipotenusa));
            tipoLabel.setText("Tipo de Triángulo: " + tipo);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos para la base y la altura", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraTrianguloRectangulo().setVisible(true);
            }
        });
    }
}


class TriánguloRectángulo {
    int base; // Atributo que define la base de un triángulo rectángulo
    int altura; // Atributo que define la altura de un triángulo rectángulo


    public TriánguloRectángulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }


    double calcularArea() {
        return (base * altura / 2);
    }


    double calcularPerímetro() {
        return (base + altura + calcularHipotenusa()); // Invoca al método calcular hipotenusa
    }


    double calcularHipotenusa() {
        return Math.sqrt(base * base + altura * altura);
    }

    String determinarTipoTriángulo() {
        if ((base == altura) && (base == calcularHipotenusa()) && (altura == calcularHipotenusa())) {
            return "Equilátero"; // Todos sus lados son iguales
        } else if ((base != altura) && (base != calcularHipotenusa()) && (altura != calcularHipotenusa())) {
            return "Escaleno"; // Todos sus lados son diferentes
        } else {
            return "Isósceles"; // De otra manera, es isósceles
        }
    }
}
