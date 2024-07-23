package QuizApplication;



public class QuizApplication
{
    public static void main(String[] args)
    {
        // Create Quiz object and add questions
        Quiz quiz = new Quiz();

        // Sample questions
        Question question1 = new Question("What is the capital of India",new String[]   {"0. New Delhi", "1. punjab", "2. Mumbai", "3. Bangalore"}, 0);
        Question question2 = new Question("Which language is used for styling web pages?",  new String[] {"0. HTML", "1. CSS", "2. Java", "3. Python"}, 1);
        Question question3 = new Question("In which year java was introduced ?", new String[] {"0. 1996", "1. 1998", "2. 1995", "3. 1994"}, 2);
        Question question4 = new Question("What is the default value of boolean in java?", new String[] {"0. True", "1. False", "2. Zero", "3. Null"}, 1);
        Question question5 = new Question("Who is the founder of java programming ?", new String[] {"0. James gosling", "1. Dennis Ritchie", "2. Bjarne Stroustrup", "3. Brendan Eich"}, 0);

        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);
        quiz.addQuestion(question4);
        quiz.addQuestion(question5);

        // Take quiz
        quiz.takeQuiz();
    }
}




