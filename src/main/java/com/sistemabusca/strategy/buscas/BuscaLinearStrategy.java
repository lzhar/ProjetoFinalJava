package com.sistemabusca.strategy.buscas;

import com.sistemabusca.strategy.servidor.ArtigoServidorDTO;

import java.util.ArrayList;
import java.util.List;

public class BuscaLinearStrategy implements IBuscaLinear {

    @Override
    public ArrayList<ArtigoServidorDTO> fazerBuscaLinear(List<ArtigoServidorDTO> itens, String subString) {
        ArrayList<ArtigoServidorDTO> listaDeVerificados = new ArrayList<>();

        for (ArtigoServidorDTO item : itens) {
            if (item.getTitle().toLowerCase().contains(subString.toLowerCase()) || item.getAbstract().toLowerCase().contains(subString.toLowerCase()) || item.getLabel().toLowerCase().contains(subString.toLowerCase())) {
                listaDeVerificados.add(item);
            }
        }

        return listaDeVerificados;

    }

}