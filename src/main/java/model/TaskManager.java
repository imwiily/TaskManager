package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class TaskManager {
    String titulo;
    String descricao;
    String dataDeVencimento;
    Status status;
    int id;

    public void createNewTask(String titulo, String descricao, String dataDeVencimento) throws IOException {
        JSONObject json = new JSONObject();

        Id idMethod = new Id();
        File idFile = new File("src/main/resources/data/id.json");
        String idString = new String(Files.readAllBytes(idFile.toPath()));
        JSONObject idObject = new JSONObject(idString);
        id = idObject.getInt("id");

        json.put("id", id);
        json.put("titulo", titulo);
        json.put("descricao", descricao);
        json.put("dataDeVencimento", dataDeVencimento);
        json.put("status", Status.PENDENTE.obterStatus());

        String tarefasJsonPath = "src/main/resources/data/tarefas.json";
        File tarefasJSON = new File(tarefasJsonPath);
        if (!tarefasJSON.exists()) {
            System.out.println("tarefas.json nao existe.");
            try {
                FileWriter file = new FileWriter(tarefasJsonPath);
                JSONArray jsonArray = new JSONArray();
                jsonArray.put(json);
                file.write(jsonArray.toString(6));
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else {
            System.out.println("tarefas.json existe.");
            String tarefasString = new String(Files.readAllBytes(tarefasJSON.toPath()));
            JSONArray jsonArray = new JSONArray(tarefasString);
            jsonArray.put(json);
            try {
                FileWriter file = new FileWriter(tarefasJsonPath);
                file.write(jsonArray.toString(6));
                file.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
