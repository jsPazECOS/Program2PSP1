/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.CAIS.P2PSP1.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Paz
 */
public class Part {

    public Part() {
        this.size = 0;
        this.itemsNumber = 0;
        this.name = "";
    }

    private int size;

    private int itemsNumber;

    private String name;

    private BufferedReader content;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getItemsNumber() {
        return itemsNumber;
    }

    public void setItemsNumber(int itemsNumber) {
        this.itemsNumber = itemsNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedReader getContent() {
        return content;
    }

    public void setContent(BufferedReader content) {
        this.content = content;
    }

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
                    //if (!sCurrentLine.contains(singleComment) || !sCurrentLine.contains(blockComment)) {
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
