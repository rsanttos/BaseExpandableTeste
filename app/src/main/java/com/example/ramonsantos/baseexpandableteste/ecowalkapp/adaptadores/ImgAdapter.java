package com.example.ramonsantos.baseexpandableteste.ecowalkapp.adaptadores;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by f043684 on 01/11/2017.
 */

public class ImgAdapter extends PagerAdapter {
    private Context context;
    private int[] imgs;

    public ImgAdapter(Context context, int[] imgs){
        this.context = context;
        this.imgs = imgs;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        // TODO Auto-generated method stub
        return view == obj;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){

        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        container.addView(ll);

        ImageView iv = new ImageView(context);
        iv.setImageResource(imgs[position]);
        ll.addView(iv);

        TextView tv = new TextView(context);
        tv.setText("Carro "+(position +1));
        ll.addView(tv);

        Log.i("Script", "Build: Carro: "+(position));

        return(ll);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view){
        Log.i("Script", "Destroy: Carro: "+(position));
        //container.removeView((View)((TextView)view).getParent());
        container.removeView((View) view);
    }
}
