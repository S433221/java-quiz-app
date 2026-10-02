import java.util.*;

class Question {
    String que;
    String[] options;
    int correctAns; // 1-4

    Question(String que, String[] options, int correctAns) {
        this.que = que;
        this.options = options;
        this.correctAns = correctAns;
    }

    boolean ask(Scanner sc) {
        System.out.println("\nQ: " + que);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + ". " + options[i]);
        }
        System.out.print("Your Ans (1-4): ");
        int ans = sc.nextInt();
        return ans == correctAns;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> quiz = new ArrayList<>();

        quiz.add(new Question("Java ka founder kaun hai?",
                new String[]{"Dennis Ritchie", "James Gosling", "Guido van Rossum", "Bjarne"}, 2));
        quiz.add(new Question("JVM ka full form?",
                new String[]{"Java Virtual Machine", "Java Very Main", "Just Virtual Machine", "None"}, 1));
        quiz.add(new Question("Constructor ka naam kya hota hai?",
                new String[]{"class jaisa", "alga naam", "main", "void"}, 1));
        quiz.add(new Question("ArrayList kis package me hai?",
                new String[]{"java.io", "java.util", "java.lang", "java.sql"}, 2));

        int score = 0;
        System.out.println("--- JAVA QUIZ START (4 Questions) ---");

        long startTime = System.currentTimeMillis();

        for (Question q : quiz) {
            if (q.ask(sc)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        long endTime = System.currentTimeMillis();
        long timeTaken = (endTime - startTime) / 1000;

        System.out.println("\n--- RESULT ---");
        System.out.println("Score: " + score + "/" + quiz.size());
        System.out.println("Time Taken: " + timeTaken + " sec");

        if (score == quiz.size()) System.out.println("Grade: Excellent! A+");
        else if (score >= 3) System.out.println("Grade: Good! B+");
        else if (score >= 2) System.out.println("Grade: Pass");
        else System.out.println("Grade: Fail - Practice more!");
    }
}