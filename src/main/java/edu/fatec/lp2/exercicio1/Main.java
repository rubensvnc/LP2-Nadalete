package edu.fatec.lp2.exercicio1;

import edu.fatec.lp2.exercicio1.mensagens.*;

public class Main {
    public static void main(String[] args) {
        Contatinho[] contatinhos = new Contatinho[3];
        Mensagem[] mensagens = new Mensagem[3];

        contatinhos[0] = new Contatinho("Pedro", "0");
        contatinhos[1] = new Contatinho("Gustavo", "1");
        contatinhos[2] = new Contatinho("Jonas", "2");

        mensagens[0] = new MsgTexto(contatinhos[0], "12:40", "oi", 123);
        mensagens[1] = new MsgAudio(contatinhos[1], "14:20", "tchau", 50);
        mensagens[2] = new MsgFoto(contatinhos[2], "17:00", "oi", 1000);

        Whatsapp w1 = new Whatsapp(contatinhos, mensagens);
        w1.listarContatos();
        w1.listarMensagens();

        System.out.println("--- sendMessage ---");
        for (int i = 0; i < mensagens.length; i++) {
            Mensagem retorno = mensagens[i].sendMessage("novo conteudo");
            System.out.println("Subclasse " + (i+1) + " retornou a propria instancia: " + (retorno == mensagens[i]));
        }
    }
}
