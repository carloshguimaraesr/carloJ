package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação de um Workshop
        System.out.println("Criando um Workshop:");
        Workshop workshop = new Workshop("Workshop Java", "2024-10-10");
        System.out.println("Workshop criado: " + workshop.nome + " na data " + workshop.data);

        // Inscrevendo participantes no Workshop
        System.out.println("Inscrevendo participantes no Workshop:");
        for (int i = 1; i <= 30; i++) {
            boolean sucesso = workshop.inscreverParticipante("Participante " + i);
            if (sucesso) {
                System.out.println("Participante " + i + " inscrito com sucesso.");
            } else {
                System.out.println("Falha ao inscrever Participante " + i + ". Limite atingido.");
            }
        }

        // Tentando inscrever o 31º participante (espera-se que falhe)
        boolean sucesso = workshop.inscreverParticipante("Participante 31");
        if (!sucesso) {
            System.out.println("Não foi possível inscrever o Participante 31. Limite de participantes atingido.");
        }

        System.out.println("\n---\n");

        // Criação de uma Reunião Pública
        System.out.println("Criando uma Reunião Pública:");
        Reuniao reuniaoPublica = new Reuniao("Reunião de Produto", "2024-11-10", false, null);
        System.out.println("Reunião pública criada. Nenhuma senha necessária para acessar.");

        // Tentativa de acessar a reunião pública (sem senha)
        boolean acesso = reuniaoPublica.acessarReuniao(null);
        if (acesso) {
            System.out.println("Acesso à reunião pública permitido.");
        } else {
            System.out.println("Acesso à reunião pública negado.");
        }

        System.out.println("\n---\n");

        // Criação de uma Reunião Privada
        System.out.println("Criando uma Reunião Privada:");
        Reuniao reuniaoPrivada = new Reuniao("Reunião Privada", "2024-11-15", true, "abcd");
        System.out.println("Reunião privada criada. Senha necessária para acessar.");

        // Tentativa de acessar a reunião privada com senha errada
        System.out.print("Tentando acessar a reunião privada com senha errada... ");
        acesso = reuniaoPrivada.acessarReuniao("1234");
        if (acesso) {
            System.out.println("Acesso permitido.");
        } else {
            System.out.println("Acesso negado. Senha incorreta.");
        }

        // Tentativa de acessar a reunião privada com a senha correta
        System.out.print("Tentando acessar a reunião privada com a senha correta... ");
        acesso = reuniaoPrivada.acessarReuniao("abcd");
        if (acesso) {
            System.out.println("Acesso permitido.");
        } else {
            System.out.println("Acesso negado.");
        }

        System.out.println("\n---\n");

        // Criação de um Evento Corporativo
        System.out.println("Criando um Evento Corporativo:");
        System.out.print("Digite o nome da sala de conferência: ");
        String salaConferencia = scanner.nextLine();
        System.out.print("Digite o nome da área de refeições: ");
        String areaRefeicao = scanner.nextLine();

        EventoCorporativo eventoCorporativo = new EventoCorporativo("Evento Corporativo", "2024-12-10", salaConferencia, areaRefeicao);
        System.out.println("Evento corporativo criado com sala de conferência '" + salaConferencia + "' e área de refeições '" + areaRefeicao + "'.");

        // Validar se o evento corporativo está configurado corretamente
        if (eventoCorporativo.validar()) {
            System.out.println("Evento Corporativo validado com sucesso.");
        } else {
            System.out.println("Falha na validação do Evento Corporativo.");
        }

        scanner.close();
    }
}
