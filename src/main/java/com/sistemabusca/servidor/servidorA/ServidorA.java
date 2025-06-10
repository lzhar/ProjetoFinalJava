package com.sistemabusca.servidor.servidorA;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ServidorA {
    public static void main(String[] args) {
        abrirServerRecebendoDados();
    }

    public static void abrirServerRecebendoDados(){
        final int PORT = 8080;

        try(ServerSocket socket = new ServerSocket(PORT)){
            System.out.println("Servidor aguardando conexão na porta -> " + socket.getLocalPort());
            Socket clientSocket = socket.accept();
            System.out.println("cliente -> " + clientSocket.getInetAddress()+ "conectado! ");
            enviarParaServidoresBeC(receberString(clientSocket));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String receberString(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String dados = in.readLine();
        return dados;
    }

    public static void enviarParaServidoresBeC(String string) throws IOException{
        final String HOST = "localhost";
        final int PORTB = 8081;
        final int PORTC = 8082;

        Socket socketParaB = new Socket(HOST, PORTB);
        Socket socketParaC = new Socket(HOST, PORTC);

        PrintWriter outParaB = new PrintWriter(socketParaB.getOutputStream(), true);
        BufferedReader inParaB = new BufferedReader(new InputStreamReader(socketParaB.getInputStream()));

        PrintWriter outParaC = new PrintWriter(socketParaC.getOutputStream(), true);
        BufferedReader inParaC = new BufferedReader(new InputStreamReader(socketParaC.getInputStream()));

        outParaB.println(string);
        outParaC.println(string);

        StringBuilder respostaB = new StringBuilder();
        String linhaParaB = inParaB.readLine();

        if(linhaParaB.equals("NENHUM RESULTADO")){
            respostaB.append("Nenhum resultado foi encontrado");
        }else if(linhaParaB.equals("INICIO")){
            while(!(linhaParaB = inParaB.readLine()).equals("FIM!")){
                respostaB.append(linhaParaB).append("\n");
            }
        }

        System.out.println(respostaB);

    }

}
