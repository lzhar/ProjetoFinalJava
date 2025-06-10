package com.sistemabusca.strategy.servidor;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtigoServidorDTO {
    @JsonProperty("title")
    private String title;
    @JsonProperty("abstract")
    private String abstractText;
    @JsonProperty("label")
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
        return String.format("Title of article: %s. Abstract of article: %sLabel of article: %s \n=========", getTitle(), getAbstract(), getLabel());
    }
}
