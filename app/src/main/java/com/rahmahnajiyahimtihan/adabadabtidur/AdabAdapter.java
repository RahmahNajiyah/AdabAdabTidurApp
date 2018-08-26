package com.rahmahnajiyahimtihan.adabadabtidur;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

/**
 * Created by User on 1/27/2018.
 */

//variable yg dibutuhkan
public class AdabAdapter extends PagerAdapter {
    private Context context;
    private int[] backgroundAdab;
    private int[] teksAdab;
    private int[] suaraNadia;

    //constuctor > untk ngirim data (yg td di intent
    //klik kanan > generate > constructor


    public AdabAdapter(Context context, int[] backgroundAdab, int[] teksAdab, int[] suaraNadia) { //buat samain kyk yg di playactivity
        this.context = context;
        this.backgroundAdab = backgroundAdab;
        this.teksAdab = teksAdab;
        this.suaraNadia = suaraNadia;
    }

    public AdabAdapter(Context context, int[] backgroundAdab, int[] teksAdab) {
        this.context = context;
        this.backgroundAdab = backgroundAdab;
        this.teksAdab = teksAdab;

    }

    @Override
    public int getCount() {
        return backgroundAdab.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //instantiateitem

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        //sambungin layout item
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View itemview = inflater.inflate(R.layout.item_adab, null, true);

        //sambungin komponen di dalam item
        ImageView imageBackground = (ImageView) itemview.findViewById(R.id.img_item_background);//dr item_adab xml
        ImageView imageTeks = (ImageView) itemview.findViewById(R.id.img_item_teks);

        //set datanya
      //  imageBackground.setImageResource(backgroundAdab[position]);
      //  imageTeks.setImageResource(teksAdab[position]);
        Picasso.with(context).load(backgroundAdab[position]).into(imageBackground);
        Picasso.with(context).load(teksAdab[position]).into(imageTeks);

        imageTeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer.create(context, suaraNadia[position]).start();
            }
        });

        //tambahan stlh list view krn pakai viewpager
        container.addView(itemview);
        return itemview;

    }

    //destroyitem

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
