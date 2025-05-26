import view.TaskViewer;

import java.io.IOException;
import java.util.Scanner;

public class TaskManagerApp {
    public static void main(String[] args) throws IOException {
        TaskViewer viewer = new TaskViewer();
        Scanner scanner = new Scanner(System.in);

        viewer.mainMenu();

    }
}
