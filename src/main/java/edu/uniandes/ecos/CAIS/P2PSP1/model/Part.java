/**
* Programa: Programa 2 - PSP 1
* @author Juan Sebastian Paz Prieto 
* @date  20/02/2017 
* Clase: Part
* Descripción: Clase que tiene los atributos de las partes o clases del proyecto
**/
package edu.uniandes.ecos.CAIS.P2PSP1.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part {

    /**
     * Método constructor de la clase Part
     */
    public Part() {
        this.size = 0;
        this.itemsNumber = 0;
        this.name = "";
    }

    private int size;

    private int itemsNumber;

    private String name;

    private BufferedReader content;

    /**
     * Método que permite acceder al tamaño de la parte
     * @return un valor <code>int</code> que representa el tamaño de la parte.
     */
    public int getSize() {
        return size;
    }

    /**
     * Método que permite acceder al número de items de la parte.
     * @return un valor <code>int</code> que representa el número de items de la parte.
     */
    public int getItemsNumber() {
        return itemsNumber;
    }

    /**
     * Método que permite acceder al nombre de la parte.
     * @return un valor <code>String</code> que representa el nombre de la parte
     */
    public String getName() {
        return name;
    }

    /**
     * Método que permite establecer un valor para el nombre de la parte
     * @param name nombre de la clase
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que permite acceder al contenido de la parte
     * @return un valor <code>BufferedReader</code> que representa el contenido de la parte
     */
    public BufferedReader getContent() {
        return content;
    }

    /**
     * Método que permite establecer un valor para el contenido de la parte
     * @param content contenido de la clase
     */
    public void setContent(BufferedReader content) {
        this.content = content;
    }

    /**
     * Método que lee el contenido de la parte, y realiza el conteo segun el 
     * estandar de conteo establecido.
     */
    public void readPart() {
        CharSequence publicFunction = "public";
        CharSequence privateFunction = "private";
        CharSequence paramFunction = "(";
        CharSequence singleComment = "/";
        CharSequence blockComment = "*";
        CharSequence semicolon = ";";
        try {
            String sCurrentLine;

            while ((sCurrentLine = this.content.readLine()) != null) {

                if (!sCurrentLine.isEmpty()) {
                    if (!sCurrentLine.contains(singleComment) && !sCurrentLine.contains(blockComment)) {
                        this.size++;
                        if ((sCurrentLine.contains(publicFunction) || sCurrentLine.contains(privateFunction)) && sCurrentLine.contains(paramFunction)) {
                            this.itemsNumber++;
                        }
                    } else {
                        if (sCurrentLine.contains(semicolon)) {
                            this.size++;
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Part.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
