package com.example.firstapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class MyHomepageAdapter extends BaseAdapter {
    Context homePage;
    String[] a;
    public MyHomepageAdapter (Context homePage, String[] a) {
      this.homePage=homePage;
      this.a=a;
    }

    @Override
    public int getCount() {
        return a.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(homePage);

        View view=layoutInflater.inflate(R.layout.home_layout,parent,false);

        ImageView imageView=view.findViewById(R.id.img_listItem);

        TextView textView=view.findViewById(R.id.txt_listname);

        textView.setText(a[position]);
        return view;
    }
}
