package com.sistemabusca.servidor.servidorB;

import com.sistemabusca.strategy.servidorb.BuscaDentroDoJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorB {
    public static void main(String[] args) {
        final int PORT = 8081;

        try(ServerSocket socket = new ServerSocket(PORT)){
            System.out.println("Servidor aguardando conexão na porta -> " + socket.getLocalPort());
            Socket clientSocket = socket.accept();
            System.out.println("cliente -> " + clientSocket.getInetAddress()+" conectado! ");
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String dados = in.readLine();

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public static ArrayList recuperarLista(){
        BuscaDentroDoJson buscaDentroDoJsonB = new BuscaDentroDoJson();
        String endereco = "C:\\Users\\luizh\\OneDrive\\Documents\\Java\\TrabFinalProgConcorrente\\src\\main\\resources\\dados_servidor_b.json";

        return buscaDentroDoJsonB.montarLista(endereco);
    }
}
