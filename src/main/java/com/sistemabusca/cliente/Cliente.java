package com.sistemabusca.cliente;

import java.io.IOException;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        final String HOST = "localhost";
        final int PORT = 8080;

        Socket socket = new Socket(HOST, PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println(enviarSubString());

        String linhaResposta;
        int contador = 0;
        while ((linhaResposta = in.readLine()) != null) {
            System.out.println(linhaResposta);
            contador++;
            if (linhaResposta.equals("END OF ARTICLES")) break;
        }
        System.out.println(contador);
        socket.close();
    }

    public static String enviarSubString(){
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite aqui a string para enviar ao servidor -> ");
        String string = leitura.nextLine();
        return string;
    }

}
