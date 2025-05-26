package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Tarefa {
    String titulo;
    int id;
    String dataDeVencimento;
    String descricao;
    String status;

    public Tarefa(String titulo, int id, String dataDeVencimento,
                  String descricao, String status) {
        this.titulo = titulo;
        this.id = id;
        this.dataDeVencimento = dataDeVencimento;
        this.descricao = descricao;
        this.status = status;
    }
    @Override
    public String toString() {
        return String.format("""
        ╔════════════════════════════════╗
        ║ 📌 Tarefa #%d
        ╠════════════════════════════════╣
        ║ 📝 Título       : %s
        ║ 📍 Status       : %s
        ║ 📃 Descrição    : %s
        ║ 🗓️ Vencimento   : %s
        ╚════════════════════════════════╝
        """, id, titulo, dataDeVencimento, descricao, status
        );
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setStatus(Status status, int id) throws IOException {
        String path = "src/main/resources/data/tarefas.json";
        String json = Files.readString(Path.of(path));
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            if (obj.getInt("id") == id) { // Essa parte aqui.
                obj.put("status", status.obterStatus());
            }
        }
        Files.writeString(Path.of(path), array.toString(2));
        this.status = status.obterStatus();
    }

    public void setDescricao(String descricao, int id) throws IOException {
        setting("descricao", descricao, id);
        this.descricao = descricao;
    }

    public void setDataDeVencimento(String dataDeVencimento, int id) throws IOException {
        setting("dataDeVencimento", dataDeVencimento, id);
        this.dataDeVencimento = dataDeVencimento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo, int id) throws IOException {
        setting("titulo", titulo, id);
        this.titulo = titulo;
    }

    private void setting(String key, String itemToEdit, int id) throws IOException {
        String path = "src/main/resources/data/tarefas.json";
        String json = Files.readString(Path.of(path));
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            if (obj.getInt("id") == id) { // Essa parte aqui.
                obj.put(key, itemToEdit);
            }
        }
        Files.writeString(Path.of(path), array.toString(2));
    }
}
