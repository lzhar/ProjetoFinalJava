package com.sistemabusca.servidor.servidor1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ServidorA {
    public static void main(String[] args) {

        final int PORT = 8080;

        try(ServerSocket socket = new ServerSocket(PORT)){
            System.out.println("Servidor aguardando conexão na porta -> " + socket.getLocalPort());
            Socket clientSocket = socket.accept();
            System.out.println("cliente -> " + clientSocket.getInetAddress()+ "conectado! ");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String nome = in.readLine();
            System.out.println(buscaDoCliente(nome));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String buscaDoCliente(String nome){
        return nome;
    }
}
