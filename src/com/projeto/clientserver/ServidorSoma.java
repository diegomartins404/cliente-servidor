package com.projeto.clientserver;
import com.projeto.clientserver.Cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ServidorSoma {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Mensagem dados;
        String arg1, arg2, soma;

        int numeroPorta = 15536;
        Servidor servidor = new Servidor(numeroPorta);

        servidor.abreOuvidor();

        ObjectOutputStream output;
        ObjectInputStream input;

        output = servidor.output();
        input = servidor.input();

        while(true){
            dados = (Mensagem) input.readObject();
            arg1 = (String) dados.getParam("arg1");
            arg2 = (String) dados.getParam("arg2");

            soma = String.valueOf(Integer.parseInt(arg1) + Integer.parseInt(arg2));

            dados.setParam("resultado", soma);

            output.writeObject(dados);

            output.flush();
        }
    }
}
