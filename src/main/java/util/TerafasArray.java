package util;

import model.Tarefa;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerafasArray {
    List<Tarefa> tarefaList = new ArrayList<>();

    public void JsonArray() throws IOException {
        // TODO: Monta o Array de tarefas
        String path = "src/main/resources/data/tarefas.json";
        File tarefas = new File(path);
        String tarefasJSONString = new String(Files.readAllBytes(tarefas.toPath()));
        JSONArray arrayTarefas = new JSONArray(tarefasJSONString);
        for (int i = 0; i < arrayTarefas.length(); i++) {
            JSONObject obj = arrayTarefas.getJSONObject(i);
            Tarefa tarefa = new Tarefa(
                    obj.getString("titulo"),
                    obj.getInt("id"),
                    obj.getString("dataDeVencimento"),
                    obj.getString("descricao"),
                    obj.getString("status")
            );
            tarefaList.add(tarefa);
        }
    }

    public Tarefa selectTarefas() throws IOException {
        // TODO: Mostra o array de tarefas
        Messages.sendMessage(" ");
        for (int i = 0; i < tarefaList.size(); i++) {
            System.out.println(
                    tarefaList.get(i)
            );
        }
        boolean result = false;
        while (!result) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Qual tarefa deseja escolher? ");
            int id = scanner.nextInt();
            Tarefa resultado = tarefaList.stream()
                    .filter(t -> t.getId() == id)
                    .findFirst()
                    .orElse(null);
            if (resultado != null) {
                result = true;
                return resultado;

            } else {
                System.out.println("Nenhuma tarefa encontrada com id " + id);
            }
        }
        return null;
    }
}
