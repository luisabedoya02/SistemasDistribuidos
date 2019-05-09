/**
 * Title:        BeanMensajes
 * Description:  Bean para manejar los diferentes Mensajes
 * Copyright:    Copyright (c) 2007
 * @author       Vivian Orejuela, realizado a partir de una versi�n hecha por      
 * 		    Oscar caicedo, Diego Andr�s Acosta
 * @version 1.0
 */
package view;

import java.awt.Container;
import javax.swing.JOptionPane;

public class MessageBean implements java.io.Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Contenedor en el que se desplegar� el mensaje
     */
    private Container cPadre;

    /**
     * Representa el di�logo de error
     */
    private String titError ="Error";

    /**
     * Representa el di�logo de advertencia
     */
    private String titAdvertencia ="Cuidado";

    /**
     * Representa el di�logo de informaci�n con icono
     */
    private String titInformacion ="Informaci�n";

    

    /**
     * Representa el di�logo de texto plano sin icono
     */
    private String titTextoPlano ="Informaci�n";

    /**
     * Representa el di�logo de elecci�n Si, No, Cancelar
     */
    private String titSiNoCancelar="Seleccione una opci�n";

    /**
     * Representa el di�logo de elecci�n Si, No
     */
    private String titSiNo="Escoja una opci�n";

    /**
     * Representa el di�logo OK, Cancel
     */
    private String titOKCancel="Atenci�n";

    /** Creates new BeanMensajes */
    public MessageBean() {
    }

    /** Creates new BeanMensajes */
    public void setCFather(Container C) {
        cPadre=C;
    }

    /**
     * M�todo para desplegar un mensaje, sin �cono
     * @param mensaje, el mensaje a desplegar
     */
    public void message(String mensaje){
      mensaje="<html><font color=blue><b>"+mensaje+"</b></font></html>";
      JOptionPane.showMessageDialog(cPadre,mensaje);
      return;
    }

    /**
     * M�todo para desplegar un mensaje de error, con icono
     * @param mensaje, el mensaje a desplegar
     */
    public void error(String mensaje){
      mensaje="<html><font color=red><b>"+mensaje+"</b></font></html>";
      JOptionPane.showMessageDialog(cPadre,mensaje,titError,JOptionPane.ERROR_MESSAGE);
      return;
    }

    /**
     * Metodo para desplegar un mensaje de avertencia, con �cono
     * @param mensaje, el mensaje a desplegar.
     */
    public void warning(String mensaje){
      mensaje="<html><font color=red><b>"+mensaje+"</b></font></html>";
      JOptionPane.showMessageDialog(cPadre,mensaje,titAdvertencia,JOptionPane.WARNING_MESSAGE);
      return;
    }

    /**
     * M�todo para desplegar un mensaje de informaci�n
     * @param mensaje, el mensaje a desplegar
     */
    public void information(String mensaje){
      mensaje="<html><font color=blue><b>"+mensaje+"</b></font></html>";
      JOptionPane.showMessageDialog(cPadre,mensaje,titInformacion,JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    /**
     * M�tod para desplegar un mensaje plano
     * @param mensaje, el mensaje a desplegar
     */
    public void text(String mensaje){
      mensaje="<html><font color=blue><b>"+mensaje+"</b></font></html>";
      JOptionPane.showMessageDialog(cPadre,mensaje,titTextoPlano,JOptionPane.PLAIN_MESSAGE);
      return;
    }

    /**
     * M�todo para desplegar un mensaje con las opciones Si,No,Cancelar
     * @param mensaje, el mensaje a desplegar
     * @return la opci�n escogida Si=0, No=1, Cancelar=2
     */
    public int IfNoCancel(String mensaje){
      Object[] options = {"Si","No","Cancelar"};
      mensaje="<html><font color=green><b>"+mensaje+"</b></font></html>";
      int n = JOptionPane.showOptionDialog(cPadre,mensaje,titSiNoCancelar,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
      return n;
    }

    /**
     * M�todo para desplegar un mensaje con las opciones Si, No
     * @param mensaje, el mensaje a desplegar
     * @return n, la opci�n escogida. Si=0, No=1
     */
    public int IfNo(String mensaje){
      Object[] options = {"Si","No"};
      mensaje="<html><font color=green><b>"+mensaje+"</b></font></html>";
      int n = JOptionPane.showOptionDialog(cPadre,mensaje,titSiNo,JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,options,options[1]);
      return n;
    }

    /**
     * M�todo para desplegar un mensaje con opciones Aceptar, Cancelar
     * @param mensaje, el mensaje a desplegar
     * @return la opci�n escogida Aceptar=0, Cancelar=1;
     */
    public int AceptCancel(String mensaje){
      Object[] options = {"Aceptar","Cancelar"};
      mensaje="<html><font color=green><b>"+mensaje+"</b></font></html>";
      int n = JOptionPane.showOptionDialog(cPadre,mensaje,titOKCancel,JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,options,options[1]);
      return n;
    }
}
