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
    //private String operacion;

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
        areaTextoA = new JTextArea(10, 20);
        areaTextoA.setEditable(false);
        areaTextoA.setBackground(Color.white);

        // Creamos el área de texto de arriba donde se visualizan los resultados das operaciones
        areaTextoB = new JTextArea(3, 20);
        areaTextoB.setEditable(false);
        areaTextoB.setBackground(Color.white);

        // Establecemos layout del panel principal
        this.setLayout(new BorderLayout());

        // Colocamos la botonera y el área texto
        this.add(areaTextoA, BorderLayout.BEFORE_LINE_BEGINS);
        this.add(areaTextoB, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }
//          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 400, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 300, Short.MAX_VALUE)
//        );
    // </editor-fold>//GEN-END:initComponents
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        // Si es un botón
//        if (o instanceof JButton) {
//            JButton boton = (JButton) o;
//            String textoBoton = boton.getText();
//            areaTextoA.append(textoBoton);
        //} else 
        if (o.equals(this.botonera.grupoBotones[15])) {
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
//                    if (conjuntoNum.length == 2) {
                        try {
                            operacionAritmetica(tipoOperacion, Double.parseDouble(conjuntoNum[0]), Double.parseDouble(conjuntoNum[1]));
                        } catch (NumberFormatException e) {
                            throw new NumberFormatException("Solo se pueden realizar operaciones con números");
                        } catch (IndexOutOfBoundsException ea) {
                        
                        }
//                    } else {
//                        throw new IllegalArgumentException("Operación no válida");
//                    }
                         break;
                case "C":
                        areaTextoA.setText("");
                        areaTextoB.setText("");
                        tipoOperacion = -1;
                    break;                  
                default:
                    areaTextoA.setText(areaTextoA.getText()+operandos);
                    break;
            }
        }
    }
    // Método para realizar la operación aritmética
    private double operacionAritmetica(int tipoOperacion, double num1, double num2) {
        double resultado = 0;
        switch (tipoOperacion) {
            case 1:
                resultado = num1 + num2;
                areaTextoA.setText(Double.toString(resultado));
                areaTextoB.setText(num1 + " + " + num2 + " = ");
                break;
            case 2:
                resultado = num1 - num2;
                areaTextoA.setText(Double.toString(resultado));
                areaTextoB.setText(num1 + " - " + num2 + " = ");
                break;
            case 3:
                resultado = num1 * num2;
                areaTextoA.setText(Double.toString(resultado));
                areaTextoB.setText(num1 + " x " + num2 + " = ");
                break;
            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                    areaTextoA.setText(Double.toString(resultado));
                    areaTextoB.setText(num1 + " / " + num2 + " = ");
                } else {
                    throw new ArithmeticException("División por cero");
                }
                break;
            default:
                throw new IllegalArgumentException("Operación no soportada: " + tipoOperacion);
        }
        return resultado;
    }

}
