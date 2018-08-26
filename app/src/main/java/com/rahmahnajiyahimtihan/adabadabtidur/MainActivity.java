package com.rahmahnajiyahimtihan.adabadabtidur;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // 1kenalin
    ImageView play, option;
    int volume = 0;
    private ImageView angka;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2 sambungin
        play = (ImageView) findViewById(R.id.imgPlay);
        option = (ImageView) findViewById(R.id.imgOption);

        volume = 1;

        //3 ngapain
        play.setOnClickListener(new View.OnClickListener() {//method
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, PilihKarakter.class);//dr mana mau knmn
                startActivity(pindah);

            }
        });

        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialogoption = new Dialog(MainActivity.this, R.style.Theme_AppCompat);//sbnrny contohnya pakai dialog option tp aku nulisnya dialog hebat its okay
                dialogoption.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialogoption.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogoption.setContentView(R.layout.dialog_option);
                dialogoption.show();

                ImageView next = (ImageView) dialogoption.findViewById(R.id.imgbtn_sfx_next);
                ImageView back = (ImageView) dialogoption.findViewById(R.id.imgbtn_sfx_back);
                  angka = (ImageView) dialogoption.findViewById(R.id.imgset_angka);

                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (volume == 10){
                            volume = volume;
                        } else {
                            volume = volume + 1;
                            gantiAngka(volume);
                            settingsuara(volume);
                        }

                    }
                });

                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (volume == 1){
                            volume = volume;
                        } else {
                            volume = volume -1;
                            gantiAngka(volume);
                            settingsuara(volume);
                        }

                    }
                });

            }
        });
    }

    private void settingsuara(int volume) {
        AudioManager audio = (AudioManager)getSystemService(AUDIO_SERVICE);
        audio.setStreamVolume(AudioManager.STREAM_MUSIC, volume, AudioManager.FLAG_SHOW_UI);
    }

    private void gantiAngka(int volume) {
        if (volume == 1) {
            angka.setImageResource(R.drawable.asatu);
        }else if (volume == 2){
            angka.setImageResource(R.drawable.adua);
        }else if (volume == 3){
            angka.setImageResource(R.drawable.atiga);
        }else if (volume == 4){
            angka.setImageResource(R.drawable.aempat);
        }else if (volume == 5){
            angka.setImageResource(R.drawable.alima);
        }else if (volume == 6){
            angka.setImageResource(R.drawable.aenam);
        }else if (volume == 7){
            angka.setImageResource(R.drawable.atujuh);
        }else if (volume == 8){
            angka.setImageResource(R.drawable.adelapan);
        }else if (volume == 9){
            angka.setImageResource(R.drawable.asembilan);
        }else if (volume == 10){
            angka.setImageResource(R.drawable.a10);
        }
    }

}
