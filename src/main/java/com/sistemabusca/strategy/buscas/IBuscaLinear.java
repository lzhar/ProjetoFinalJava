package com.sistemabusca.strategy.buscas;

import com.sistemabusca.strategy.servidor.ArtigoServidorDTO;

import java.util.ArrayList;
import java.util.List;

public interface IBuscaLinear {
    public ArrayList<ArtigoServidorDTO> fazerBuscaLinear(List<ArtigoServidorDTO> itens, String subString);
}