package com.example.diceapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer soundClick = MediaPlayer.create(this, R.raw.dice_sound);

        final int [] daduImageArray = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6 };


        final ImageView daduImage1 = findViewById(R.id.imgDadu1);
        final ImageView daduImage2 = findViewById(R.id.imgDadu2);

        Button btnKocok = findViewById(R.id.btnKocokDadu);
        btnKocok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("KocokDadu", "btnKocok telah diklik");
                Random randomObjek = new Random();
                int randomNomor = randomObjek.nextInt(6); // mengacak nomor dari 0 - 6
                Log.i("KocokDadu", "Nomor kocokan yang keluar adalah " + randomNomor );
                daduImage1.setImageResource(daduImageArray[randomNomor]);
                randomNomor = randomObjek.nextInt(6);
                daduImage2.setImageResource(daduImageArray[randomNomor]);
                YoYo.with(Techniques.Shake)
                        .duration(1000) // 1000 ms = 1 second
                        .repeat(0)
                        .playOn(daduImage1);

                YoYo.with(Techniques.Shake)
                        .duration(1000)
                        .repeat(0)
                        .playOn(daduImage2);
                soundClick.start();
            }
        });
    }
}
