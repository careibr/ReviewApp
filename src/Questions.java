public class Questions {

    private String prompt;
    private String[] choices;
    private int correctIndex;
    private String topic;
    private String explanation;

    public Questions(String prompt, String[] choices, int correctIndex,
                     String topic, String explanation)
    {
        this.prompt = prompt;
        this.choices = choices;
        this.correctIndex = correctIndex;
        this.topic = topic;
        this.explanation = explanation;
    }

    public String getPrompt(){
        return prompt;
    }

    public String[] getChoices(){
        return choices;
    }

    public String getTopic(){
        return topic;
    }

    public String getExplanation(){
        return explanation;
    }

    public boolean isCorrect(int userIndex)
    {
        return userIndex == correctIndex;
    }


}
