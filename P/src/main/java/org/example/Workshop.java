package org.example;

import java.util.ArrayList;
import java.util.List;

public class Workshop extends Evento {
    private static int limite = 30;
    private List<String> participantes;

    public Workshop(String nome, String data) {
        super(nome, data);
        this.participantes = new ArrayList<>();
    }

    public boolean inscreverParticipante(String participante) {
        if (participantes.size() < limite) {
            participantes.add(participante);
            return true;
        }
        return false;
    }

    @Override
    public boolean validar() {
        return participantes.size() <= limite;
    }
}