package com.sistemabusca.strategy.servidorb;

import com.sistemabusca.strategy.BuscaLinearStrategy;

public class Teste {
    public static void main(String[] args) {
        BuscaDentroDoJson buscaDentroDoJsonB = new BuscaDentroDoJson();
        BuscaLinearStrategy buscaLinearEmB = new BuscaLinearStrategy();
        String endereco = "C:\\Users\\luizh\\OneDrive\\Documents\\Java\\TrabFinalProgConcorrente\\src\\main\\resources\\dados_servidor_b.json";
        buscaLinearEmB.fazerBuscaLinear(buscaDentroDoJsonB.montarLista(endereco), "teste");

        System.out.println("""
                        === <
                        === >
                        === <
                        === >
                    """);

        BuscaDentroDoJson buscaDentroDoJsonC = new BuscaDentroDoJson();
        String enderecoC = "C:\\Users\\luizh\\OneDrive\\Documents\\Java\\TrabFinalProgConcorrente\\src\\main\\resources\\dados_servidor_c.json";
        buscaDentroDoJsonC.montarLista(enderecoC);
    }
}
