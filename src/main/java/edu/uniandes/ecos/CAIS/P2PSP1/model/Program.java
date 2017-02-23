/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.CAIS.P2PSP1.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Juan Paz
 */
public class Program {

    private int size;

    private LinkedList<Part> parts;

    private String srcPath;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size += size;
    }

    public LinkedList<Part> getParts() {
        return parts;
    }

    public void setParts(LinkedList<Part> parts) {
        this.parts = parts;
    }

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public Program(String srcPath) {
        this.srcPath = srcPath;
        this.parts = new LinkedList<Part>();
        this.size = 0;
        this.readProgramStructure(this.srcPath);

    }

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
