import java.util.ArrayList;

public class QuestionBank {

    private ArrayList<Questions> questions;

    public QuestionBank(){
        questions = new ArrayList<Questions>();
        loadQuestions();
    }

    private void loadQuestions()
    {
        questions.add(new Questions("What is the first element in a Java array?",
                new String[]{"0", "1", "-1", "it depends"}, 0,
                "arrays", "arrays start counting the index from 0" ));

        questions.add(new Questions(
                "What value is printed by the following code?\nint[] nums = {4, 7, 2, 9, 5};" +
                        "\nSystem.out.println(nums[nums.length - 2]);",
                new String[]{"7", "2", "9", "5"}, 2,
                "arrays", "nums.length - 2 is 5 - 2 = 3, so nums[3] = 9."));
        questions.add(new Questions(
                "Which loop correctly prints every element of an array arr?",
                new String[]{
                        "for(int i = 0; i <= arr.length; i++) System.out.println(arr[i]);",
                        "for(int i = 1; i < arr.length; i++) System.out.println(arr[i]);",
                        "for(int i = 0; i < arr.length; i++) System.out.println(arr[i]);",
                        "for(int i = 0; i < arr.length - 1; i++) System.out.println(arr[i]);"
                },
                2,
                "arrays",
                "Arrays are traversed from index 0 to arr.length - 1."
        ));

        questions.add(new Questions(
                "What does the following loop print?\nint count = 0;\nfor(int i = 1; i < 10; i += 3) count++;\nSystem.out.println(count);",
                new String[]{"2", "3", "4", "9"},
                2,
                "loops",
                "Values of i are 1, 4, 7 → 3 iterations, so count = 3."
        ));

       questions.add(new Questions(
                "What value is printed by the code?\nint x = 12;\nwhile(x > 0) { x -= 5; }\nSystem.out.println(x);",
                new String[]{"-3", "-2", "2", "0"},
                0,
                "loops",
                "x goes 12 → 7 → 2 → -3 and exits the loop, printing -3."
        ));

        questions.add(new Questions(
                "What is the result of the expression?\nboolean a = true;\nboolean b = false;\nboolean c = true;\nSystem.out.println(a && !b || !c);",
                new String[]{"true", "false", "Compilation error", "Nothing prints"},
                0,
                "conditionals",
                "a && !b is true, and true || false is true."
        ));

        questions.add(new Questions(
                "What is printed by the following code?\nint x = 8;\nif(x > 10) System.out.println(\"A\");\nelse if(x > 5) System.out.println(\"B\");\nelse System.out.println(\"C\");",
                new String[]{"A", "B", "C", "Nothing"},
                1,
                "conditionals",
                "x > 5 is true, so 'B' is printed."
        ));
        questions.add(new Questions(
                "What is printed by the following code?\nArrayList<String> list = new ArrayList<>();\nlist.add(\"A\"); list.add(\"B\"); list.add(1, \"C\");\nSystem.out.println(list);",
                new String[]{"[A, B, C]", "[A, C, B]", "[C, A, B]", "Error"},
                1,
                "arrayLists",
                "Adding at index 1 inserts C between A and B."
        ));

        questions.add(new Questions(
                "What value is printed?\nArrayList<Integer> nums = new ArrayList<>();\nnums.add(10); nums.add(20); nums.add(30);\nnums.remove(1);\nSystem.out.println(nums.get(1));",
                new String[]{"10", "20", "30", "Error"},
                2,
                "arrayLists",
                "After removing index 1 (value 20), index 1 now holds 30."
        ));

        questions.add(new Questions(
                "What does the following code print?\nDog d = new Dog(\"Rex\", 3);\nSystem.out.println(d.getName());",
                new String[]{"Rex", "3", "null", "name"},
                0,
                "classes",
                "getName() returns the value of the name field, which is 'Rex'."
        ));

        questions.add(new Questions(
                "Which statement about instance variables is true?",
                new String[]{
                        "They must be declared inside a method.",
                        "They can only be modified inside constructors.",
                        "They are declared inside a class but outside methods.",
                        "They must be public."
                },
                2,
                "classes",
                "Instance variables belong to the object and are declared in the class body."
        ));

    }

    public ArrayList<Questions> getQuestionsByTopic(String topic)
    {
        ArrayList<Questions> result;
        result = new ArrayList<Questions>();

        for(Questions q: questions){

            if(topic.equals("all") || q.getTopic().equalsIgnoreCase(topic))
            {
                result.add(q);
            }

        }

        return result;
    }
}
