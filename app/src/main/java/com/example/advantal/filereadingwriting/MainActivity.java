package com.example.advantal.filereadingwriting;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText fname, fcontent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void fileWriteButton(View v)
    {
        fname=(EditText)findViewById(R.id.fileNameWriting);
        String fileName=fname.getText().toString();
        fcontent=(EditText)findViewById(R.id.fileContent);
        String fileContent=fcontent.getText().toString();
        FileReadWrite fop= new FileReadWrite();
        fop.FileWrite(fileName, fileContent);
        if(fop.FileWrite(fileName,fileContent))
        {
            Toast.makeText(MainActivity.this,"File Created", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
        }
    }

    public void fileReadButton(View v)
    {
        EditText edit=(EditText)findViewById(R.id.editText);
        String fileName =edit.getText().toString();
        FileReadWrite fop=new FileReadWrite();
        String str= fop.FileRead(fileName);
        if(str!=null)
        {
            edit.setText(str);
        }
        else
        {
            Toast.makeText(MainActivity.this,"File Not found",Toast.LENGTH_LONG).show();
            edit.setText("File Not found!!");
        }
    }

}
