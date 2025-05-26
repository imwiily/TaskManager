package model;

import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Id {
    int id;
    public Id() throws IOException {
        JSONObject json = new JSONObject();

        String path = "src/main/resources/data/id.json";
        File file = new File(path);
        if (!file.exists()) {
            FileWriter fileWriter = new FileWriter(path);
            System.out.println("Arquivo id.json nao existe. Criando arquivo...");
            id = 1;
            json.put("id", id);
            try {
                fileWriter.write(json.toString(4));
                fileWriter.close();
                System.out.println("Arquivo id.json, escrito com sucesso");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String idFile = new String(Files.readAllBytes(file.toPath()));
            JSONObject jsonID = new JSONObject(idFile);
            id = jsonID.getInt("id");
            id++;
            jsonID.put("id", id);
            FileWriter fileWriter = new FileWriter(path);
            try {
                fileWriter.write(jsonID.toString(4));
                fileWriter.close();
                System.out.println("Arquivo id.json, escrito com sucesso");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
