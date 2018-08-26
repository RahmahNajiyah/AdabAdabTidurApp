package com.rahmahnajiyahimtihan.adabadabtidur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PilihKarakter extends AppCompatActivity {

    ImageView bilal, nadia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_karakter);

        bilal = (ImageView) findViewById(R.id.char_bilal);
       nadia = (ImageView) findViewById(R.id.char_nadia);

        bilal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(PilihKarakter.this, PlayActivity.class);
                //kirim data
                pindah.putExtra("DATA_KARAKTER", "bilal");
                startActivity(pindah);
            }
        });

        nadia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(PilihKarakter.this, PlayActivity.class);
                //kirim data
                pindah.putExtra("DATA_KARAKTER", "nadia");
                startActivity(pindah);
            }
        });
    }
}
