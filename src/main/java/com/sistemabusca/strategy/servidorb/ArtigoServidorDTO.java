package com.sistemabusca.strategy.servidorb;

import java.util.ArrayList;
import java.util.List;

public class ArtigoServidorDTO {
    private String title;
    private String abstractt;
    private String label;

    public ArtigoServidorDTO(){
    }

    public String getTitle(){
        return this.title;
    }
    public void setTitulo(String title){
        this.title = title;
    }

    public String getAbstract(){
        return this.abstractt;
    }
    public void setAbstract(String abstractt){
        this.abstractt = abstractt;
    }

    public String getLabel(){
        return this.label;
    }
    public void setLabel(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return getTitle()+getAbstract()+getLabel();
    }
}
