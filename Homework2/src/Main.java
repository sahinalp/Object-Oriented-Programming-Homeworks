import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //User's menu selection
        int menuSelection;
        //User's multiplication answers
        int userAnswer;
        //Create Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        //Create QuestionCreater object to do calculations
        QuestionCreater questionCreater = new QuestionCreater();

        //The code will continue to run if the user did not enter the selection in the correct format
        while (true) {

            System.out.println("#####################################");
            //6.35. (Computer-Assisted Instruction) homework
            System.out.println("1-Homework 6.35");
            //6.36. (Computer-Assisted Instruction: Reducing Student Fatigue) homework
            System.out.println("2-Homework 6.36");
            //6.37. (Computer-Assisted Instruction: Monitoring Student Performance) homework
            System.out.println("3-Homework 6.37");
            System.out.println("Please select section...");
            //Read an int input from the user
            menuSelection = scanner.nextInt();
            //The loop will break if the user entered the 1,2 or 3.
            if (menuSelection>0 && menuSelection<4)
            {
                break;
            }
        }
        switch (menuSelection)
        {
            case 1:
                //The loop will continue to run if the user did not enter '-1'.
                while (true)
                {
                    //Generate 2 random numbers between 0 and 9
                    questionCreater.createNumbers();
                    //Print question
                    questionCreater.displayQuestion();
                    System.out.printf("(Enter -1 to exit)\n");
                    userAnswer = scanner.nextInt();
                    //The loop will break if the user entered '-1'.
                    if (userAnswer==-1)
                        break;
                    //Compare user's answer with result. It will return true if it's correct.
                    boolean result=questionCreater.compareAnswer(userAnswer,false);
                    if (result)
                        System.out.println("Very good!");
                    else
                        System.out.println("No. Please try again.");

                }
                break;
            case 2:
                //The loop will continue to run if the user did not enter '-1'.
                while (true)
                {
                    //Generate 2 random numbers between 0 and 9
                    questionCreater.createNumbers();
                    //Print question
                    questionCreater.displayQuestion();
                    System.out.printf("(Enter -1 to exit)\n");
                    userAnswer = scanner.nextInt();
                    //The loop will break if the user entered '-1'.
                    if (userAnswer==-1)
                        break;
                    //Compare user's answer with result. It will print one of the responses.
                    questionCreater.compareAnswer(userAnswer,true);

                }
                break;

            case 3:
                //The loop will continue to run if the user did not enter '-1'.
                while (true)
                {
                    //Set totalCorrectAnswer and totalWrongAnswer to 0.
                    questionCreater.resetCounters();
                    //It will ask 10 question to user.
                    for (int i=1;i<=10;i++)
                    {
                        //Generate 2 random numbers between 0 and 9
                        questionCreater.createNumbers();
                        //Print question
                        System.out.printf("Question %d- ",i);
                        questionCreater.displayQuestion();
                        userAnswer = scanner.nextInt();
                        //Compare user's answer with result. It will print one of the responses.
                        questionCreater.compareAnswer(userAnswer,true);

                    }
                    //Calculate note of user and print results.
                    questionCreater.calculatePercentage();
                    System.out.println("\nEnter -1 to exit\n");
                    userAnswer = scanner.nextInt();
                    //The loop will break if the user entered '-1'.
                    if (userAnswer==-1) {
                        break;
                    }

                }
                break;
        }

    }
}