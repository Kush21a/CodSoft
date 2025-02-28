import java.util.*;

public class QuizApp {
    static class Question {
        String question;
        String[] options;
        String correctAnswer;

        public Question(String question, String[] options, String correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }
    }

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, "Paris"));
        questions.add(new Question("What is 60 + 9?", new String[]{"69", "55", "87", "65"}, "69"));

        Scanner sc = new Scanner(System.in);
        int score = 0;
        int totalQuestions = questions.size();
        int timeLimit = 10;

        for (int i = 0; i < totalQuestions; i++) {
            Question currentQuestion = questions.get(i);
            System.out.println(currentQuestion.getQuestion());

            long startTime = System.currentTimeMillis();
            String[] options = currentQuestion.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            String userAnswer = getWithTimer(sc, timeLimit, startTime);

            if (userAnswer != null && userAnswer.equalsIgnoreCase(currentQuestion.getCorrectAnswer())) {
                score++;
            }
        }

        showResult(totalQuestions, score);
    }

    public static String getWithTimer(Scanner sc, int timeLimit, long startTime) {
        System.out.println("You have " + timeLimit + " seconds to answer...");
        String userAnswer = null;

        while (System.currentTimeMillis() - startTime < timeLimit * 1000) {
            if (sc.hasNextLine()) {
                userAnswer = sc.nextLine();
                break;
            }
        }

        if (userAnswer == null) {
            System.out.println("\nTime's up! No Answer provided.");
        }
        return userAnswer;
    }

    public static void showResult(int totalQuestions, int score) {
        System.out.println("\nYour final score is: " + score + "/" + totalQuestions);
        System.out.println(score == totalQuestions ? "Congratulations, you got all answers correct!" : "Better luck next time.");
    }
}
