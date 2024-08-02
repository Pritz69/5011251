package exercise_10_MVCPatternExample;

public class MVCPatternTest {
 public static void main(String[] args) {
     
     Student model = new Student("1", "John Doe", "A");

     StudentView view = new StudentView();

     StudentController controller = new StudentController(model, view);


     // StudentController controller = new StudentController(new Student("1", "John Doe", "A"), view);
     controller.updateView();

     
     controller.setStudentName("Jane Doe");
     controller.setStudentGrade("A+");
       
     controller.updateView();
 }
}

/*

Benefits of the MVC Pattern

Separation of Concerns:

Separates the application into three interconnected components: Model (data), View (presentation), and Controller (business logic). This separation improves modularity and makes the application easier to manage and scale.

Ease of Maintenance:

Changes to the UI can be made without affecting the underlying business logic and data. Similarly, changes to the data structure or business logic do not impact the UI.

Reusability:

Components can be reused across different parts of the application. For example, the StudentView can be used to display student details in multiple places without duplication.

Testability:

The separation allows for easier unit testing of individual components. The model can be tested independently of the view and controller, and vice versa.

Flexibility:

Different views can be created for the same model, allowing for multiple representations of the same data without modifying the core business logic.


By doing this, you adhere more closely to the MVC principles, ensuring that the model is encapsulated and the client cannot directly manipulate it. This approach centralizes the control logic within the controller, making the application more modular, maintainable, and aligned with the MVC pattern.
*/