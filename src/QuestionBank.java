import java.util.ArrayList;

public class QuestionBank {

    private ArrayList<Questions> questions;

    public QuestionBank() {
        questions = new ArrayList<Questions>();
        loadQuestions();
    }

    /**
     * Fills the questions list with all questions.
     * Assumes class Questions has a constructor:
     * Questions(String text, String[] choices, int correctIndex, String topic, String explanation)
     */
    private void loadQuestions() {

        // =====================
        // Arrays
        // =====================
        questions.add(new Questions(
                "What is the first element in a Java array?",
                new String[]{"0", "1", "-1", "It depends"},
                0,
                "arrays",
                "Java arrays are zero-based, so the first index is 0."
        ));

        questions.add(new Questions(
                "Which of the following correctly creates an int array of length 10?",
                new String[]{
                        "int[] nums = new int[10];",
                        "int nums = new int[10];",
                        "int[10] nums = new int[];",
                        "int nums[10] = new int[];"
                },
                0,
                "arrays",
                "Use the syntax: int[] name = new int[length];"
        ));

        questions.add(new Questions(
                "What is the length of the array 'int[] a = {3, 5, 7, 9};'?",
                new String[]{"3", "4", "5", "It cannot be determined"},
                1,
                "arrays",
                "The array has four elements, so a.length is 4."
        ));

        questions.add(new Questions(
                "How do you access the last element of an array 'arr'?",
                new String[]{
                        "arr[arr.length]",
                        "arr[arr.length - 1]",
                        "arr[-1]",
                        "arr.last()"
                },
                1,
                "arrays",
                "The last valid index is length - 1 in Java."
        ));

        questions.add(new Questions(
                "What happens if you try to access arr[10] in an array of length 5?",
                new String[]{
                        "It returns 0",
                        "It returns null",
                        "It throws an ArrayIndexOutOfBoundsException",
                        "It wraps around to the beginning"
                },
                2,
                "arrays",
                "Accessing an invalid index at runtime throws ArrayIndexOutOfBoundsException."
        ));


        // =====================
        // Loops
        // =====================
        questions.add(new Questions(
                "Which loop is best when you know exactly how many times to repeat?",
                new String[]{"for loop", "while loop", "do-while loop", "enhanced for loop"},
                0,
                "loops",
                "A traditional for loop is best when you know the exact number of iterations."
        ));

        questions.add(new Questions(
                "What does the following code print?\n\nfor (int i = 0; i < 3; i++) {\n    System.out.print(i + \" \");\n}",
                new String[]{"0 1 2", "1 2 3", "0 1 2 3", "0 2"},
                0,
                "loops",
                "The loop starts at 0 and runs while i < 3, printing 0, 1, and 2."
        ));

        questions.add(new Questions(
                "When does the condition of a while loop get checked?",
                new String[]{
                        "Before each iteration",
                        "After each iteration",
                        "Only once at the beginning",
                        "Only once at the end"
                },
                0,
                "loops",
                "A while loop checks its condition before each iteration."
        ));

        questions.add(new Questions(
                "Which loop guarantees the body executes at least once?",
                new String[]{"for loop", "while loop", "do-while loop", "enhanced for loop"},
                2,
                "loops",
                "A do-while loop runs the body first, then checks the condition."
        ));

        questions.add(new Questions(
                "What does 'break' do inside a loop?",
                new String[]{
                        "Skips the current iteration",
                        "Stops the loop entirely",
                        "Restarts the loop",
                        "Has no effect in loops"
                },
                1,
                "loops",
                "The break statement exits the loop immediately."
        ));


        // =====================
        // Conditionals
        // =====================
        questions.add(new Questions(
                "Which keyword is used for an alternative condition when the first if is false?",
                new String[]{"else if", "otherwise", "switch", "case"},
                0,
                "conditionals",
                "Use else if to provide another condition if the first if is false."
        ));

        questions.add(new Questions(
                "Which operator checks if two primitive values are equal?",
                new String[]{"=", "==", "!=", ".equals()"},
                1,
                "conditionals",
                "Use == to compare primitive values for equality."
        ));

        questions.add(new Questions(
                "What does this code print?\n\nint x = 5;\nif (x > 3 && x < 10) {\n    System.out.println(\"A\");\n} else {\n    System.out.println(\"B\");\n}",
                new String[]{"A", "B", "A B", "Nothing"},
                0,
                "conditionals",
                "x is 5, which is between 3 and 10, so it prints \"A\"."
        ));

        questions.add(new Questions(
                "Which is the correct syntax for an if statement?",
                new String[]{
                        "if x > 3 { }",
                        "if (x > 3) { }",
                        "if (x > 3); { }",
                        "if x > 3 then { }"
                },
                1,
                "conditionals",
                "In Java, the condition must be in parentheses: if (condition) { }"
        ));

        questions.add(new Questions(
                "Which logical operator represents OR in Java?",
                new String[]{"&&", "||", "!", "&"},
                1,
                "conditionals",
                "The || operator is the logical OR in Java."
        ));


        // =====================
        // ArrayLists
        // =====================
        questions.add(new Questions(
                "Which import is required to use ArrayList?",
                new String[]{
                        "import java.util.ArrayList;",
                        "import java.ArrayList;",
                        "import java.list.ArrayList;",
                        "No import is needed"
                },
                0,
                "arraylists",
                "ArrayList is in the java.util package."
        ));

        questions.add(new Questions(
                "Which correctly creates an ArrayList of Strings called names?",
                new String[]{
                        "ArrayList<String> names = new ArrayList<String>();",
                        "ArrayList names = new ArrayList<String>();",
                        "String[] names = new ArrayList<String>();",
                        "new ArrayList<String> names = ArrayList();"
                },
                0,
                "arraylists",
                "The standard generic syntax is ArrayList<String> names = new ArrayList<String>();"
        ));

        questions.add(new Questions(
                "How do you add an element \"Bob\" to an ArrayList<String> names?",
                new String[]{
                        "names.add(\"Bob\");",
                        "names[0] = \"Bob\";",
                        "add(names, \"Bob\");",
                        "names.insert(\"Bob\");"
                },
                0,
                "arraylists",
                "Use the add method to add an element to an ArrayList."
        ));

        questions.add(new Questions(
                "How do you get the number of elements in an ArrayList?",
                new String[]{
                        "names.length",
                        "names.size()",
                        "names.count()",
                        "names.length()"
                },
                1,
                "arraylists",
                "ArrayList uses the size() method to report its number of elements."
        ));

        questions.add(new Questions(
                "What happens if you do names.get(10) on an ArrayList with only 3 elements?",
                new String[]{
                        "It returns null",
                        "It returns an empty string",
                        "It throws an IndexOutOfBoundsException",
                        "It wraps around to the first element"
                },
                2,
                "arraylists",
                "Accessing an invalid index in an ArrayList throws IndexOutOfBoundsException."
        ));


        // =====================
        // Classes
        // =====================
        questions.add(new Questions(
                "What keyword is used to define a new class in Java?",
                new String[]{"object", "class", "public", "new"},
                1,
                "classes",
                "Use the class keyword to define a new class."
        ));

        questions.add(new Questions(
                "What is a constructor?",
                new String[]{
                        "A method that returns the class name",
                        "A special method that initializes new objects",
                        "A variable that stores object data",
                        "Any method that is public"
                },
                1,
                "classes",
                "A constructor is a special method used to initialize new objects."
        ));

        questions.add(new Questions(
                "How do you create a new object of class Dog?",
                new String[]{
                        "Dog d = Dog.new();",
                        "Dog d = new Dog();",
                        "new Dog = d();",
                        "Dog d();"
                },
                1,
                "classes",
                "Use the new keyword followed by the constructor: new Dog()."
        ));

        questions.add(new Questions(
                "What is 'this' used for inside a class?",
                new String[]{
                        "To refer to the current object",
                        "To refer to the superclass",
                        "To refer to a static method",
                        "To import another class"
                },
                0,
                "classes",
                "this refers to the current object instance."
        ));

        questions.add(new Questions(
                "What is the return type of a constructor?",
                new String[]{
                        "void",
                        "int",
                        "The class type",
                        "Constructors have no return type"
                },
                3,
                "classes",
                "Constructors do not declare a return type, not even void."
        ));


        // =====================
        // All topics (mixed review)
        // =====================
        questions.add(new Questions(
                "Which loop is best suited for iterating over all elements of an ArrayList<String> names?",
                new String[]{
                        "for (int i = 0; i < names.length; i++)",
                        "for (String n : names)",
                        "while (i < names.size())",
                        "do { ... } while (i < names.size())"
                },
                1,
                "all",
                "The enhanced for loop is ideal for visiting each element in a collection."
        ));

        questions.add(new Questions(
                "Which of the following correctly combines conditionals and arrays?\n\nint[] a = {1, 2, 3};\nif (a[0] == 1) {\n    System.out.println(\"Yes\");\n}",
                new String[]{
                        "Valid code",
                        "Invalid: arrays can't be used in if statements",
                        "Invalid: a[0] must be a boolean",
                        "Invalid syntax for array creation"
                },
                0,
                "all",
                "You can compare a[0] to a value in an if statement; this is valid."
        ));

        questions.add(new Questions(
                "Which line correctly declares an ArrayList of Dog objects inside a class?",
                new String[]{
                        "ArrayList<Dog> dogs = new ArrayList<Dog>();",
                        "Dog<ArrayList> dogs = new ArrayList<Dog>();",
                        "ArrayList dogs = new Dog<Dog>();",
                        "Dog[] dogs = new ArrayList<Dog>();"
                },
                0,
                "all",
                "Use generics with the class type: ArrayList<Dog> dogs = new ArrayList<Dog>();"
        ));

        questions.add(new Questions(
                "You want to repeat some code while a condition is true AND also check elements in an array. Which two topics are you combining?",
                new String[]{
                        "Classes and ArrayLists",
                        "Conditionals and Loops",
                        "Arrays and Inheritance",
                        "Methods and Packages"
                },
                1,
                "all",
                "Using a loop with a condition combines loops and conditionals."
        ));

        questions.add(new Questions(
                "Which of these is the best description of an ArrayList compared to an array?",
                new String[]{
                        "ArrayLists have fixed size, arrays can grow",
                        "Arrays and ArrayLists are identical",
                        "ArrayLists can grow and shrink, arrays have fixed size",
                        "Only arrays can store objects"
                },
                2,
                "all",
                "ArrayLists are resizable, while arrays have a fixed length."
        ));
    }

    /**
     * Returns all questions whose topic matches the given topic (case-insensitive).
     * If topic is "all", returns every question.
     */
    public ArrayList<Questions> getQuestionByTopic(String topic) {
        ArrayList<Questions> result = new ArrayList<Questions>();

        for (Questions q : questions) {
            if ("all".equalsIgnoreCase(topic) ||
                    q.getTopic().equalsIgnoreCase(topic)) {
                result.add(q);
            }
        }

        return result;
    }

    // Optional alias, in case other code calls the plural name
    public ArrayList<Questions> getQuestionsByTopic(String topic) {
        return getQuestionByTopic(topic);
    }
}

