/**
* Programa: Programa 2 - PSP 1
* @author Juan Sebastian Paz Prieto 
* @date  20/02/2017 
* Clase: View
* Descripción: Esta clase Instancia la clase Controller y accede a sus metodos
**/


package edu.uniandes.ecos.CAIS.P2PSP1.view;

import edu.uniandes.ecos.CAIS.P2PSP1.controller.Controller;

/**
 * Hello world!
 *
 */
public class View{
    
    public static void main( String[] args ){
        Controller controller = new Controller();
        controller.startProgram();
        controller.showProgramSize();
        controller.showPartsSize();
    }
}