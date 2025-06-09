package com.sistemabusca.strategy;

import com.sistemabusca.strategy.servidorb.ArtigoServidorDTO;

import java.util.ArrayList;
import java.util.List;

public class BuscaLinearStrategy implements IBuscaLinear {

    @Override
    public void fazerBuscaLinear(List<ArtigoServidorDTO> itens, String subString) {
        List<ArtigoServidorDTO> listaDeVerificados = new ArrayList<>();

        for (ArtigoServidorDTO item : itens) {
            if (item.getTitle().toLowerCase().contains(subString.toLowerCase()) || item.getAbstract().toLowerCase().contains(subString.toLowerCase()) || item.getLabel().toLowerCase().contains(subString.toLowerCase())) {
                listaDeVerificados.add(item);
            }
        }

        for (int i = 0; i < listaDeVerificados.size(); i++){
            System.out.println(listaDeVerificados.get(i).toString());
            System.out.println("====================================");
        }


    }

}
