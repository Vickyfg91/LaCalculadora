/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAW;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author vickyfg
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTextoA;
    private JTextArea areaTextoB;
    private int tipoOperacion;
    private String operacion;

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto de arriba donde se visualizan las operacions
        areaTextoA = new JTextArea(7, 18);
        areaTextoA.setEditable(false);
        areaTextoA.setBackground(Color.white);

        // Creamos el área de texto de arriba donde se visualizan los resultados das operaciones
        areaTextoB = new JTextArea(3, 18);
        areaTextoB.setEditable(false);
        areaTextoB.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());

        // Colocamos la botonera y el área texto
        this.add(areaTextoA, BorderLayout.NORTH);
        this.add(areaTextoB, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        // Si es un botón

        if (o instanceof JButton) {
            System.out.println(((JButton) o).getText());
            areaTextoA.setText(((JButton) o).getText());
        } else if (o.equals(this.botonera.grupoBotones[15])) {
            areaTextoA.setText("");
            areaTextoB.setText("");
        } else if (o instanceof JButton botones) {
            String operandos = botones.getText();

            //Switch para los case de los operandos
            switch (operandos) {
                case "+":
                    tipoOperacion = 1;
                    areaTextoA.setText(areaTextoA.getText() + "+");
                    break;
                case "-":
                     tipoOperacion = 2;
                    areaTextoA.setText(areaTextoA.getText() + "-");
                    break;
                case "*":
                     tipoOperacion = 3;
                    areaTextoA.setText(areaTextoA.getText() + "*");
                    break;
                case "/":
                   tipoOperacion = 4;
                    areaTextoA.setText(areaTextoA.getText() + "/");
                    break;
                case "=":
                    String[] conjuntoNum = areaTextoA.getText().split("\\+|\\-|\\*|\\/");
//                    try {
//                        resultado(tipoOperacion, Double.parseDouble(conjuntoNum[0]), Double.parseDouble(conjuntoNum[1]));
//                    
//                    } catch {
//                        throw new ArithmeticException("División por cero");
//                    }
//                default:
//                    throw new IllegalArgumentException("Operación no soportada: " + operacion);
            }
        }
    }
    // Método para realizar la operacion aritmetica

    
    }
