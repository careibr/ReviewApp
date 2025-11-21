import java.util.ArrayList;

public class QuestionBank {
    private ArrayList<Questions> questions;

    public QuestionBank(){

        questions = new ArrayList<Questions>();
        loadQuestions();
    }

    private void loadQuestions(){

        // ARRAYS (3 questions)
        questions.add(new Questions("What is the first element is a java Array?",
                new String[]{"0", "1,", "-1", "It Depends"}, 0, "arrays",
                "Java arrays are zero-based, so the first index is 0"));

        questions.add(new Questions("What does the length field of an array represent?",
                new String[]{"The last index in the array", "The number of elements in the array", "The size of memory in bytes", "How many elements are currently used"}, 1, "arrays",
                "For a Java array, length gives the total number of elements it can hold."));

        questions.add(new Questions("Which of the following correctly declares an int array of size 10?",
                new String[]{
                        "int[] nums = new int[10];",
                        "int nums = new int(10);",
                        "int[10] nums;",
                        "array int nums = 10;"
                }, 0, "arrays",
                "The correct syntax is int[] nums = new int[10]; to create an array of 10 ints."));

        // LOOPS (3 questions)
        questions.add(new Questions("Which loop is best when you know exactly how many times you want to repeat something?",
                new String[]{"for loop", "while loop", "do-while loop", "enhanced for loop"}, 0, "loops",
                "A for loop is typically used when you know the number of iterations in advance."));

        questions.add(new Questions("What is the main difference between a while loop and a do-while loop?",
                new String[]{
                        "while always runs once, do-while might not run",
                        "do-while always runs at least once, while might not run at all",
                        "They are exactly the same",
                        "do-while can only count down"
                }, 1, "loops",
                "A do-while loop checks the condition after running the body, so it runs at least once."));

        questions.add(new Questions("What is the typical purpose of i++ in a for loop like for (int i = 0; i < 10; i++)?",
                new String[]{
                        "To reset i to 0",
                        "To decrease i each time",
                        "To increase i so the loop eventually stops",
                        "To check the loop condition"
                }, 2, "loops",
                "i++ increments the loop variable so that eventually the condition becomes false and the loop ends."));

        // CONDITIONALS (3 questions)
        questions.add(new Questions("Which keyword is used to provide an alternative when an if condition is false?",
                new String[]{"switch", "else", "case", "break"}, 1, "conditionals",
                "The else keyword lets you run code when the if condition is false."));

        questions.add(new Questions("What type does a condition inside an if statement need to be in Java?",
                new String[]{"int", "String", "boolean", "double"}, 2, "conditionals",
                "An if statement requires a boolean expression that is either true or false."));

        questions.add(new Questions("Which is the best construct to test several related conditions, one after another?",
                new String[]{
                        "Multiple separate if statements",
                        "if, else if, else chain",
                        "Only a while loop",
                        "A single switch with no cases"
                }, 1, "conditionals",
                "An if, else if, else chain cleanly handles multiple related conditions."));

        // ARRAYLISTS (3 questions)
        questions.add(new Questions("Which import is needed to use ArrayList in Java?",
                new String[]{
                        "import java.util.List;",
                        "import java.util.ArrayList;",
                        "import java.arraylist.*;",
                        "No import is needed"
                }, 1, "arraylists",
                "ArrayList is in the java.util package, so you import java.util.ArrayList."));

        questions.add(new Questions("Which method adds an element to an ArrayList?",
                new String[]{"insert()", "push()", "add()", "append()"}, 2, "arraylists",
                "The add() method is used to insert a new element into an ArrayList."));

        questions.add(new Questions("How do you get the number of elements in an ArrayList called list?",
                new String[]{
                        "list.length",
                        "list.size()",
                        "list.count()",
                        "list.getLength()"
                }, 1, "arraylists",
                "ArrayList uses the size() method to return how many elements it currently holds."));

        // CLASSES (3 questions)
        questions.add(new Questions("What is an object in Java?",
                new String[]{
                        "A primitive data type",
                        "A variable that stores only numbers",
                        "An instance of a class",
                        "Another name for a method"
                }, 2, "classes",
                "An object is a specific instance of a class with its own data and behavior."));

        questions.add(new Questions("What is the purpose of a constructor in a class?",
                new String[]{
                        "To destroy objects",
                        "To initialize a new object",
                        "To print data",
                        "To store static methods"
                }, 1, "classes",
                "A constructor runs when you create a new object and is used to initialize its fields."));

        questions.add(new Questions("What are fields (also called instance variables) in a class?",
                new String[]{
                        "Methods that belong to the class",
                        "Variables that store the state of an object",
                        "Loops inside a class",
                        "Comments describing the class"
                }, 1, "classes",
                "Fields are variables that hold the data or state for each object of the class."));
    }

    public ArrayList<Questions> getQuestionByTopic(String topic){

        ArrayList<Questions> result = new ArrayList<Questions>();
        for (Questions q : questions){
            if(topic.equals("all") || q.getTopic().equalsIgnoreCase(topic)){
                result.add(q);
            }
        }
        return result;
    }
}
