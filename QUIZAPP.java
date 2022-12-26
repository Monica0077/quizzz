

/**
 *
 * @author MONICA S
 */
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;




public class QUIZAPP {

    public static void main(String[] args) throws IOException{

        /*
        //We are telling the scanner class to read the input from input stream
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a character");
        char singleChar = scan.next().charAt(0);
        System.out.println(singleChar);
         */
        Scanner s=new Scanner(System.in);
        System.out.println("1.Start the Quiz");
        System.out.println("2.Show previous Score");
       // System.out.println("3.Take the Quiz again");
        System.out.println("3.Exit");
        char ch=s.next().charAt(0);
        switch(ch)
                {
                    case '1':
                    {Quiz quiz = new Quiz();
                    quiz.begin();
                    }
                    case '2':
                        //showw s=new showw();
                      //  s.scoree();
                    case '3':
                        System.exit(0);
                    
                    
                }
        

    }

    private static void Switch(int ch) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class Quiz extends Thread
{
    int score;
    int scoree[]=new int[5];
    void begin ()throws IOException
    {
        Question[] questions = new Question[5];

        questions[0] = new Question("Which of the below is valid way to instantiate an array in java?","int myArray [] = {1, 3, 5};","int myArray [] [] = {1,2,3,4};","int [] myArray = (5, 4, 3);","int [] myArray = {“1”, “2”, “3”};", new Answer("int [] myArray = {“1”, “2”, “3”};"));
        questions[1] = new Question("Which of the below are reserved keyword in Java?"," array","goto","null","into", new Answer("goto"));
        questions[2] = new Question("What are the valid statements for static keyword in Java?","We can have static block in a class.","The static block in a class is executed every time an object of class is created.","We cannot have static method implementations in interface.","We can define static block inside a method.", new Answer("We can have static block in a class."));
        questions[3] = new Question("Which of the following statements are true for inheritance in Java?","The “extend” keyword is used to extend a class in java.","You can extend multiple classes in java.","Private members of the superclass are accessible to the subclass","We can’t extend Final classes in java.", new Answer("We can’t extend Final classes in java."));
        questions[4] = new Question(" Which of the below are not unchecked exceptions in java?","RuntimeException","ClassCastException","NullPointerException","IOException", new Answer("IOException"));

        int countTotal = 0;
        int countRight = 0;
        int countWrong = 0;

        for(Question q: questions)
        {
            System.out.println(q.getQuestion());
            System.out.println("A : " +q.getOption1());
            System.out.println("B : " +q.getOption2());
            System.out.println("C : " +q.getOption3());
            System.out.println("D : " +q.getOption4());

            String answer = "";

            char ans;
            System.out.println("Enter your answer");
            Scanner scan = new Scanner(System.in);
            ans = scan.next().charAt(0);
            Thread t=new Thread();
            try{
            t.sleep(100);
            }catch(Exception e)
            {
                System.out.println("thread is sleeping");
            }

            switch(ans)
            {
                case 'A':
                    answer = q.getOption1();
                    break;
                case 'B':
                    answer = q.getOption2();
                    break;
                case 'C':
                    answer = q.getOption3();
                    break;
                case 'D':
                    answer = q.getOption4();
                    break;
                default:break;
            }
            System.out.println("Your answer " + answer + " " + q.getAnswer());
            if(answer.equals(q.getAnswer().getAnswer()))
            {
                System.out.println("------------------------------------------------------");
                System.out.println("                  Correct Answer                      ");
                System.out.println("------------------------------------------------------");
                countRight++;
            }
            else
            {
                System.out.println("------------------------------------------------------");
                System.out.println("                  Wrong Answer                      ");
                System.out.println("------------------------------------------------------");
                countWrong++;
            }
            System.out.println("============================================================================================");
            countTotal++;
        }

        Result result = new Result(countTotal,countRight,countWrong);
        this.score=countRight;
        scoree[0]=countRight;
        
        result.showResult();
        
    }
}
class showscoree extends Quiz
{
    int score;
    
    
   // System.out.println("previous score is:"+scoree[0]);
}

class Question extends Quiz
{

    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    Answer answer;

    public Question(String question, String option1, String option2, String option3, String option4, Answer answer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public Answer getAnswer() {
        return answer;
    }
}

class Answer extends Quiz
{
    String answer;

    public Answer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}

interface IResult
{
    void showResult();
    double showPercentage(int correctAnswers,int totalQuestions);
    String showPerformance(double percentage);
}

class Result implements IResult
{
    int totalQuestions;
    int correctAnswers;
    int wrongAnswers;

    public Result(int totalQuestions, int correctAnswers, int wrongAnswers) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = wrongAnswers;
    }

    @Override
    public void showResult() {
        System.out.println("Your results!");
        System.out.println("Total Questions " + totalQuestions);
        System.out.println("Number of correct answers " + correctAnswers);
        System.out.println("Number of wrong answers " + wrongAnswers);
        System.out.println("Percentage " + showPercentage(correctAnswers,totalQuestions));
        System.out.println("Your performance " + showPerformance(showPercentage(correctAnswers,totalQuestions)));
        System.out.println("Do you want to continue?");
        System.out.println("1.yes\n2.NO");
        Scanner s=new Scanner(System.in);
        char ss=s.next().charAt(0);
        switch(ss)
        {
            case '1':
            { Quiz q1=new Quiz();
            try {
                q1.begin();
            } catch (IOException ex) {
                Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            case '2':
                System.exit(0);
        }

    }

    @Override
    public double showPercentage(int correctAnswers, int totalQuestions) {
        //System.out.println(correctAnswers + " " + totalQuestions);
        return (double) (correctAnswers / (double)totalQuestions) * 100 ;
    }

    @Override
    public String showPerformance(double percentage) {
        String performance = "";

        if(percentage > 60)
        {
            performance = "Good";
        }
        else if(percentage < 40)
        {
            performance = "Poor";
        }

        return performance;

    }
}


