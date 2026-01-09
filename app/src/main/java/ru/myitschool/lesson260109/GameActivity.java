package ru.myitschool.lesson260109;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import ru.myitschool.lesson260109.databinding.ActivityGameBinding;
import ru.myitschool.lesson260109.databinding.ItemButtonBinding;


public class GameActivity extends AppCompatActivity {


    private final Quest quest = new Quest();
    private ActivityGameBinding binding;
    private PrefsManager prefsManager;

    public static Intent newInstance(Context context) {
        return new Intent(context, GameActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        prefsManager = new PrefsManager(getSharedPreferences(PrefsManager.NAME, MODE_PRIVATE));
        setContentView(binding.getRoot());
        initQuestion(0);
    }

    private void initQuestion(int stepNumber) {
        binding.score.setText("SCORE: " + quest.getScore());
        switch (stepNumber) {
            case -1:
                setPositiveEndState();
                break;
            case -2:
                setNegativeEndState();
                break;
            default:
                setQuestionState(stepNumber);
                break;

        }
    }

    private void writeBestScore() {
        prefsManager.setScore(Math.max(prefsManager.getScore(), quest.getScore()));
    }

    private void setQuestionState(int stepNumber) {
        Quest.Question question = quest.getQuestion(stepNumber);
        binding.description.setText(question.getDescription());
        fillButtons(question.getAnswers());
    }

    private void fillCloseButton(){
        binding.buttons.removeAllViews();
        ItemButtonBinding buttonBinding = ItemButtonBinding.inflate(
                getLayoutInflater(),
                binding.buttons,
                false);
        buttonBinding.getRoot().setText("Выйти в меню");
        buttonBinding.getRoot().setOnClickListener(v -> finish());
        binding.buttons.addView(buttonBinding.getRoot());
    }

    private void fillButtons(Quest.Question.Answer[] answers) {
        binding.buttons.removeAllViews();
        for (Quest.Question.Answer answer : answers) {
            ItemButtonBinding buttonBinding = ItemButtonBinding.inflate(getLayoutInflater(), binding.buttons, false);
            buttonBinding.getRoot().setText(answer.getName());
            buttonBinding.getRoot().setOnClickListener(v -> goNext(answer));
            binding.buttons.addView(buttonBinding.getRoot());
        }
    }

    private void goNext(Quest.Question.Answer answer) {
        quest.addScore(answer.getScore());
        initQuestion(answer.getNextStep());
    }


    private void setNegativeEndState() {
        binding.description.setText("Вы проиграли X_X");
        fillCloseButton();
        writeBestScore();
    }

    private void setPositiveEndState() {
        binding.description.setText("Вы победили *_*");
        fillCloseButton();
        writeBestScore();
    }


}