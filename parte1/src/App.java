import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private JTextField codigoField, nombresField, horasField, valorHoraField, retencionField;
    private JLabel salarioBrutoLabel, salarioNetoLabel;

    public App() {

        setTitle("Parte 1");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        // Crear panel para el formulario de salario
        JPanel salarioPanel = new JPanel(new GridLayout(8, 2));
        salarioPanel.setLayout(null);
        
        JLabel codigoLabel =  (new JLabel("Código del empleado:"));        
        codigoField = new JTextField();
        codigoField.setBounds(180,10,150,25);
        salarioPanel.add(codigoField);

        JLabel nombreslJLabel =  (new JLabel("Nombres:"));
        nombresField = new JTextField();
        nombresField.setBounds(180,50,150,25);
        salarioPanel.add(nombresField);


        JLabel  horaMesJLabel =  (new JLabel("Horas trabajadas al mes:"));
        horasField = new JTextField();
        horasField.setBounds(180,100,150,25);
        salarioPanel.add(horasField);


        JLabel valorHorLabel=  (new JLabel("Valor por hora:"));
        valorHoraField = new JTextField();
        valorHoraField.setBounds(180,150,150,25);
        salarioPanel.add(valorHoraField);


        JLabel retencioJLabel =  (new JLabel("Retención en la fuente (%):"));
        retencionField = new JTextField();
        retencionField.setBounds(180,200,150,25);
        salarioPanel.add(retencionField);


        JButton calcularButton = new JButton("Calcular");
        
        calcularButton.setBounds(285, 285, 80, 40);
        codigoLabel.setBounds(10,10,200,25);
        nombreslJLabel.setBounds(10,50,200,25);
        horaMesJLabel.setBounds(10,100,200,25);
        valorHorLabel.setBounds(10,150,200,25);
        retencioJLabel.setBounds(10,200,200,25);


        salarioPanel.add(calcularButton);
        salarioPanel.add(codigoLabel);
        salarioPanel.add(nombreslJLabel);
        salarioPanel.add(horaMesJLabel);
        salarioPanel.add(valorHorLabel);
        salarioPanel.add(retencioJLabel);   

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSalarios();
            }
        });
        
        salarioBrutoLabel = new JLabel("$   ");
        salarioNetoLabel = new JLabel( "$   ");


        JLabel text1 = new JLabel("Salario Bruto:   ");
        JLabel text2 = new JLabel("Salario Neto:  ");

        text1.setBounds(80, 270, 100, 10);
        text2.setBounds(80, 300, 100, 10);

        salarioNetoLabel.setBounds(170, 270, 80, 10);
        salarioBrutoLabel.setBounds(170, 300, 80, 10);

        
        salarioPanel.add(salarioBrutoLabel);
        salarioPanel.add(salarioNetoLabel);

        salarioPanel.add(text2);
        salarioPanel.add(text1);

        tabbedPane.addTab("Ejercio 18", salarioPanel);


        // Problema del tirangulo


        JPanel panel = new JPanel(new GridLayout(8, 2));
     
            
        panel.setLayout(null);
        add(panel);    
    
        JButton boton = new JButton("Calcular área, perimetro y altura");
        JLabel appJLabel = new JLabel("Medida lado del triángulo ");
        JTextField textField = new JTextField();
    
    
        JLabel areaLabel = new JLabel();
        JLabel perimetroLabel = new JLabel();
        JLabel alturaLabel = new JLabel();
    
    
        appJLabel.setBounds(120, 10, 200, 40);
        textField.setBounds(150, 70, 80, 30);
        boton.setBounds(70, 150, 250, 40);
    
    
        areaLabel.setBounds(50, 220, 150, 40);
        perimetroLabel.setBounds(50, 270, 150, 40);
        alturaLabel.setBounds(50, 320, 150, 40);
    
    
    
        panel.add(areaLabel);
        panel.add(perimetroLabel);
        panel.add(alturaLabel);
    
        panel.add(textField);
        panel.add(appJLabel);
        panel.add(boton);
    

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la acción del segundo formulario
                
                    String textoLado = textField.getText().trim(); // Eliminar espacios en blanco
                
                    if (textoLado.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor para el lado", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                
                    try {
                        double lado = Double.parseDouble(textoLado);
                        double perimetro = 3 * lado;
                        double altura = (Math.sqrt(3) / 2) * lado;
                        double area = (Math.sqrt(3) / 4) * lado * lado;
                
                        perimetroLabel.setText(String.format("Perímetro: %.2f", perimetro));
                        alturaLabel.setText(String.format("Altura: %.2f", altura));
                        areaLabel.setText(String.format("Área: %.2f", area));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                
                    }
        });

        tabbedPane.addTab("Ejercicio 19", panel);

        add(tabbedPane, BorderLayout.CENTER);

        // COMPARAR DOS NUMEROS

        JPanel panel3 = new JPanel(new GridLayout(8, 2));
        panel3.setLayout(null);
        add(panel3);   


        JLabel etiquetaA = new JLabel("Valor de A:");
        JTextField valorA = new JTextField();
        JLabel etiquetaB = new JLabel("Valor de B:");
        JTextField valorB = new JTextField();
        JButton compararButton = new JButton("Comparar");
        JLabel resultadoLabel = new JLabel("Resultado ");


        // disposicion 

        etiquetaA.setBounds(50, 20,100, 100);
        etiquetaB.setBounds(250, 20,100, 100);

        valorA.setBounds(60, 100,40, 25);
        valorB.setBounds(260, 100,40, 25);

        compararButton.setBounds(140, 200, 100, 25);


        resultadoLabel.setBounds(160, 270, 160, 30);
        //agregar

        panel3.add(compararButton);
        panel3.add(etiquetaA);        
        panel3.add(etiquetaB);
        panel3.add(valorA);
        panel3.add(valorB);
        panel3.add(resultadoLabel);

        compararButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la acción del segundo formulario
                try {
                    int A = Integer.parseInt(valorA.getText());
                    int B = Integer.parseInt(valorB.getText());
        
                    if (A > B) {
                        resultadoLabel.setText("A ES MAYOR QUE B");
                    } else if (A == B) {
                        resultadoLabel.setText("A ES IGUAL A B");
                    } else {
                        resultadoLabel.setText("A ES MENOR QUE B");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese números válidos", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                    }
        });


        tabbedPane.addTab("Ejercicio 7", panel3);
        add(tabbedPane, BorderLayout.CENTER);

        //////////////////////////////////////        

        
        JPanel panel4 = new JPanel(new GridLayout(8, 2));
        panel4.setLayout(null);
        add(panel4);   


        JLabel niLabel = new JLabel("Número de Inscripción:");
        JTextField niField = new JTextField();
        JLabel nomLabel = new JLabel("Nombre:");
        JTextField nomField = new JTextField();
        JLabel patLabel = new JLabel("Patrimonio:");
        JTextField patField = new JTextField();
        JLabel esLabel = new JLabel("Estrato Social:");
        JTextField esField = new JTextField();
        JButton botton4 = new JButton("Calcular");

        JTextArea resultadoLabel4 = new JTextArea();

        // disposicion 


        niLabel.setBounds(10,10,200,25);
        niField.setBounds(180,10,150,25);

        nomLabel.setBounds(10,50,200,25);
        nomField.setBounds(180,50,150,25);


        patLabel.setBounds(10,100,200,25);
        patField.setBounds(180,100,150,25);

        esLabel.setBounds(10,150,200,25);
        esField.setBounds(180,150,150,25);

        botton4.setBounds(100,200,200,25);
        resultadoLabel4.setBounds(10,250,500,50);

        resultadoLabel4.setBackground( new Color(238,238,238));
        System.out.println(panel4.getBackground());

        panel4.add(niLabel);
        panel4.add(niField);        
        panel4.add(nomLabel);
        panel4.add(nomField);
        panel4.add(patLabel);
        panel4.add(patField);
        panel4.add(esLabel);
        panel4.add(esField);
        panel4.add(botton4);
        panel4.add(resultadoLabel4);

        botton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la acción del segundo formulario
                try { 
                    String ni = niField.getText();
                    String nom = nomField.getText(); 
                    double pat = Double.parseDouble(patField.getText()); 
                    int es = Integer.parseInt(esField.getText());
                    double pagmat = 50000; 
                    if (pat > 2000000 && es > 3)
                        { pagmat += 0.03 * pat; } 
                        resultadoLabel4.setText(String.format("EL ESTUDIANTE CON NUMERO DE INSCRIPCION  "+ ni + "\nNOMBRE -  "+ nom + "\nDEBE PAGAR: $  " +  pagmat  ));
                    }   catch (NumberFormatException ex){
                         JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para patrimonio y estrato social", "Error", JOptionPane.ERROR_MESSAGE); 
                        }

                    }}
            );

        tabbedPane.addTab("Ejercicio 10", panel4);
        add(tabbedPane, BorderLayout.CENTER);



        //___________________


                        
        JPanel panel5 = new JPanel(new GridLayout(8, 2));
        add(panel5);   



        JTextField nombreField;
        JTextField salarioHoraField;
        JTextField horasTrabajadasField;
        JTextArea salidaLabel;
        
        salidaLabel = new JTextArea();
        JLabel nombreLabel = new JLabel("Nombre del Empleado:");
        nombreField = new JTextField();
        JLabel salarioHoraLabel = new JLabel("Salario Básico por Hora:");
        salarioHoraField = new JTextField();
        JLabel horasTrabajadasLabel = new JLabel("Horas Trabajadas en el Mes:");
        horasTrabajadasField = new JTextField();
        JButton boton5 = new JButton("Calcular");

        salidaLabel.setBounds(1, 300, 100, 100);
        salidaLabel.setBackground(new Color(238,238,238));

        // Añadir componentes al JFrame
        panel5.add(nombreLabel);
        panel5.add(nombreField);
        panel5.add(salarioHoraLabel);
        panel5.add(salarioHoraField);
        panel5.add(horasTrabajadasLabel);
        panel5.add(horasTrabajadasField);
        panel5.add(new JLabel()); // Espacio vacío
        panel5.add(boton5);
        panel5.add(salidaLabel);


        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la acción del segundo formulario
                try {
                    String nombre = nombreField.getText();
                    double salarioHora = Double.parseDouble(salarioHoraField.getText());
                    int horasTrabajadas = Integer.parseInt(horasTrabajadasField.getText());
        
                    double salarioMensual = salarioHora * horasTrabajadas;
        
                    if (salarioMensual > 450000) {
                        salidaLabel.setText(String.format("Nombre: %s  \nSalario Mensual: $%.2f", nombre, salarioMensual));
                    } else {
                        salidaLabel.setText(String.format("Nombre: %s", nombre));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para el salario y las horas trabajadas", "Error", JOptionPane.ERROR_MESSAGE);
                }

                    }}
            );


            tabbedPane.addTab("Ejercicio 22", panel5);
            add(tabbedPane, BorderLayout.CENTER);
    

            ///////////

            JPanel panel6= new JPanel(new GridLayout(8, 2));
            add(panel6);  

             JTextField aField;
             JTextField bField;
             JTextField cField;
             JLabel solucion;

             
             JLabel aLabel = new JLabel("Valor de A:");
             aField = new JTextField();
             JLabel bLabel = new JLabel("Valor de B:");
             bField = new JTextField();
             JLabel cLabel = new JLabel("Valor de C:");
             cField = new JTextField();
             JButton boton6 = new JButton("Calcular");
             solucion = new JLabel("Resultado: ");



             // agregarlo al panel 

             panel6.add(aLabel);
             panel6.add(aField);
             panel6.add(bLabel);
             panel6.add(bField);
             panel6.add(cLabel);
             panel6.add(cField);
             panel6.add(new JLabel()); // Espacio vacío
             panel6.add(boton6);
             panel6.add(solucion);

             boton6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica para la acción del segundo formulario
                    try {
                        double A = Double.parseDouble(aField.getText());
                        double B = Double.parseDouble(bField.getText());
                        double C = Double.parseDouble(cField.getText());
            
                        double discriminante = B * B - 4 * A * C;
            
                        if (discriminante > 0) {
                            double x1 = (-B + Math.sqrt(discriminante)) / (2 * A);
                            double x2 = (-B - Math.sqrt(discriminante)) / (2 * A);
                            solucion.setText(String.format("<html>Soluciones: <br>x1 = %.2f<br>x2 = %.2f</html>", x1, x2));
                        } else if (discriminante == 0) {
                            double x = -B / (2 * A);
                            resultadoLabel.setText(String.format("Solución única: x = %.2f", x));
                        } else {
                            resultadoLabel.setText("No hay soluciones reales.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para A, B y C", "Error", JOptionPane.ERROR_MESSAGE);
                    }
    
                        }
                    

                        
                    }
                );
            
             tabbedPane.addTab("Ejercicio 23", panel6);
             add(tabbedPane, BorderLayout.CENTER);
    
        setVisible(true);
    }

    private void calcularSalarios() {

            try {
                String codigo = codigoField.getText();
                String nombres = nombresField.getText();
        
                // Asegúrate de verificar que los campos no estén vacíos antes de convertir
                if (codigo.isEmpty() || nombres.isEmpty() || horasField.getText().isEmpty() || 
                    valorHoraField.getText().isEmpty() || retencionField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                int horasTrabajadas = Integer.parseInt(horasField.getText());
                double valorHora = Double.parseDouble(valorHoraField.getText());
                double retencion = Double.parseDouble(retencionField.getText()) / 100;
        
                double salarioBruto = horasTrabajadas * valorHora;
                double salarioNeto = salarioBruto * (1 - retencion);
        
                salarioBrutoLabel.setText(String.format("%.2f", salarioBruto));
                salarioNetoLabel.setText(String.format("%.2f", salarioNeto));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos para horas trabajadas, valor por hora y retención", "Error", JOptionPane.ERROR_MESSAGE);
            }     
    }


    public static void main(String[] args) {
        new App();
    }
}
