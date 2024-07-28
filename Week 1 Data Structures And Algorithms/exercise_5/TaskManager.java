package exercise_5;

class Node {
    Task data;
    Node next;

    public Node(Task data) {
        this.data = data;
        this.next = null;
    }
}

class TaskManager {
    private Node head;

    public TaskManager() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.data.taskId == taskId) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteTask(int taskId) {
        Node current = head;
        Node previous = null;
        while (current != null && current.data.taskId != taskId) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return; 
        }
        if (previous == null) {
            head = current.next;
        } else {
            previous.next = current.next;
        }
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println("Task ID: " + current.data.taskId + ", Task Name: " + current.data.taskName + ", Status: " + current.data.status);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task(1, "Task 1", "Incomplete");
        Task task2 = new Task(2, "Task 2", "Incomplete");
        Task task3 = new Task(3, "Task 3", "Complete");

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        System.out.println("Traversing tasks:");
        taskManager.traverseTasks();

        System.out.println("Searching for task with ID 2:");   // FOR TESTING PURPOSE
        Task foundTask = taskManager.searchTask(2);
        if (foundTask != null) {
            System.out.println("Found Task ID: " + foundTask.taskId + ", Task Name: " + foundTask.taskName + ", Status: " + foundTask.status);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("Deleting task with ID 2.");			// FOR TESTING PURPOSE
        taskManager.deleteTask(2);

        System.out.println("Traversing tasks after deletion:");
        taskManager.traverseTasks();
    }
}
