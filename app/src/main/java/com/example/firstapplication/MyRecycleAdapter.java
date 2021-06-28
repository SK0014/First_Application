package com.example.firstapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolder>
{
    Context context;
    ArrayList<Hero> heroes;
    AlertDialog.Builder builder;
    MyRecycleAdapter(Context context, ArrayList<Hero> heroes)
    {
        this.context=context;
        this.heroes=heroes;
    }

    @NonNull
    @Override
    public MyRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.home_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleAdapter.ViewHolder holder, int position) {
        Hero hero = heroes.get(position);
        holder.txtname.setText(hero.getName());
        holder.txtteam.setText(hero.getTeam());
        builder=new AlertDialog.Builder(context);
        holder.btndele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setCancelable(false);
                builder.setMessage("Are you sure want to delete this item");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        heroes.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position,heroes.size());
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert=builder.create();
                alert.setTitle("Are you Sure");
                alert.show();
            }
        });
        //holder.imageView.setImageDrawable(context.getResources().getDrawable(hero.getImage()));
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView txtname;
        public TextView txtteam;
        public Button btndele;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.img_listItem);
            this.txtname = (TextView) itemView.findViewById(R.id.txt_listname);
            this.txtteam = (TextView) itemView.findViewById(R.id.txt_listteam);
            this.btndele = (Button) itemView.findViewById(R.id.btn_del);
        }
    }
}