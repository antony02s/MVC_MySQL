/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto_5;

import controlador.CtrlCarreras;
import modelo.Carreras;
import modelo.Consultas_carreras;
import vista.jfr_carreras;

/**
 *
 * @author Antony Sanchez
 */
public class Reto_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carreras mod=new Carreras();
        Consultas_carreras modC=new Consultas_carreras();
        jfr_carreras frm=new jfr_carreras();
        
        CtrlCarreras ctrl=new CtrlCarreras(mod,modC,frm);
        ctrl.Iniciar();
        frm.setVisible(true);
        
    }
    
}
