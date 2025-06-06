package com.sistemabusca.cliente;

import java.io.IOException;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        final String HOST = "localhost";
        final int PORT = 8080;

        Socket socket = new Socket(HOST, PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println(enviarSubString());
    }

    public static String enviarSubString(){
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite aqui a string para enviar ao servidor -> ");
        String string = leitura.nextLine();
        return string;
    }
}
