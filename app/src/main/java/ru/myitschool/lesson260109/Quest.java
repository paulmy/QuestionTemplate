package ru.myitschool.lesson260109;

public class Quest {
    private int score = 0;
    private int currentStep = 0;

    public Question getQuestion(int index) {
        if (index >= 0 && index < questions.length) {
            return questions[index];
        }
        return null;
    }

    public void addScore(int score) {
        this.score += score;
    }

    private final Question[] questions = new Question[]{
            new Question("Это первый вопрос",
                    new Question.Answer[]{
                            new Question.Answer("+10 очков", 10, 1),
                            new Question.Answer("-10 очков", -10, -2),
                    }),
            new Question("Это второй вопрос",
                    new Question.Answer[]{
                            new Question.Answer("+10 очков", 10, 2),
                            new Question.Answer("-100 очков", -100, 1),
                            new Question.Answer("-10 очков", -10, -2),
                    }),
            new Question("Это третий вопрос",
                    new Question.Answer[]{
                            new Question.Answer("+100 очков", 100, 3),
                            new Question.Answer("-100 очков", -100, -2),
                            new Question.Answer("-1000 очков", -1000, -2),
                            new Question.Answer("-2000 очков", -2000, -2),
                    }),
            new Question("Это четвёртый вопрос", new Question.Answer[]{
                    new Question.Answer("+10 очков", 10, 1),
                    new Question.Answer("-10 очков", -10, -2),
            })


    };

    public int getScore() {
        return score;
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public static class Question {
        private final String description;
        private final Answer[] answers;

        public Question(String description, Answer[] answers) {
            this.description = description;
            this.answers = answers;
        }

        public String getDescription() {
            return description;
        }

        public Answer[] getAnswers() {
            return answers;
        }

        public static class Answer {
            private final String name;
            private final int score;
            private final int nextStep;

            public Answer(String name, int score, int nextStep) {
                this.name = name;
                this.score = score;
                this.nextStep = nextStep;
            }

            public String getName() {
                return name;
            }

            public int getScore() {
                return score;
            }

            public int getNextStep() {
                return nextStep;
            }
        }
    }


}
