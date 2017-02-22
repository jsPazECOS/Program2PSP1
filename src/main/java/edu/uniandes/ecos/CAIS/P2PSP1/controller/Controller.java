/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.CAIS.P2PSP1.controller;

import edu.uniandes.ecos.CAIS.P2PSP1.model.Program;

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
        System.out.println(this.program.getSize());
    }
}
