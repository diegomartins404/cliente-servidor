package com.projeto.clientserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Socket socket;
    private ServerSocket serverSocket;
    int porta;
    public Servidor(int porta) throws IOException {
        this.porta = porta;
        this.serverSocket = new ServerSocket(porta);
    }
    public void abreOuvidor() throws IOException {
        this.socket = serverSocket.accept();
    }

    public ObjectOutputStream output() throws IOException {
        return this.output = new ObjectOutputStream(this.socket.getOutputStream());
    }

    public ObjectInputStream input() throws IOException {
        return this.input = new ObjectInputStream(this.socket.getInputStream());
    }
}
