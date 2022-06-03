package com.projeto.clientserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class Cliente {

    private int porta;
    private String ip;

    Mensagem resposta;

    Socket socket;

    public Cliente(String[] endereco) throws IOException {
        this.ip = endereco[0];
        this.porta = Integer.parseInt(endereco[1]);
        this.socket = new Socket(endereco[0], Integer.parseInt(endereco[1]));
    }

    public void enviaDados(Mensagem args) throws IOException, ClassNotFoundException {
        /*o socket deve ser passado por parametro para se instanciar um input*/
        ObjectInputStream input = new ObjectInputStream(this.socket.getInputStream());
        ObjectOutputStream output = new ObjectOutputStream(this.socket.getOutputStream());
        output.writeObject(args);
        output.flush();
        this.resposta = (Mensagem) input.readObject();
    }

    public Socket getSocket() {
        return this.socket;
    }
    public Mensagem getResposta()
    {
        return this.resposta;
    }
}
