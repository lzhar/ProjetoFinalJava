package com.sistemabusca.strategy.buscalinear;

import com.sistemabusca.strategy.servidorb.ArtigoServidorDTO;

import java.util.ArrayList;
import java.util.List;

public class BuscaLinear implements IBuscaLinear {

    @Override
    public void fazerBuscaLinear(List<ArtigoServidorDTO> itens, String subString) {
        List<String> listaDeVerificados = new ArrayList<>();

        for (ArtigoServidorDTO item : itens) {
            if (item.getTitle().contains(subString)) {
                listaDeVerificados.add(item.getTitle());
            }
        }

        System.out.println(listaDeVerificados);

    }

}
