package com.example.fluke.fuckermovie_2.Holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.fluke.fuckermovie_2.R;
import com.example.fluke.fuckermovie_2.model.Movie;

public class MovieHolder extends RecyclerView.ViewHolder {
    private ImageView iv ;
    private TextView tv;
    private View view;

    public MovieHolder(View itemView) {
        super(itemView);
        iv = itemView.findViewById(R.id.iv_movie);
        tv = itemView.findViewById(R.id.tv_name);
        view = itemView;
    }

    public void onBind(final Movie movieData , Context context){
        tv.setText(movieData.getTitle());
       Glide.with(context).load("https://image.tmdb.org/t/p/w500"+movieData.getPoster()).into(iv);
        Log.e("pic" , movieData.getPoster());
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent s = new Intent(view.getContext() , HeroDetail6Activity.class);
//                Parcelable warp = Parcels.wrap(movieData);
//                s.putExtra("WTF_OBJ",warp );
//                view.getContext().startActivity(s);
//            }
//        });

    }
}
