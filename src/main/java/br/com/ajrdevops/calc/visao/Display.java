package br.com.ajrdevops.calc.visao;

import br.com.ajrdevops.calc.modelo.Memoria;
import br.com.ajrdevops.calc.modelo.MemoriaObservador;

import javax.swing.*;
import java.awt.*;


public class Display extends JPanel implements MemoriaObservador {

    private final JLabel label;
    public Display() {
        Memoria.getInstancia().adicionarObservador(this);
        setBackground(new Color(46,49,50));
        label = new JLabel(Memoria.getInstancia().getTextoAtual());
        label.setForeground(Color.WHITE);
        label.setFont(new Font("courier", Font.PLAIN, 30));

        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 18));
        add(label);

    }

    @Override
    public void valorAlterado(String novoValor) {
        label.setText(novoValor);
    }
}
