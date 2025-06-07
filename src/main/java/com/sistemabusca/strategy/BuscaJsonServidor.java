package com.sistemabusca.strategy;

import com.sistemabusca.strategy.servidorb.ArtigoServidorDTO;

import java.util.ArrayList;

public interface BuscaJsonServidor {
    ArrayList<ArtigoServidorDTO> montarLista(String enderecoJson);

}
