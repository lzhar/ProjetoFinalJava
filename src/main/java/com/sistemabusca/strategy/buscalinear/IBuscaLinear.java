package com.sistemabusca.strategy.buscalinear;

import com.sistemabusca.strategy.servidorb.ArtigoServidorDTO;

import java.util.ArrayList;
import java.util.List;

public interface IBuscaLinear {
    public void fazerBuscaLinear(List<ArtigoServidorDTO> itens, String subString);
}
