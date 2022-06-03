package com.projeto.clientserver;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class index {
    public static void main() throws IOException, ClassNotFoundException {
        String[] endereco, dados;
        String item1, item2, op;
        /*Scanner input = new Scanner(System.in);
        item1 = input.nextLine();
        item2 = input.nextLine();
        op = input.nextLine();*/


        /*endereco: strings:
            1. ip;
            2. porta*/


        endereco = new String[]{"localhost", "3333"};

        dados = new String[]{"3", "2", "s"};
        Mensagem mensagem = new Mensagem(dados);

        Cliente cliente = new Cliente(endereco);
        Mensagem resposta = cliente.getResposta();
        cliente.enviaDados(mensagem);
  /*coloar o envia msg para pedir um socket e a mensagem em si como parametros*/


    }
}
