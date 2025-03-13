package org.utils;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileUtils {

    public static ArrayList<String> readFileFromResources(String fileName) {
        ArrayList<String> lineas = new ArrayList<>();
        try (InputStream input = FileUtils.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new RuntimeException("Error file not found");
            }

            try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
                String line = null;
                while((line = bufferReader.readLine()) != null) {
                    lineas.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error read file: " + e.getMessage());
        }

        return lineas;
    }

    public static void writeFileToResources(String fileName, ArrayList<String> lista){
        try {
            File file = new File(FileUtils.class.getClassLoader().getResource(fileName).toURI());
            OutputStream outStream = new FileOutputStream(file);
            for (String s : lista) {
                outStream.write(s.getBytes());
                outStream.write('\n');
            }

            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> readFileFromPath(String fileName, String path) {
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(path + fileName, StandardCharsets.UTF_8))) {
            String line = null;
            while((line = bufferReader.readLine()) != null) {
                lineas.add(line);
            }
        }catch (IOException e) {
            throw new RuntimeException("Error read file: " + e.getMessage());
        }

        return lineas;
    }

}