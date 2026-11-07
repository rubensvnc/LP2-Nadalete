package edu.fatec.lp2.exercicio1.mensagens;

public class MsgTexto extends Mensagem {
    private int numChar;

    public MsgTexto(Contatinho destinatario, String horaEnvio, String conteudo, int numChar){
        super(destinatario, horaEnvio, conteudo);
        this.numChar = numChar;
    }

    @Override
    public Mensagem sendMessage(String mensagem) {
        return this;
    }

    @Override
    public String toString() {
        return super.toString()+"\n NumChar: "+numChar;
    }
}
