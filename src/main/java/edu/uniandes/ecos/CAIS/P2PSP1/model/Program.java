/**
* Programa: Programa 2 - PSP 1
* @author Juan Sebastian Paz Prieto 
* @date  20/02/2017 
* Clase: Program
* Descripción: Clase que analiza recursivamente la estructura del proyecto
* para obtener sus clases, e instanciar objetos de tipo Part.
**/
package edu.uniandes.ecos.CAIS.P2PSP1.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Juan Paz
 */
public class Program {

    private int size;

    private LinkedList<Part> parts;

    private String srcPath;

    /**
     * Método que permite acceder al tamaño del programa
     * @return un valor <code>int</code> que representa el tamaño del programa
     */
    public int getSize() {
        return size;
    }

    /**
     * Método que permite establecer un valor para el tamaño del programa
     * @param size
     */
    public void setSize(int size) {
        this.size += size;
    }
    
    /**
     * Método que permite acceder a una lista de las partes del programa
     * @return un valor <code>LinkedList</code> que representa las partes del programa
     */
    public LinkedList<Part> getParts() {
        return parts;
    }

    /**
     * Método constructor de Program
     * @param srcPath ruta de la estructura del proyecto.
     */
    public Program(String srcPath) {
        this.srcPath = srcPath;
        this.parts = new LinkedList<Part>();
        this.size = 0;
        this.readProgramStructure(this.srcPath);
    }

    /**
     * Método recursivo que permite leer la estructura del programa, para saber
     * cuales son las partes de este.
     * @param path
     */
    public void readProgramStructure(String path) {

        File[] files = new File(path).listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                readProgramStructure(file.getPath());
            } else {
                Part part = new Part();
                part.setName(file.getName());
                part.setContent(this.getContentPart(file.getPath()));
                part.readPart();
                this.setSize(part.getSize());
                this.parts.add(part);
            }
        }

    }

    private BufferedReader getContentPart(String path) {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return br;
    }
}
