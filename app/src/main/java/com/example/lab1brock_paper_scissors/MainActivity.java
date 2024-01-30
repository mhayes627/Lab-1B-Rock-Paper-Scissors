package com.example.lab1brock_paper_scissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab1brock_paper_scissors.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    int playerScore = 0;
    int comScore = 0;
    String comChoice;
    String playerChoice;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        TextView rt = binding.rockButton;
        rt.setText(Weapon.ROCK.toString());

        TextView pt = binding.paperButton;
        pt.setText(Weapon.PAPER.toString());

        TextView st = binding.scissorsButton;
        st.setText(Weapon.SCISSORS.toString());

        TextView score = binding.scoreText;
        score.setText(getResources().getString(R.string.score_text, playerScore, comScore));

        binding.rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice = binding.rockButton.getText().toString();
                startMatch(playerChoice);
            }
        });
        binding.paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice = binding.paperButton.getText().toString();
                startMatch(playerChoice);
            }
        });
        binding.scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice = binding.scissorsButton.getText().toString();
                startMatch(playerChoice);

            }
        });


    }

    public void startMatch(String pc){
        binding.pweaponText.setText(pc);
        int weapon = rand.nextInt(Weapon.values().length);
        comChoice = Weapon.values()[weapon].toString();

        TextView cWeaponText = binding.cweaponText;
        cWeaponText.setText(comChoice);

        TextView wt = binding.winText;


    }

}