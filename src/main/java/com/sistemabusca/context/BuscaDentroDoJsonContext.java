package com.sistemabusca.context;

import com.sistemabusca.strategy.buscas.BuscaDentroDoJsonStrategy;
import com.sistemabusca.strategy.servidor.ArtigoServidorDTO;

import java.util.ArrayList;

public class BuscaDentroDoJsonContext {
    private String server;

    public BuscaDentroDoJsonContext(String server){
        this.server = server;
    }

    public ArrayList<ArtigoServidorDTO> recuperarLista(){
        BuscaDentroDoJsonStrategy buscaDentroDoJsonB = new BuscaDentroDoJsonStrategy();
        String endereco = null;
        if(this.server.equalsIgnoreCase("b")){
            endereco = "C:\\Users\\luizh\\OneDrive\\Documents\\Java\\TrabFinalProgConcorrente\\src\\main\\resources\\dados_servidor_b.json";
        } else if (this.server.equalsIgnoreCase("c")) {
            endereco = "C:\\Users\\luizh\\OneDrive\\Documents\\Java\\TrabFinalProgConcorrente\\src\\main\\resources\\dados_servidor_c.json";
        }
        return buscaDentroDoJsonB.montarLista(endereco);
    }
}
