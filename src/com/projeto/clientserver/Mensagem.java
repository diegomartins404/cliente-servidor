package com.projeto.clientserver;

import java.util.HashMap;
import java.util.Map;

public class Mensagem {

    public String operacao;
    public String arg1;
    public String arg2;
    Map<String, Object> params;

    public Mensagem(String[] args)
    {
        this.operacao = args[0];
        this.arg1= args[1];
        this.arg2 = args[2];
        params = new HashMap<>();
    }

    public void setParam(String chave, Object valor) {
        params.put(chave, valor);
    }

    public Object getParam(String chave)
    {
        return params.get(chave);
    }
}
