
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import modelo.Carreras;
import modelo.Consultas_carreras;
import vista.jfr_carreras;

public class CtrlCarreras implements ActionListener{
    
    private Carreras mod;
    private Consultas_carreras modC;
    private jfr_carreras frm;
    
    public CtrlCarreras(Carreras mod,Consultas_carreras modC, jfr_carreras frm){
        this.mod=mod;
        this.modC=modC;
        this.frm=frm;
        this.frm.btn_guardar.addActionListener(this);
        this.frm.btn_modificar.addActionListener(this);
        this.frm.btn_eliminar.addActionListener(this);
        this.frm.btn_limpiar.addActionListener(this);
        this.frm.txt_buscar.addActionListener(this);
    }
    
    public void Iniciar(){
        frm.setTitle("Carreras");
        frm.setLocationRelativeTo(null);
    }
    
    //@override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==frm.btn_guardar){
            mod.setId_carrera(Integer.parseInt(frm.txt_id_carrera.getText()));
            mod.setNombre(frm.txt_nombre.getText());
            mod.setCapacidad_asistentes(Double.parseDouble(frm.txt_capacidad_asistentes.getText()));
            mod.setNivel_dificultad(Double.parseDouble(frm.txt_nivel_dificultad.getText()));
            mod.setBajo_techo(Boolean.parseBoolean(frm.txt_bajo_techo.getText()));
            
            if(modC.Registrar(mod)){
                JOptionPane.showMessageDialog(null,"Registro Guardado");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al guardar");
                Limpiar();
            }
        }
        if(e.getSource()==frm.btn_modificar){
            mod.setId_carrera(Integer.parseInt(frm.txt_id_carrera.getText()));
            mod.setNombre(frm.txt_nombre.getText());
            mod.setCapacidad_asistentes(Double.parseDouble(frm.txt_capacidad_asistentes.getText()));
            mod.setNivel_dificultad(Double.parseDouble(frm.txt_nivel_dificultad.getText()));
            mod.setBajo_techo(Boolean.parseBoolean(frm.txt_bajo_techo.getText()));
            
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null,"Registro Modificado");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al modificar");
                Limpiar();
            }
        }
        if(e.getSource()==frm.btn_eliminar){
            mod.setId_carrera(Integer.parseInt(frm.txt_id_carrera.getText()));
            
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null,"Registro Eliminado");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al eliminar");
                Limpiar();
            }
        }
        if(e.getSource()==frm.txt_buscar){
            mod.setId_carrera(Integer.parseInt(frm.txt_id_carrera.getText()));
            
            if(modC.buscar(mod)){
                frm.txt_id_carrera.setText(String.valueOf(mod.getId_carrera()));
                frm.txt_nombre.setText(mod.getNombre());
                frm.txt_capacidad_asistentes.setText(String.valueOf(mod.getCapacidad_asistentes()));
                frm.txt_nivel_dificultad.setText(String.valueOf(mod.getNivel_dificultad()));
                frm.txt_bajo_techo.setText(String.valueOf(mod.isBajo_techo()));
            }else{
                JOptionPane.showMessageDialog(null,"No se encontro el resultado");
                Limpiar();
            }
        }
        if(e.getSource()==frm.btn_limpiar){
            Limpiar();
        }

    }
    public void Limpiar(){
        frm.txt_id_carrera.setText(null);
        frm.txt_nombre.setText(null);
        frm.txt_capacidad_asistentes.setText(null);
        frm.txt_nivel_dificultad.setText(null);
        frm.txt_bajo_techo.setText(null);
    }
}
