import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menuSelection;
        int userAnswer;
        Scanner scanner = new Scanner(System.in);
        QuestionCreater questionCreater = new QuestionCreater();

        while (true) {

            System.out.println("#####################################");
            System.out.println("1-Homework 6.35");
            System.out.println("2-Homework 6.36");
            System.out.println("3-Homework 6.37");
            System.out.println("Please select section...");
            menuSelection = scanner.nextInt();
            if (menuSelection>0 && menuSelection<4)
            {
                break;
            }
        }
        switch (menuSelection)
        {
            case 1:
                while (true)
                {
                    questionCreater.createNumbers();
                    questionCreater.displayQuestion();
                    System.out.printf("(Enter -1 to exit)\n");
                    userAnswer = scanner.nextInt();
                    if (userAnswer==-1)
                        break;
                    boolean result=questionCreater.compareAnswer(userAnswer,false);
                    if (result)
                        System.out.println("Very good!");
                    else
                        System.out.println("No. Please try again.");

                }
                break;
            case 2:
                while (true)
                {
                    questionCreater.createNumbers();
                    questionCreater.displayQuestion();
                    System.out.printf("(Enter -1 to exit)\n");
                    userAnswer = scanner.nextInt();
                    if (userAnswer==-1)
                        break;
                    questionCreater.compareAnswer(userAnswer,true);

                }
                break;

            case 3:
                while (true)
                {
                    questionCreater.resetCounters();
                    for (int i=1;i<=10;i++)
                    {
                        questionCreater.createNumbers();
                        System.out.printf("Question %d- ",i);
                        questionCreater.displayQuestion();
                        userAnswer = scanner.nextInt();
                        questionCreater.compareAnswer(userAnswer,true);

                    }
                    questionCreater.calculatePercentage();
                    System.out.println("\nEnter -1 to exit\n");
                    userAnswer = scanner.nextInt();
                    if (userAnswer==-1) {
                        break;
                    }

                }
                break;
        }

    }
}