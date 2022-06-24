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
    ObjectOutputStream output;

    ObjectInputStream input;

    public Cliente(String[] endereco) throws IOException {
        this.ip = endereco[0];
        this.porta = Integer.parseInt(endereco[1]);
        this.socket = new Socket(endereco[0], Integer.parseInt(endereco[1]));
    }

    public void enviaDados(Mensagem args) throws IOException {
        this.output = new ObjectOutputStream(this.socket.getOutputStream());
        this.input = new ObjectInputStream(this.socket.getInputStream());
        this.output.writeObject(args);
        this.output.flush();
    }

    public Socket getSocket() {
        return this.socket;
    }
    public Mensagem getResposta() throws IOException, ClassNotFoundException {
        return (Mensagem) this.input.readObject();
    }
}
