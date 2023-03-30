package com.pradyunya.resolver;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.pradyunya.resolver.drawer.Home;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class Task extends Home {
myViewHolder mh;
Button get_item;
 AlertDialog.Builder ad;
 AlertDialog d;
EditText title,desc,date,time;
Button b2;
ImageView add;

    Database db;
    SQLiteDatabase sq;
    public List<Item> tasks= new ArrayList<>();

  public  RecyclerView rv;


MyAdapter mv= new MyAdapter(Task.this,tasks);

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater li=LayoutInflater.from(this);
        View v=li.inflate(R.layout.activity_task,null,false);

        dl.addView(v,1);

        db=new Database(this);
        sq=db.getWritableDatabase();
add=findViewById(R.id.add);
rv=findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(Task.this));
        rv.setAdapter(new MyAdapter(getApplicationContext(),tasks));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialog();
            }
        });
ItemTouchHelper itemTouchHelper= new ItemTouchHelper(simpleCallback);
       itemTouchHelper.attachToRecyclerView(rv);

        get_item=findViewById(R.id.get);
        get_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor t= db.getInfo();
                if (t.getCount()!=0)
                {
                    while (t.moveToNext())
                    {


                        tasks.add(new Item(t.getString(0),t.getString(1),t.getString(2),t.getString(3)));


                    }

                }
                rv.setLayoutManager(new LinearLayoutManager(Task.this));
                rv.setAdapter(new MyAdapter(getApplicationContext(),tasks));
                get_item.setEnabled(false);

            }
        });

    }

   Item deleted= new Item();

    ItemTouchHelper.SimpleCallback simpleCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @SuppressLint({"ShowToast", "NotifyDataSetChanged"})
        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position=viewHolder.getAbsoluteAdapterPosition();

        switch (direction)
        {
            case ItemTouchHelper.LEFT:
                deleted= tasks.get(position);
                String t=deleted.getTitle();
                boolean i=db.delete(t);
                if (i==true)
                {

                    tasks.remove(position);
                    mv.notifyDataSetChanged();
                    Toast.makeText(Task.this,"item deleted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Task.this,"Deleted failed",Toast.LENGTH_LONG).show();
                }




                break;
            case ItemTouchHelper.RIGHT:
                break;
        }
        }
        public void onChildDraw (@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive){

            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

                    .addSwipeRightBackgroundColor(ContextCompat.getColor(Task.this,R.color.purple_500))
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(Task.this,R.color.red))
                    .addSwipeRightActionIcon(R.drawable.ic_baseline_update_24)
                    .addSwipeLeftActionIcon(R.drawable.ic_baseline_delete_outline_24)
                    .addSwipeLeftLabel("Delete")

                    .create()
                    .decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }


    };


    @SuppressLint("MissingInflatedId")
    public void createDialog()
    {
        ad=new AlertDialog.Builder(this);
        final View addpopup=getLayoutInflater().inflate(R.layout.popup,null);
        title=addpopup.findViewById(R.id.title);
        desc=addpopup.findViewById(R.id.descp);
        date=addpopup.findViewById(R.id.date);
        time=addpopup.findViewById(R.id.tm);
        b2=addpopup.findViewById(R.id.b);
        ad.setView(addpopup);
        d=ad.create();
        d.show();
        Context context = getApplicationContext();
        rv= findViewById(R.id.rv);

        db=new Database(context);
        sq=db.getWritableDatabase();


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String email = intent.getStringExtra("email");

                if(title.getText().toString().equals("") || desc.getText().toString().equals("") || date.getText().toString().equals("") || time.getText().toString().equals(""))
                {
                    Toast.makeText(Task.this,"Enter all fields",Toast.LENGTH_LONG).show();
                }
                else
                {
                    boolean i= db.insert_task(email,title.getText().toString(),desc.getText().toString(),date.getText().toString(),time.getText().toString());
                    if(i)
                    {
                        Toast.makeText(Task.this,"Task Added",Toast.LENGTH_LONG).show();
                        Cursor t= db.getInfo();
                        if (t.getCount()!=0)
                        {
                            while (t.moveToNext())
                            {

                                tasks.add(new Item(t.getString(0),t.getString(1),t.getString(2),t.getString(3)));


                            }

                        }
                    }
                    else
                    {
                        Toast.makeText(Task.this,"Failed",Toast.LENGTH_LONG).show();

                    }
                }




                rv.setLayoutManager(new LinearLayoutManager(Task.this));
                rv.setAdapter(new MyAdapter(getApplicationContext(),tasks));




            }
        });

    }


}