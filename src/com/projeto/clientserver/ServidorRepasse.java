package com.projeto.clientserver;
import java.net.*;
import java.io.*;

public class ServidorRepasse{
    private ServerSocket serverSocket;
    public static void main(String[] args) throws IOException{
        Mensagem dados;
        String oper, arg1, arg2;

        String[] enderecoSoma = new String[]{"localost", "12536"};
        String[] enderecoConcat = new String[]{"localhost", "15536"};

        int numeroPorta = 6789; //Integer.parseInt(args[0]);
        ObjectOutputStream output;
        ObjectInputStream input;

        try {
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

                String[] enderecoDestino;

                Cliente cliente = new Cliente(enderecoDestino);
                Mensagem consulta = new Mensagem();

                try {
                    switch (oper) {
                        case "s":
                            enderecoDestino = enderecoSoma;
                        case "c":
                            enderecoDestino = enderecoConcat;
                        default:
                            throw new RuntimeException();
                    }

                    consulta.setParam("arg1", arg1);
                    consulta.setParam("arg2", arg2);

                } catch (RuntimeException e) {
                    System.out.println("Operação inválida");
                    consulta.setParam("resposta", "Operação inválida");
                }

                cliente.enviaDados(consulta);

                Mensagem resultado = cliente.getResposta();
                output.writeObject(resultado);

                output.flush();
            }

        } catch (IOException e){
            System.out.println("ERRO: Cliente não sincronizado");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
