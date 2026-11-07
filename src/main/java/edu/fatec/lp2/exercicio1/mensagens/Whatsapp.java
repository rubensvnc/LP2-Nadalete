package edu.fatec.lp2.exercicio1.mensagens;

public class Whatsapp {
    private Contatinho[] contatos;
    private Mensagem[] mensagens;

    public Whatsapp(Contatinho[] contatos, Mensagem[] mensagens){
        this.contatos = contatos;
        this.mensagens = mensagens;
    }

    public void listarContatos(){
        for (int i=0; i < contatos.length; i++){
            System.out.println("Contato "+(i+1)+": ");
            System.out.println("    Nome: "+contatos[i].getNome());
            System.out.println("    Celular: "+contatos[i].getCelular());
        }
    }

    public void listarMensagens(){
        for (int i=0; i < mensagens.length; i++){
            System.out.println(mensagens[i].toString());
        }
    }
}
