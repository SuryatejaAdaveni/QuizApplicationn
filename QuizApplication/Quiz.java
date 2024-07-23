package QuizApplication;



import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Quiz
{
    public List<Question> questions;
    public int score;
    public Quiz()
    {
        questions = new ArrayList<>();
        score=0;
    }
    public void addQuestion(Question question)
    {
        questions.add(question);
    }
    public Question getGetQuestion(int index)
    {
        return questions.get(index);
    }
    public int getNumberOfQuestions()
    {
        return questions.size();
    }
    public void takeQuiz()
    {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questions.size(); i++)
        {
            Question currentQuestion = questions.get(i);
            displayQuestion(currentQuestion, i + 1);
            int userAnswer = getUserAnswer(scanner, currentQuestion);
            checkAnswer(currentQuestion, userAnswer);
        }
        scanner.close();
        displayFinalScore();
    }
    private void displayQuestion(Question question, int questionNumber)
    {
        System.out.println("Question " + questionNumber + ": " + question.getQuestionText());
        String[] options = question.getOptions();
        for (int i = 0; i <options.length; i++)
        {
            System.out.println(options[i]);
        }
        System.out.print("Enter Your option in Number format: ");
    }

    private int getUserAnswer(Scanner scanner, Question question)
    {
        int userAnswer = -1;
        while (userAnswer < 0 || userAnswer >= question.getOptions().length)
        {
            try
            {
                userAnswer = Integer.parseInt(scanner.nextLine());
                if (userAnswer < 0 || userAnswer >= question.getOptions().length)
                {
                    System.out.println("Please enter a valid option number.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return userAnswer;
    }

    private void checkAnswer(Question question, int userAnswer)
    {
        if (userAnswer == question.getCorrectAnswerIndex())
        {
            score++;
            System.out.println("Correct!\n");
            System.out.println("Your choosed answer is right.");
        }
        else
        {
            // Display the correct answer based on correctAnswerIndex
            int correctAnswerIndex = question.getCorrectAnswerIndex();
            String correctAnswer = question.getOptions()[correctAnswerIndex];
            System.out.println("Incorrect. The correct answer is: " + correctAnswer + "\n");
        }
    }

    private void displayFinalScore()
    {
        System.out.println("Quiz ended. Your score is: " + score + " out of " + questions.size());
        System.out.println("Try again if you want.");
    }
}
