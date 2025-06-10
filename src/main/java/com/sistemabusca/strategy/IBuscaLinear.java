package com.sistemabusca.strategy;

import com.sistemabusca.strategy.servidorb.ArtigoServidorDTO;

import java.util.ArrayList;
import java.util.List;

public interface IBuscaLinear {
    public ArrayList<ArtigoServidorDTO> fazerBuscaLinear(List<ArtigoServidorDTO> itens, String subString);
}
