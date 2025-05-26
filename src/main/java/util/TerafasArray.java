package util;

import model.Tarefa;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerafasArray {
    List<Tarefa> tarefaList = new ArrayList<>();

    public void JsonArray() throws IOException {
        // Monta o Array de tarefas
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

    public Tarefa selectTarefas() {
        // Mostra o array de tarefas
        Messages.sendMessage(" ");
        for (Tarefa tarefa : tarefaList) {
            System.out.println(
                    tarefa
            );
        }
        System.out.println("Deseja editar/remover alguma tarefa? [S/N]");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        if (option.equalsIgnoreCase("s")) {
            boolean result = false;
            Scanner internal = new Scanner(System.in);
            while (!result) {
                System.out.println("Qual tarefa deseja escolher? ");
                int id = internal.nextInt();
                Tarefa tarefa = tarefaList.stream()
                        .filter(t -> t.getId() == id)
                        .findFirst()
                        .orElse(null);
                if (tarefa != null) {
                    return tarefa;
                } else {
                    System.out.println("Nenhuma tarefa encontrada com id " + id);
                }
            }
            return null;
        }
        return null;
    }

    public void deleteTarefa(int id) throws IOException {
        String path = "src/main/resources/data/tarefas.json";
        Path path1 = Path.of(path);
        String json = Files.readString(path1);
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            if (obj.getInt("id") == id) { // Essa parte aqui.
                array.remove(i);
            }
        }
        Files.writeString(path1, array.toString(2));
    }
}
