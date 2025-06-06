package com.sistemabusca.strategy.servidorb;

public class Teste {
    public static void main(String[] args) {
        BuscaDentroDoJson buscaDentroDoJsonB = new BuscaDentroDoJson();
        String endereco = "C:\\Users\\luizh\\OneDrive\\Documents\\Java\\TrabFinalProgConcorrente\\src\\main\\resources\\dados_servidor_b.json";
        buscaDentroDoJsonB.montarLista(endereco);
    }
}
