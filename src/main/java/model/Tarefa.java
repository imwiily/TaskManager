package model;

import java.util.ArrayList;
import java.util.List;

public class Tarefa {

    String titulo;
    String descricao;
    String dataDeVencimento;
    List<String> status = new ArrayList<String>();
    String realStatus;

    public Tarefa(String titulo, String descricao, String dataDeVencimento, int status) {
        this.status.add("pendente");
        this.status.add("em andamento");
        this.status.add("concluído");
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataDeVencimento = dataDeVencimento;
        realStatus = this.status.get(status).toString();




    }
}
