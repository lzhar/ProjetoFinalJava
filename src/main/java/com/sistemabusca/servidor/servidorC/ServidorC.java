package com.sistemabusca.servidor.servidorC;

import com.sistemabusca.context.buscalinear.BuscaLinearContext;
import com.sistemabusca.strategy.servidor.ArtigoServidorDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorC {
    public static void main(String[] args) {
        final int PORT = 8082;
        BuscaLinearContext buscaLinearContext = new BuscaLinearContext("c");

        try(ServerSocket socket = new ServerSocket(PORT)){
            System.out.println("Servidor aguardando conexão na porta -> " + socket.getLocalPort());
            Socket clientSocket = socket.accept();
            System.out.println("cliente -> " + clientSocket.getInetAddress()+" conectado! ");
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String dados = in.readLine();

            ArrayList<ArtigoServidorDTO> resultados = buscaLinearContext.fazerBuscaDeManeiraLinear(dados);

            if(resultados == null || resultados.isEmpty()){
                out.println("EMPTY");
            }else{
                out.println("START");
                for(ArtigoServidorDTO artigoServidorDTO : resultados){
                    out.println(artigoServidorDTO);
                }
                out.println(("END!"));
                out.flush();
            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


