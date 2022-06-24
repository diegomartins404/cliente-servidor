package com.projeto.clientserver;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class index {
    public static void main(String[] argss) throws IOException, ClassNotFoundException {
        String[] endereco;

        endereco = new String[]{"localhost", "6789"};
        Cliente cliente = new Cliente(endereco);

        Mensagem mensagem = new Mensagem();
        mensagem.setParam("op", "3");
        mensagem.setParam("arg1", "3");
        mensagem.setParam("arg2", "4");



        cliente.enviaDados(mensagem);
        Mensagem resposta = cliente.getResposta();
        System.out.println("sexo");
    }
}
