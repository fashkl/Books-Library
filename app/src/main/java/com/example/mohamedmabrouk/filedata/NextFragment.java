package com.example.mohamedmabrouk.filedata;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Mohamed Mabrouk on 12/05/2016.
 */
public class NextFragment extends Fragment {
    public static final String ADDTAG="addtag";
    public static final String data="com.example.mohamedmabrouk.filedata.data";
   private Button add,showAllBooks,showMyBooks;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.next_fargment,container,false);
        add=(Button)view.findViewById(R.id.add);
        showAllBooks=(Button)view.findViewById(R.id.show_all_books);
        showMyBooks=(Button)view.findViewById(R.id.show_my_books);
        add();
        show_all_books();
        show_my_books();
        return view;
    }

    private void add(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getFragmentManager();
                AddNewBooks addNewBooks=new AddNewBooks();
                addNewBooks.show(fragmentManager,ADDTAG);
            }
        });
    }


    private void show_all_books()
    {
        showAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(getActivity(),Show_All_Books_Activity.class));
            }
        });

    }

    private void show_my_books(){
        showMyBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Show_My_Books_Activity.class));
            }
        });
    }
}
