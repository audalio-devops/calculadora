package br.com.ajrdevops.calc.modelo;

@FunctionalInterface
public interface MemoriaObservador {
    public void valorAlterado(String novoValor);
}
