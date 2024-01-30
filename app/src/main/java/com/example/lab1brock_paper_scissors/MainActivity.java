package com.example.lab1brock_paper_scissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab1brock_paper_scissors.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        int playerScore, comScore;
        Random rand = new Random();

        TextView rt = binding.rockButton;
        rt.setText(Weapon.ROCK.toString());

        TextView pt = binding.paperButton;
        pt.setText(Weapon.PAPER.toString());

        TextView st = binding.scissorsButton;
        st.setText(Weapon.SCISSORS.toString());

        binding.rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}