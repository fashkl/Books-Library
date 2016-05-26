package com.example.mohamedmabrouk.filedata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed Mabrouk on 12/05/2016.
 */
public class Show_All_Books_Fragment extends Fragment {
  private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.show_all_books_fragment, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.books_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<String> list=getBooks();
        showAdepter showAdepter=new showAdepter(list);
        recyclerView.setAdapter(showAdepter);
        showAdepter.notifyDataSetChanged();
        return view;
    }

    private List<String> getBooks(){
        List<String>  list=new ArrayList<>();
        try
        {
            InputStream instream = getActivity().openFileInput("books.txt");
            if (instream != null)
            {
                InputStreamReader inputreader = new InputStreamReader(instream);
                BufferedReader buffreader = new BufferedReader(inputreader);
                String line;

                    while ((line = buffreader.readLine()) != null) {
                        list.add(line);
                    }

            }
        }
        catch (Exception e)
        {
            String error="";
            error=e.getMessage();
        }
        return list;
    }

    private class showHolder extends  RecyclerView.ViewHolder{
        private TextView textView;
        public showHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.book);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addbooks();
                }
            });
        }
        public void bindbook(String s){
            textView.setText(s);

        }
        private void addbooks(){
            try {
                FileOutputStream fileOutputStream=getActivity().openFileOutput("mybooks.txt", getContext().MODE_APPEND);
                OutputStreamWriter writer=new OutputStreamWriter(fileOutputStream);
                writer.append(textView.getText()+"\n");
                writer.close();
                Toast.makeText(getActivity(), "Done", Toast.LENGTH_SHORT).show();

            }catch (Exception e){

            }
        }
    }

    private class showAdepter extends RecyclerView.Adapter<showHolder>{
        private List<String>  list;
        public showAdepter(List<String> lists){
            this.list=lists;
        }
        @Override
        public showHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           LayoutInflater inflater=LayoutInflater.from(getActivity());
            View view=inflater.inflate(R.layout.list_books,parent,false);

            return new showHolder(view);
        }

        @Override
        public void onBindViewHolder(showHolder holder, int position) {
        String s=list.get(position);
            holder.bindbook(s);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}
