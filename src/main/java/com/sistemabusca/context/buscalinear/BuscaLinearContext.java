package com.sistemabusca.context.buscalinear;

import com.sistemabusca.strategy.BuscaLinearStrategy;
import com.sistemabusca.strategy.servidorb.BuscaDentroDoJson;

import java.util.ArrayList;

public class BuscaLinearContext {

    private String server;

    public BuscaLinearContext(String server){
        this.server = server;
    }

    private ArrayList recuperarLista(){
        BuscaDentroDoJson buscaDentroDoJsonB = new BuscaDentroDoJson();
        String endereco = null;
        if(this.server.equalsIgnoreCase("b")){
            endereco = "C:\\Users\\luizh\\OneDrive\\Documents\\Java\\TrabFinalProgConcorrente\\src\\main\\resources\\dados_servidor_b.json";
        } else if (this.server.equalsIgnoreCase("c")) {
            endereco = "C:\\Users\\luizh\\OneDrive\\Documents\\Java\\TrabFinalProgConcorrente\\src\\main\\resources\\dados_servidor_c.json";
        }
        return buscaDentroDoJsonB.montarLista(endereco);
    }

    public void fazerBuscaDeManeiraLinear(String subString){
        BuscaLinearStrategy buscaLinear = new BuscaLinearStrategy();
        buscaLinear.fazerBuscaLinear(recuperarLista(), subString);
    }
}
