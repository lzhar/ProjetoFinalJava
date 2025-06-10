package com.sistemabusca.strategy.servidorb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ArtigoServidorDTO {
    private String title;
    @JsonProperty("abstract")
    private String abstractText;
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
        return this.abstractText;
    }
    public void setAbstractt(String abstractText){
        this.abstractText = abstractText;
    }

    public String getLabel(){
        return this.label;
    }
    public void setLabel(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return "Title -> "+getTitle()+" abstract -> "+getAbstract()+" label -> "+getLabel()+"\n"+"-----------\n";
    }
}
