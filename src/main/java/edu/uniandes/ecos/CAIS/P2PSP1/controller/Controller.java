/**
* Programa: Programa 2 - PSP 1
* @author Juan Sebastian Paz Prieto 
* @date  20/02/2017 
* Clase: Controller
* Descripción: Esta clase Instancia la clase Program y accede a sus metodos,
* para mostrar los resultados de conteo del programa.
**/
package edu.uniandes.ecos.CAIS.P2PSP1.controller;

import edu.uniandes.ecos.CAIS.P2PSP1.model.Program;
import edu.uniandes.ecos.CAIS.P2PSP1.model.Part;
import java.util.Iterator;
import java.util.LinkedList;

public class Controller {

    private Program program;

    /**
     * Método que obtiene el path del programa e crea un objeto de tipo Program
     */
    public void startProgram() {
        String path = System.getProperty("user.dir");
        path += "/src/main/java";
        this.program = new Program(path);

    }

    /**
     * Método que muestra el tamaño del programa
     */
    public void showProgramSize() {
        System.out.println("Program");
        System.out.println("Total Program Size: "+this.program.getSize());
    }

    /**
     * Método que obtiene las partes del programa y las recorre para mostrar
     * Nombre, número de items y tamaño de cada una de las partes
     */
    public void showPartsSize() {
        System.out.println("Parts");
        LinkedList parts = this.program.getParts();

        Iterator it = parts.iterator();
        while (it.hasNext()) {
            Part part = (Part) it.next();
            System.out.println("Name: " + part.getName());
            System.out.println("Number of Items: " + part.getItemsNumber());
            System.out.println("Part Size: " + part.getSize());
        }

    }
   
}
