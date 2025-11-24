import java.util.ArrayList;
import java.util.Scanner;

public class ReviewAppRunner {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        QuestionBank bank = new QuestionBank();

        System.out.println("=== AP CSA Review App ===");

        boolean keepGoing = true;

        while(keepGoing)
        {
            String topic = showMenuAndGetTopic(in);
            ArrayList<Questions> quizQuestions = bank.getQuestionByTopic(topic);

            if(quizQuestions.isEmpty())
            {
                System.out.println("No questions available");
            }
            else
            {
                runQuiz(quizQuestions, in);
            }

            System.out.println("Go again? (y/n)");
            String again = in.nextLine();

            if(!again.equals("y"))
            {
                keepGoing = false;
            }

        }


    }

    private static String showMenuAndGetTopic(Scanner in)
    {
        System.out.println("""
                Choose a Topic:
                1.Arrays
                2.Loops
                3.Conditionals
                4.ArrayLists
                5.Classes
                6.All topics
                Enter 1-6""");

        int choice = in.nextInt();
        choice -= 1;

        String[] options = {"arrays", "loops", "conditionals","arraylists","classes", "all"};

        in.nextLine();
        return options[choice];

    }

    private static void runQuiz(ArrayList<Questions> questions, Scanner in)
    {
        int score = 0;

        for(Questions q: questions)
        {
            System.out.println("Topic: " + q.getTopic());
            System.out.println(q.getPrompt());

            String[] choices = q.getChoices();
            for(int i = 1; i<=choices.length; i++)
            {
                System.out.println(i + ". " + choices[i-1]);
            }

            System.out.println("Choose your answer");
            int answer = in.nextInt();
            answer -= 1;

            if(answer >= 0 && answer < choices.length && q.isCorrect(answer))
            {
                System.out.println("Correct!");
                score++;
            }
            else
            {
                System.out.println("Incorrect");
            }

            System.out.println("Explanation: " + q.getExplanation());

        }

        System.out.println("Score : " + score + "/" + questions.size());

    }
}
