package com.rahmahnajiyahimtihan.adabadabtidur;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    ViewPager pager;
    ImageView next, back;
    int[] backgroundNadia = {
            R.drawable.satu,
            R.drawable.dua,
            R.drawable.tiga,
            R.drawable.empat,
            R.drawable.lima,
            R.drawable.enam,
            R.drawable.tujuh,
            R.drawable.delapan,
            R.drawable.sembilan,
            R.drawable.sepuluh,
    };

    int[] teks = {
            R.drawable.teks1,
            R.drawable.teks2,
            R.drawable.teks3,
            R.drawable.teks4,
            R.drawable.teks5,
            R.drawable.teks6,
            R.drawable.teks7,
            R.drawable.teks8,
            R.drawable.teks9,
            R.drawable.teks10,
    };

    int[] suaraNadia = {
            R.raw.suaranadia01,
            R.raw.suaranadia02,
            R.raw.suaranadia03,
            R.raw.suaranadia04,
            R.raw.suaranadia05,
            R.raw.suaranadia06,
            R.raw.suaranadia07,
            R.raw.suaranadia08,
            R.raw.suaranadia09,
            R.raw.suaranadia10,
    };
    int[] backgroundBilal = {
            R.drawable.bilal1,
            R.drawable.bilal2,
            R.drawable.bilal3,
            R.drawable.bilal4,
            R.drawable.bilal5,
            R.drawable.bilal6,
            R.drawable.bilal7,
            R.drawable.bilal8,
            R.drawable.bilal9,
            R.drawable.bilal10,
    };
    int[] suaraBilal = {
            R.raw.suarabilal01,
            R.raw.suarabilal02,
            R.raw.suarabilal03,
            R.raw.suarabilal04,
            R.raw.suarabilal05,
            R.raw.suarabilal06,
            R.raw.suarabilal07,
            R.raw.suarabilal08,
            R.raw.suarabilal09,
            R.raw.suarabilal10,
    };
    private AdabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        pager = (ViewPager) findViewById(R.id.Viewpager);
        next = (ImageView) findViewById(R.id.imgnext);
        back = (ImageView) findViewById(R.id.imgback);

        //terima data
        String pilihanKarakter = getIntent().getStringExtra("DATA_KARAKTER");//data karakter sebagai password ibaratnya

        if (pilihanKarakter.equals("bilal")){
             adapter = new AdabAdapter(PlayActivity.this, backgroundBilal, teks, suaraBilal);//samain kyk di adapter (ask zahra)
        } else if (pilihanKarakter.equals("nadia")){
             adapter = new AdabAdapter(PlayActivity.this, backgroundNadia, teks, suaraNadia);
        }

        //data
        //adapter; unutk menyambungakn item dgn data

        pager.setAdapter(adapter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pager.getCurrentItem() == backgroundNadia.length -1) {
                    Toast.makeText(PlayActivity.this, "Tes Halaman Akhir", Toast.LENGTH_SHORT).show();
                    Dialog dialogHebat = new Dialog(PlayActivity.this, R.style.Theme_AppCompat);
                    dialogHebat.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialogHebat.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialogHebat.setContentView(R.layout.dialog_hebat);
                    dialogHebat.show();

                    MediaPlayer.create(PlayActivity.this, R.raw.suaranadiahebat).start();
                }
                pager.arrowScroll(View.FOCUS_RIGHT);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                pager.arrowScroll(View.FOCUS_LEFT);
            }
        });

    }
}
