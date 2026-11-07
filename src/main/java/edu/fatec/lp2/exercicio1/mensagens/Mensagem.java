package edu.fatec.lp2.exercicio1.mensagens;

public abstract class Mensagem {
    private Contatinho destinatario;
    private String horaEnvio;
    private String conteudo;

    public Mensagem(Contatinho destinatario, String horaEnvio, String conteudo){
        this.destinatario = destinatario;
        this.horaEnvio = horaEnvio;
        this.conteudo = conteudo;
    }

    public abstract Mensagem sendMessage(String mensagem);

    @Override
    public String toString() {
        return "Destinatario: "+destinatario.getNome()+"; horaEnvio: "+horaEnvio+"; conteudo: "+conteudo ;
    }
}
