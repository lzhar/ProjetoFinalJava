package com.sistemabusca.context.buscalinear;

import com.sistemabusca.context.BuscaDentroDoJsonContext;
import com.sistemabusca.strategy.buscas.BuscaLinearStrategy;
import com.sistemabusca.strategy.servidor.ArtigoServidorDTO;
import com.sistemabusca.strategy.buscas.BuscaDentroDoJsonStrategy;

import java.util.ArrayList;

public class BuscaLinearContext {

    private String server;

    public BuscaLinearContext(String server){
        this.server = server;
    }


    public ArrayList<ArtigoServidorDTO> fazerBuscaDeManeiraLinear(String subString){
        BuscaLinearStrategy buscaLinear = new BuscaLinearStrategy();
        BuscaDentroDoJsonContext buscaDentroDoJsonContext = new BuscaDentroDoJsonContext(server);

        return buscaLinear.fazerBuscaLinear(buscaDentroDoJsonContext.recuperarLista(), subString);
    }
}
