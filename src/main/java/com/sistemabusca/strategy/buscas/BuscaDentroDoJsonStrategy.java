package com.sistemabusca.strategy.buscas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistemabusca.strategy.servidor.ArtigoServidorDTO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuscaDentroDoJsonStrategy implements IBuscaJsonServidor {

    @Override
    public ArrayList<ArtigoServidorDTO> montarLista(String enderecoDoJson) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            File arquivoJson = new File(enderecoDoJson);
            System.out.println(ArtigoServidorDTO.class);

            List<ArtigoServidorDTO> itens = mapper.readValue(arquivoJson, new TypeReference<List<ArtigoServidorDTO>>(){});

            List<ArtigoServidorDTO> listaParaVerificacao = new ArrayList<>();

            for (ArtigoServidorDTO item : itens){
                listaParaVerificacao.add(item);
            }

            return (ArrayList<ArtigoServidorDTO>) listaParaVerificacao;


        }catch (IOException e){
            e.printStackTrace();
            return null;
        }


    }


}
