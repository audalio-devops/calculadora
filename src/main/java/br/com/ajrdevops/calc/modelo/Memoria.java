package br.com.ajrdevops.calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
    private static final Memoria instancia = new Memoria();

    private String textoAtual = "";
    private final List<MemoriaObservador> observadores = new ArrayList<>();

    private Memoria() {

    }

    public static Memoria getInstancia() {
        return instancia;
    }

    public void adicionarObservador (MemoriaObservador o) {
        observadores.add(o);
    }
    public String getTextoAtual() {
        return textoAtual.isEmpty() ? "0" : textoAtual;
    }

    public void processarComando(String valor) {
        if ("AC".equals(valor)) {
            textoAtual = "";
        } else {
            textoAtual += valor;
        }
        observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
    }
}
