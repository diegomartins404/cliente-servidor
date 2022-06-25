package com.projeto.clientserver;
import java.net.*;
import java.io.*;

public class ServidorRepasse{
    private ServerSocket serverSocket;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Mensagem dados;
        String oper, arg1, arg2;

        String[] enderecoSoma = new String[]{"localost", "15536"};
        String[] enderecoConcat = new String[]{"localhost", "12536"};

        int numeroPorta = 6789; //Integer.parseInt(args[0]);
        ObjectOutputStream output;
        ObjectInputStream input;

        Servidor servidor = new Servidor(numeroPorta);
        servidor.abreOuvidor();
        System.out.println("conectou");

        output = servidor.output();
        input = servidor.input();

        while(true) {
            dados = (Mensagem) input.readObject();
            oper = (String) dados.getParam("op");
            arg1 = (String) dados.getParam("arg1");
            arg2 = (String) dados.getParam("arg2");

            String[] enderecoDestino = {};

            boolean operacaoValida = true;

            Mensagem consulta = new Mensagem();

            switch (oper) {
                case "s":
                    enderecoDestino = enderecoSoma;
                    break;
                case "c":
                    enderecoDestino = enderecoConcat;
                    break;
                default:
                    operacaoValida = false;
                    dados.setParam("resultado", "Operação inválida");
            }

            if (operacaoValida != false) {
                Cliente cliente = new Cliente(enderecoDestino);
                dados.setParam("arg1", arg1);
                dados.setParam("arg2", arg2);
                cliente.enviaDados(dados);
                dados = cliente.getResposta();
            }
            output.writeObject(dados);
            output.flush();
        }
    }
}
