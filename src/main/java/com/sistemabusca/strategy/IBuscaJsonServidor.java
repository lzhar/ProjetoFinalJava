package com.sistemabusca.strategy;

import com.sistemabusca.strategy.servidorb.ArtigoServidorDTO;

import java.util.ArrayList;

public interface IBuscaJsonServidor {
    ArrayList<ArtigoServidorDTO> montarLista(String enderecoJson);

}
