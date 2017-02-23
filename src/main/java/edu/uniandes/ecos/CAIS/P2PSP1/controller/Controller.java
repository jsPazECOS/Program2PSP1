/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.CAIS.P2PSP1.controller;

import edu.uniandes.ecos.CAIS.P2PSP1.model.Program;
import edu.uniandes.ecos.CAIS.P2PSP1.model.Part;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Juan Paz
 */
public class Controller {

    private Program program;

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public void startProgram() {
        String path = System.getProperty("user.dir");
        path += "/src/main/java";
        this.program = new Program(path);

    }

    public void showProgramSize() {
        System.out.println("Program");
        System.out.println("Total Program Size: "+this.program.getSize());
    }

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
