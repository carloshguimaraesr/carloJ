package org.example;

public class EventoCorporativo extends Evento {
    private String salaConferencia;
    private String areaRefeicao;

    public EventoCorporativo(String nome, String data, String salaConferencia, String areaRefeicao) {
        super(nome, data);
        this.salaConferencia = salaConferencia;
        this.areaRefeicao = areaRefeicao;
    }

    @Override
    public boolean validar() {
        return salaConferencia != null && !salaConferencia.isEmpty() &&
                areaRefeicao != null && !areaRefeicao.isEmpty();
    }
}
