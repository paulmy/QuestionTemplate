package ru.myitschool.lesson260109;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.myitschool.lesson260109.databinding.ActivityMenuBinding;


public class MenuActivity extends AppCompatActivity {
    private ActivityMenuBinding binding;
    private PrefsManager prefsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        prefsManager = new PrefsManager(getSharedPreferences(PrefsManager.NAME,
                MODE_PRIVATE));
        setContentView(binding.getRoot());
        loadBestResult();
        binding.play.setOnClickListener(v -> {
            startActivity(GameActivity.newInstance(this));

        });
    }

    private void loadBestResult() {
        binding.score.setText("BEST: " + prefsManager.getScore());
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadBestResult();
    }

}