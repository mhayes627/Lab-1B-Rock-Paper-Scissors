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
    Random rand = new Random();
    Weapon playerWeapon, comWeapon;

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

        TextView wt = binding.winText;

        String rockWin = getResources().getString(R.string.rock_win);
        String paperWin = getResources().getString(R.string.paper_win);
        String scissorsWin = getResources().getString(R.string.scissors_win);

        binding.rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerWeapon = Weapon.ROCK;
                comWeapon = startMatch(playerWeapon);

                if (comWeapon.equals(Weapon.SCISSORS)){
                    wt.setText(getResources().getString(R.string.player_win, rockWin));
                    playerScore++;
                }
                else if (comWeapon.equals(Weapon.PAPER)){
                    wt.setText(getResources().getString(R.string.com_win, paperWin));
                    comScore++;
                }
                else {
                    wt.setText(getResources().getString(R.string.tie_text));
                }
                updateScore();
            }
        });
        binding.paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerWeapon = Weapon.PAPER;
                comWeapon = startMatch(playerWeapon);

                if (comWeapon.equals(Weapon.SCISSORS)){
                    wt.setText(getResources().getString(R.string.com_win, scissorsWin));
                    comScore++;
                }
                else if (comWeapon.equals(Weapon.ROCK)){
                    wt.setText(getResources().getString(R.string.player_win, paperWin));
                    playerScore++;
                }
                else {
                    wt.setText(getResources().getString(R.string.tie_text));
                }
                updateScore();
            }
        });
        binding.scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerWeapon = Weapon.SCISSORS;
                comWeapon = startMatch(playerWeapon);

                if (comWeapon.equals(Weapon.ROCK)){
                    wt.setText(getResources().getString(R.string.com_win, rockWin));
                    comScore++;
                }
                else if (comWeapon.equals(Weapon.PAPER)){
                    wt.setText(getResources().getString(R.string.player_win, scissorsWin));
                    playerScore++;
                }
                else {
                    wt.setText(getResources().getString(R.string.tie_text));
                }
                updateScore();
            }
        });
    }

    public Weapon startMatch(Weapon pw){
        binding.pweaponText.setText(getResources().getString(R.string.pChoice_text, pw.toString()));
        int weapon = rand.nextInt(Weapon.values().length);
        comWeapon = Weapon.values()[weapon];
        binding.cweaponText.setText(getResources().getString(R.string.comChoice_text, comWeapon.toString()));

        return comWeapon;
    }

    public void updateScore(){
        TextView score_text = binding.scoreText;
        score_text.setText(getResources().getString(R.string.score_text, playerScore, comScore));
    }
}