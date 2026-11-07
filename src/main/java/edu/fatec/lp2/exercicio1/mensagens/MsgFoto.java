package edu.fatec.lp2.exercicio1.mensagens;

public class MsgFoto extends Mensagem {
    private int tamanho;

    public MsgFoto(Contatinho destinatario, String horaEnvio, String conteudo, int tamanho){
        super(destinatario, horaEnvio, conteudo);
        this.tamanho = tamanho;
    }

    @Override
    public Mensagem sendMessage(String mensagem) {
        return this;
    }

    @Override
    public String toString() {
        return super.toString()+"\n Tamanho: "+tamanho;
    }
}
