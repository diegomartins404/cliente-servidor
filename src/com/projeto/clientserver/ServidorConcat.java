package com.projeto.clientserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ServidorConcat
{
    public static void main(String[] args) throws IOException
    {
        String arg1, arg2;
        int numeroPorta = 12536;
        ObjectInputStream input;
        ObjectOutputStream output;
        Mensagem resposta;


        try {
            Servidor servidor = new Servidor(numeroPorta);
            servidor.abreOuvidor();
            System.out.println("conectou no servidor de concatenação");

            output = servidor.output();
            input = servidor.input();

            while(true){
                Mensagem dadosRecebidos = input.readObject();
                arg1 = (String) dadosRecebidos.getParam("arg1");
                arg2 = (String) dadosRecebidos.getParam("arg2");

                String concat = arg1 + arg2;

                dadosRecebidos.setParam("resposta", concat);

                output.writeObject(dadosRecebidos);

                output.flush();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
