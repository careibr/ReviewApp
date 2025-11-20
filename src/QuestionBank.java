import java.util.ArrayList;
public class QuestionBank {
    private ArrayList<Questions> questions;

    public QuestionBank()
    {
        questions = new ArrayList<Questions>();
        loadQuestions();
    }

    private void loadQuestions()
    {

        questions.add(new Questions("What is the first element in a Java array?",
                new String[]{"0","1","-1","It depends"},0,"arrays",
                "Java arrays are zero-based, so the first index is 0"));

    }

    public ArrayList<Questions> getQuestionByTopic(String topic)
    {
        ArrayList<Questions> result = new ArrayList<Questions>();
        for(Questions q : questions)
        {
            if(topic.equals("all") || )
        }

    }



}
