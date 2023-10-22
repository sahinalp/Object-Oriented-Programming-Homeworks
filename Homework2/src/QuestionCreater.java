import java.security.SecureRandom;

public class QuestionCreater {
    private SecureRandom secureRandom;
    private int firstNumber;
    private int secondNumber;
    private int correctAnswer;
    private int totalCorrectAnswer;
    private int totalWrongAnswer;
    public QuestionCreater() {
        this.secureRandom = new SecureRandom();
        this.totalCorrectAnswer = 0;
        this.totalWrongAnswer = 0;
    }
    void createNumbers()
    {
        // Generate random number between 0 and 9
        firstNumber=secureRandom.nextInt(10);
        secondNumber=secureRandom.nextInt(10);

        correctAnswer=firstNumber*secondNumber;
    }
    boolean compareAnswer(int answer,boolean display)
    {
        if (answer==this.correctAnswer)
        {
            totalCorrectAnswer++;
            if (display)
            {
                displayCorrect();
            }
            return true;
        }
        else
        {
            totalWrongAnswer++;
            if (display)
            {
                displayWrong();
            }
            return false;
        }
    }
    private void displayCorrect()
    {
        int responseIndex = secureRandom.nextInt(4) + 1;
        switch (responseIndex) {
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
        }
    }
    private void displayWrong()
    {
        int responseIndex = secureRandom.nextInt(4) + 1;
        switch (responseIndex) {
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don't give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
        }
    }
    void displayQuestion()
    {
        System.out.printf("How much is %d times %d? ",firstNumber,secondNumber);
    }
    void resetCounters()
    {
        this.totalWrongAnswer=0;
        this.totalCorrectAnswer=0;
    }
    void calculatePercentage()
    {
        int percentage = totalCorrectAnswer * 10;
        if (percentage < 75)
        System.out.println("Please ask your teacher for extra help.");
        else
        System.out.println("Congratulations, you are ready to go to the next level!");

    }
}
