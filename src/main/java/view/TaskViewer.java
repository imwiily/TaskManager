package view;

import model.Status;
import model.Tarefa;
import model.TaskManager;
import util.TerafasArray;

import java.io.IOException;
import java.util.Scanner;

import static util.Messages.sendMessage;

public class TaskViewer {
    String mainMenu = """
                ╔═══════════════════╣ Task Manager ╠════════════════════╗
                ║    Escolha a opção que você deseja:                   ║
                ║    [1] Adicionar tarefa;                              ║
                ║    [2] Visualizar lista de tarefas;                   ║
                ║    [3] Remover tarefa;                                ║
                ║                                                       ║
                ╚════════════════════╣ Task Manager ╠═══════════════════╝
                """;
    String edit = """
                ╔═══════════════════╣ Task Manager ╠════════════════════╗
                ║    Escolha a opção que você deseja:                   ║
                ║    [1] Editar título;                                 ║
                ║    [2] Editar Status;                                 ║
                ║    [3] Editar descrição;                              ║
                ║    [4] Editar data de vencimento;                     ║
                ║    [5] Sair do editor;                                ║
                ║                                                       ║
                ╚════════════════════╣ Task Manager ╠═══════════════════╝
                """;
    String addTask = """
                ╔═══════════════════╣ Task Manager ╠════════════════════╗
                ║    Responda as questões abaixo:                       ║
                ║    Nota: Para cade resposta, aperte enter.            ║
                ║    [1] Título da tarefa;                              ║
                ║    [2] Descrição da tarefa;                           ║
                ║    [3] Data de vencimento da tarefa;                  ║
                ║                                                       ║
                ╚════════════════════╣ Task Manager ╠═══════════════════╝
                """;
    String oldEdit = """
                        ╔════════════════════════════════════╗
                        ║ 📌 Tarefa #%d
                        ╠════════════════════════════════════╣
                        ║ %s: %s
                        ╚════════════════════════════════════╝
                        """;

    int idSelected;
    public void mainMenu() throws IOException {
        Scanner leitor = new Scanner(System.in);
        sendMessage(mainMenu);
        int option = leitor.nextInt();
        switch (option) {
            case 1 ->addTask();
            case 2 -> listAndEdit();
            default -> System.out.println("Opção inválida");
        }

    }

    public void addTask() throws IOException {
        Scanner leitor = new Scanner(System.in);
        String anotherOne = "Deseja criar mais uma tarefa? [S/N] ";
        String continuar = "s";
        while(continuar.equalsIgnoreCase("s")) {
            sendMessage(addTask);
            System.out.print("[1] ");
            String titulo = leitor.nextLine();
            System.out.print("[2] ");
            String descricao = leitor.nextLine();
            System.out.print("[3] ");
            String dataDeVencimento = leitor.nextLine();
            TaskManager tarefa = new TaskManager();
            tarefa.createNewTask(titulo, descricao, dataDeVencimento);
            while(true) {
                System.out.print(anotherOne);
                continuar = leitor.nextLine();
                if (continuar.length() > 1) {
                    System.out.println("Palavra nao reconhecida.");
                } else if (continuar.equalsIgnoreCase("n") || continuar.equalsIgnoreCase("s")) {
                    break;
                }
            }
            mainMenu();
        }
    }

    public void listAndEdit() throws IOException {
        TerafasArray array = new TerafasArray();
        array.JsonArray();
        Tarefa tarefa = array.selectTarefas();

        sendMessage("Tarefa escolhida: \n" + tarefa.toString());
        System.out.println(edit);

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            // Edição do título
            case 1 -> {
                sendMessage(String.format(oldEdit, tarefa.getId(),"📝 Título", tarefa.getTitulo()));
                System.out.print("Qua o novo título que você deseja? ");
                Scanner internal = new Scanner(System.in);
                String newTitle = internal.nextLine();
                tarefa.setTitulo(newTitle, tarefa.getId());
                listAndEdit();
            }
            // Edição do Status
            case 2 -> {
                sendMessage(String.format(oldEdit, tarefa.getId(), "📍 Status" , tarefa.getStatus()));
                System.out.println("Qua o novo status que você deseja? ");
                System.out.println(" [Pendente] [Em andamento] [Concluido] ");
                Scanner internal = new Scanner(System.in);
                String newStatus = internal.nextLine();
                switch (newStatus.toLowerCase()) {
                    case "pendente" -> tarefa.setStatus(Status.PENDENTE, tarefa.getId());
                    case "em andamento"-> tarefa.setStatus(Status.EM_ANDAMENTO, tarefa.getId());
                    case "concluido" -> tarefa.setStatus(Status.CONCLUIDO, tarefa.getId());
                    default -> {
                        System.out.println("Valor nao reconhecido");
                        listAndEdit();
                    }
                }
                listAndEdit();
            }
            // Edição da descrição
            case 3 -> {
                Scanner internal = new Scanner(System.in);
                sendMessage(String.format(oldEdit, tarefa.getId(), "📃 Descrição" ,tarefa.getStatus()));
                System.out.println("Qual a nova descrição que você deseja? ");
                String newDesc = internal.nextLine();
                tarefa.setDescricao(newDesc, tarefa.getId());
                listAndEdit();
            }
            // Edição da data de vencimento
            case 4 -> {
                Scanner internal = new Scanner(System.in);
                sendMessage(String.format(oldEdit, tarefa.getId(), "🗓️ Vencimento" ,tarefa.getStatus()));
                System.out.println("Qual a data de vencimento? ");
                String newData = internal.nextLine();
                tarefa.setDescricao(newData, tarefa.getId());
                listAndEdit();
            }
            // Sair do editor
            case 5 -> mainMenu();

        }
    }


}
