package com.ai.faraday;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


class ReadAndWriteAppData {

    private final String filename = "UserData";
    private String line;


    void writeFileData(Context context, String userName) {
        try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
            fos.write(userName.getBytes());
            System.out.println("file written");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String readFileData(Context context) throws FileNotFoundException {
        FileInputStream fis = context.openFileInput(filename);
        InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            line = reader.readLine();
        } catch (IOException ignored) {
        } finally {

            System.out.println(line);
        }
        return null;
    }

}
