package org.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventoTest {

    @org.junit.jupiter.api.Test
    public void testarLimiteParticipantesWorkshop() {
        Workshop workshop = new Workshop("Workshop Java", "2024-10-10");
        for (int i = 1; i <= 30; i++) {
            assertTrue(workshop.inscreverParticipante("Participante " + i));
        }
        // Tentativa de inscrever o 31º participante, que deve falhar
        assertFalse(workshop.inscreverParticipante("Participante 31"));
    }

    @Test
    public void testarCriacaoReuniaoPublica() {
        Reuniao reuniao = new Reuniao("Reunião Pública", "2024-11-10", false, null);
        assertTrue(reuniao.validar());
        assertTrue(reuniao.acessarReuniao(null)); // Sem senha necessária
    }

    @Test
    public void testarCriacaoReuniaoPrivada() {
        Reuniao reuniao = new Reuniao("Reunião Privada", "2024-11-10", true, "1234");
        assertTrue(reuniao.validar());
        assertFalse(reuniao.acessarReuniao("0000")); // Senha errada
        assertTrue(reuniao.acessarReuniao("1234")); // Senha correta
    }

    @Test
    public void testarCriacaoEventoCorporativo() {
        EventoCorporativo eventoCorporativo = new EventoCorporativo("Evento Corporativo", "2024-12-10", "Sala A", "Refeitorio");
        assertTrue(eventoCorporativo.validar());
    }

    @Test
    public void testarInscricaoExataParticipantesWorkshop() {
        Workshop workshop = new Workshop("Workshop Java", "2024-10-10");
        for (int i = 1; i <= 29; i++) {
            assertTrue(workshop.inscreverParticipante("Participante " + i));
        }
        // Inscrever o 30º participante, que deve ser permitido
        assertTrue(workshop.inscreverParticipante("Participante 30"));
    }

    @Test
    public void testarAcessoReuniaoPrivadaSemSenha() {
        Reuniao reuniaoPrivada = new Reuniao("Reunião Privada", "2024-12-15", true, "abcd");
        assertFalse(reuniaoPrivada.acessarReuniao(null)); // Acesso sem senha
        assertFalse(reuniaoPrivada.acessarReuniao("1234")); // Acesso com senha incorreta


    }
}
