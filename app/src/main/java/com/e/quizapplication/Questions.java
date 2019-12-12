package com.e.quizapplication;

public class Questions {
    public String mQuestions[] ={
            "Which is the first planet in the solar system",
            "Which is the second planet in the solar system",
            "Which is the third planet in the solar system",
            "Which is the fourth planet in the solar system",
            "Which is the fifth planet in the solar system",
            "Which is the sixth planet in the solar system",
            "Which is the seventh planet in the solar system",
            "Which is the eighth planet in the solar system",
            "Which is the nineth planet in the solar system",
            "Who is our current Prime Minister",
            "Who is our current Chief Minister in Rajasthan ",

    };
    private String mChoices[][]={
            {"Mercury","Venius","Mars","Saturn"},
            {"Jupiter","Venius","Earth","Neptune"},
            {"Earth","Jupiter","Pluto","Venius"},
            {"Jupiter","Saturn","Mars","Earth"},
            {"Jupiter","Pluto","Mercury","Earth"},
            {"Uranius","Venius","Mars","Saturn"},
            {"Saturn","Pluto","Uranius","Earth"},
            {"Venius","Neptune","Pluto","Mars"},
            {"Mercury","Venius","Mars","Pluto"},
            {"Mercury","Venius","Mars","Narender Modi"},
            {"Mercury","Venius","Ashok Gahlot","Pluto"},

    };
    private String mCorrectAnswers[]={"Mercury","Venius","Earth","Mars","Jupiter","Saturn","Uranius","Neptune","Pluto","Narender Modi","Ashok Gahlot"};

    public String getQuestion(int a){
        String question =mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice =mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice =mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice =mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a){
        String choice =mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer =mCorrectAnswers[a];
        return answer;
    }
}
