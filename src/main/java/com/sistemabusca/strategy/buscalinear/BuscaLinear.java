package com.sistemabusca.strategy.buscalinear;

import com.sistemabusca.strategy.servidorb.ArtigoServidorDTO;

import java.util.ArrayList;
import java.util.List;

public class BuscaLinear implements IBuscaLinear {

    @Override
    public void fazerBuscaLinear(List<ArtigoServidorDTO> itens) {
        List<String> listaDeVerificados = new ArrayList<>();


        for (ArtigoServidorDTO item : itens) {
            if (item.getTitle().contains("Systematic study")) {
                listaDeVerificados.add(item.getTitle());
            }
        }

        System.out.println(listaDeVerificados);



    }

}
