package com.sistemabusca.strategy.servidorb;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistemabusca.strategy.BuscaJsonServidor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuscaDentroDoJson implements BuscaJsonServidor {

    @Override
    public ArrayList montarLista(String enderecoDoJson) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            File arquivoJson = new File(enderecoDoJson);
            System.out.println(ArtigoServidorDTO.class);

            List<ArtigoServidorDTO> itens = mapper.readValue(arquivoJson, new TypeReference<List<ArtigoServidorDTO>>(){});

            return armazenarNaLista(itens);


        }catch (IOException e){
            e.printStackTrace();
            return null;
        }


    }

    public ArrayList<String> armazenarNaLista(List<ArtigoServidorDTO> itens){
        List<String> listaParaVerificacao = new ArrayList<>();

        for (ArtigoServidorDTO item : itens){
            listaParaVerificacao.add(String.valueOf(item.toString()));
        }

        System.out.println(listaParaVerificacao.get(0));
//        for (Integer i = 0; i < listaParaVerificacao.size(); i++){
//            System.out.println(listaParaVerificacao);
//            System.out.println("---------------");
//        }
        return (ArrayList<String>) listaParaVerificacao;
    }

}
