package com.projeto.clientserver;
import java.net.*;
import java.io.*;
import com.projeto.clientserver.Mensagem;
import com.projeto.clientserver.Cliente;

public class ServidorRepasse {
    public static void main(String[] args) throws IOException{

        if (args.length != 1){
            System.err.println("Uso: java Servidor <numero da porta> <servico>; Onde em serviço s = soma e c = concatenção");
            System.exit(1);
        }
        int numeroPorta = Integer.parseInt(args[0]);
        try (
                ServerSocket serverSocket = new ServerSocket(numeroPorta);
                Socket clientSocket = serverSocket.accept();

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader in = new BufferedReader(isr);
        ) {
            String str, conteudo = "";
            while((str = in.readLine()) != null){
                conteudo += str;

            }
        }
    }
}
