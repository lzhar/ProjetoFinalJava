package com.sistemabusca.strategy.buscas;

import com.sistemabusca.strategy.servidor.ArtigoServidorDTO;

import java.util.ArrayList;

public interface IBuscaJsonServidor {
    ArrayList<ArtigoServidorDTO> montarLista(String enderecoJson);

}