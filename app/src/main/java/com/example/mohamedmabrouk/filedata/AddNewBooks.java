package com.example.mohamedmabrouk.filedata;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by Mohamed Mabrouk on 12/05/2016.
 */
public class AddNewBooks extends DialogFragment {
    public static final String data="com.example.mohamedmabrouk.filedata.data";
    private EditText name;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View  view=LayoutInflater.from(getActivity()).inflate(R.layout.add_new_book,null);
        name=(EditText)view.findViewById(R.id.bookName);
        return new AlertDialog.Builder(getActivity()).setTitle("Add New Book").setView(view).
                setIcon(android.R.drawable.ic_menu_save).
                setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                                try {
                                    FileOutputStream fileOutputStream = getActivity().openFileOutput("books.txt", getContext().MODE_APPEND);
                                    OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
                                    if (name.getText().toString().trim().isEmpty()) {
                                        Toast.makeText(getActivity(), ":( Fill the Field", Toast.LENGTH_SHORT).show();
                                    } else {
                                        writer.append(name.getText().toString() + "\n");
                                        writer.close();

                                        Toast.makeText(getActivity(), "Added :)", Toast.LENGTH_SHORT).show();
                                    }

                                } catch (Exception e) {

                                }


                            }
                        }

                ).

                    create();
                }
    }
