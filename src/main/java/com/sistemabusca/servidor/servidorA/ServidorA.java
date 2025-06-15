package com.sistemabusca.servidor.servidorA;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLOutput;

public class ServidorA {
    public static void main(String[] args) throws IOException {
        abrirServerRecebendoDados();
    }

    public static void abrirServerRecebendoDados() throws IOException {
        final int PORT = 8080;

        try(ServerSocket socket = new ServerSocket(PORT)){
            System.out.println("Servidor aguardando conexão na porta -> " + socket.getLocalPort());
            Socket clientSocket = socket.accept();
            System.out.println("cliente -> " + clientSocket.getInetAddress()+ "conectado! ");
            enviarParaOCliente(clientSocket, receberString(clientSocket));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void enviarParaOCliente(Socket clientSocket, String dados) throws IOException {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(enviarParaServidoresBeCeObterRetornoParaEnviarCliente(dados).toString());
    }

    public static String receberString(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String dados = in.readLine();
        return String.valueOf(dados);
    }

    public static StringBuilder enviarParaServidoresBeCeObterRetornoParaEnviarCliente(String string) throws IOException{
        final String HOST = "localhost";
        final int PORTB = 8081;
        final int PORTC = 8082;

        StringBuilder respostaB = new StringBuilder();
        StringBuilder respostaC = new StringBuilder();

        try{
            Socket socketParaB = new Socket(HOST, PORTB);
            PrintWriter outParaB = new PrintWriter(socketParaB.getOutputStream(), true);
            BufferedReader inParaB = new BufferedReader(new InputStreamReader(socketParaB.getInputStream()));
            outParaB.println(string);

            String linhaParaB = inParaB.readLine();
            if(linhaParaB.equals("EMPTY")){
                respostaB.append("EMPTY RESULT");
            }else if(linhaParaB.equals("START")){
                while(!(linhaParaB = inParaB.readLine()).equals("END!")){
                    respostaB.append(linhaParaB).append("\n");
                }
            }
        }catch (Exception e){
            System.out.println("Não foi possivel conectar no servidor B");
        }
        try{
            Socket socketParaC = new Socket(HOST, PORTC);
            PrintWriter outParaC = new PrintWriter(socketParaC.getOutputStream(), true);
            outParaC.println(string);
            BufferedReader inParaC = new BufferedReader(new InputStreamReader(socketParaC.getInputStream()));
            String linhaParaC = inParaC.readLine();

            if(linhaParaC.equals("EMPTY")){
                respostaC.append("EMPTY RESULT");
            }else if(linhaParaC.equals("START")){
                while(!(linhaParaC = inParaC.readLine()).equals("END!")){
                    respostaC.append(linhaParaC).append("\n");
                }
            }
        }catch (Exception e){
            System.out.println("Não foi possivel se conectar no servidor C");

        }


        StringBuilder respostaDeBeC = new StringBuilder();
        respostaDeBeC.append("\n======= RESPONSE OF B ========= \n")
                .append(respostaB)
                .append("\n==========================")
                .append("\n======= RESPONSE OF C ========= \n")
                .append(respostaC)
                .append("\nEND OF ARTICLES");

        return respostaDeBeC;
    }

}
