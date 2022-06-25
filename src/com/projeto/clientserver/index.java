package com.projeto.clientserver;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class index {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String[] endereco;
        Mensagem resposta;
        String resultado;

        endereco = new String[]{"localhost", "6789"};
        Cliente cliente = new Cliente(endereco);

        Scanner inputTeclado = new Scanner(System.in);
        String op = inputTeclado.nextLine();
        String arg1 = inputTeclado.nextLine();
        String arg2 = inputTeclado.nextLine();

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
