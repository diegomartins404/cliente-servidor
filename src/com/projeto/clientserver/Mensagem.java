package com.projeto.clientserver;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Mensagem implements Serializable {

    Map<String, Object> params;

    public Mensagem()
    {
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
