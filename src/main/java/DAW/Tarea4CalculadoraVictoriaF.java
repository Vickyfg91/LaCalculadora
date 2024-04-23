/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package DAW;

import javax.swing.JFrame;

/**
 *
 * @author vickyfg
 */
public class Tarea4CalculadoraVictoriaF {

    public static void main(String[] args) {
        //Con
        JFrame frame = new JFrame("Calculadora");
        
        frame.setBounds(250, 250, 0, 0);
        // Incluimos el panel en la ventana
    	frame.add(new PanelPrincipal());
        // Se le da visivilidad a la ventana
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Ajusta el frame al contenido
    	frame.pack();
        
    }
}
