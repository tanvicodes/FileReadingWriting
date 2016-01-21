package com.example.advantal.filereadingwriting;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by advantal on 1/21/2016.
 */
public class FileReadWrite
{
    public FileReadWrite()
    {

    }

    public boolean FileWrite(String fileName, String fileContent)
    {
        try
        {
            String filePath="/sdcard/"+ fileName+".txt";
            File file=new File(filePath);
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileWriter fw=new FileWriter(file.getAbsolutePath());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fileContent);
            bw.close();
            Log.v("Wroking", "Yes Working");
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public String FileRead(String fileName)
    {
        BufferedReader br=null;
        String response=null;
        try
        {
            StringBuffer output= new StringBuffer();
            String filePath="/sdcard/"+fileName+".txt";
            br=new BufferedReader(new FileReader(filePath));
            String line="";
            while((line=br.readLine())!=null)
            {
                output.append(line +"\n");
            }
            response = output.toString();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        return response;
    }
}
