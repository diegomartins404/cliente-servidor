package com.projeto.clientserver;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class index {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String[] endereco;
        Mensagem resposta;
        String resultado, op, arg1, arg2;

        endereco = new String[]{"localhost", "6789"};
        Cliente cliente = new Cliente(endereco);

        Scanner input = new Scanner(System.in);
        op = input.nextLine();
        arg1 = input.nextLine();
        arg2 = input.nextLine();

        Mensagem mensagem = new Mensagem();
        mensagem.setParam("op", op);
        mensagem.setParam("arg1", arg1);
        mensagem.setParam("arg2", arg2);

        cliente.enviaDados(mensagem);
        resposta = (Mensagem) cliente.getResposta();
        resultado = (String) resposta.getParam("resultado");
        System.out.println(resultado);
    }
}
