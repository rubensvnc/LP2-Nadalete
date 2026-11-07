package edu.fatec.lp2.exercicio1.mensagens;

public class MsgAudio extends Mensagem{
    private int duracao;

    public MsgAudio(Contatinho destinatario, String horaEnvio, String conteudo, int duracao){
        super(destinatario, horaEnvio, conteudo);
        this.duracao = duracao;
    }

    @Override
    public Mensagem sendMessage(String mensagem) {
        return this;
    }

    @Override
    public String toString() {
        return super.toString()+"\n Duracao: "+duracao;
    }
}
