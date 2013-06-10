package com.example.fileiosample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.content.Context;
import android.os.Environment;

public class FileUtils {
  public String loadStringFromLocalStorage(Context context, String filename) {
    BufferedReader br = null;
    String result = null;
    try {
      InputStream in = context.openFileInput(filename);
      InputStreamReader isr = new InputStreamReader(in);
      br = new BufferedReader(isr);
      String line = null;
      StringBuffer sb = new StringBuffer();
      while((line = br.readLine()) != null) {
        sb.append(line);
      } 
      result = sb.toString();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try { br.close(); } catch(Exception e) { e.printStackTrace(); }
    }
    return result;
  }
  public void saveStringToLocalStorage(Context context, String filename, String data) {
    OutputStreamWriter osw = null;
    try {
      osw = new OutputStreamWriter(
          context.openFileOutput(filename, context.MODE_PRIVATE));
      osw.write(data);
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        osw.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  public String loadStringFromSDCard(Context context, String filename) {
    BufferedReader br = null;
    String result = null;
    try {
      File sdfile = Environment.getExternalStorageDirectory();
      File file = new File(sdfile, filename);
      InputStream in = new FileInputStream(file);
      InputStreamReader isr = new InputStreamReader(in);
      br = new BufferedReader(isr);
      String line = null;
      StringBuffer sb = new StringBuffer();
      while((line = br.readLine()) != null) {
        sb.append(line);
      } 
      result = sb.toString();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try { br.close(); } catch(Exception e) { e.printStackTrace(); }
    }
    return result;
  }
  public void saveStringToSDCard(Context context, String filename,
                                 String data) {
    OutputStreamWriter osw = null;
    try {
      File sdfile = Environment.getExternalStorageDirectory();
      File file = new File(sdfile, filename);
      osw = new OutputStreamWriter(new FileOutputStream(file));
      osw.write(data);
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        osw.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  public String loadStringFromResource(Context context, int resourceId) {
    BufferedReader br = null;
    String result = null;
    try {
      InputStream in = context.getResources().openRawResource(resourceId);
      InputStreamReader isr = new InputStreamReader(in);
      br = new BufferedReader(isr);
      String line = null;
      StringBuffer sb = new StringBuffer();
      while((line = br.readLine()) != null) {
        sb.append(line);
      } 
      result = sb.toString();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try { br.close(); } catch(Exception e) { e.printStackTrace(); }
    }
    return result;
  }
}








