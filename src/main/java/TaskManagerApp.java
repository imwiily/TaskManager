import view.TaskViewer;

import java.io.IOException;

public class TaskManagerApp {
    public static void main(String[] args) throws IOException {
        TaskViewer viewer = new TaskViewer();
        viewer.mainMenu();
    }
}
