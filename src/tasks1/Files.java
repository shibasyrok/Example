package tasks1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Files {

//    private static String fileName = "";
//    private static String text = "";
//    private static File file = new File(fileName);
//    public Files(String fileName, String text) {
//        this.fileName = fileName;
//        this.text = text;
//    }
//
//    public static String getFileName() {
//        return fileName;
//    }
//
//    public static void setFileName(String fileName) {
//        Files.fileName = fileName;
//    }
//
//    public static String getText() {
//        return text;
//    }
//
//    public static void setText(String text) {
//        Files.text = text;
//    }
//
//    public static File getFile() {
//        return file;
//    }
//
//    public static void setFile(File file) {
//        Files.file = file;
//}

public static void save(String fileName, String text) {
        //Определяем файл
        File file = new File(fileName);
        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                out.print(text);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

//    public static String read(String fileName) throws FileNotFoundException {
//        //Этот спец. обхект для построения строки
//        StringBuilder sb = new StringBuilder();
//
//        exists(fileName);
//
//        try {
//            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
//            try {
//                String s;
//                while ((s = in.readLine()) != null) {
//                    sb.append(s);
//                    sb.append("/n");
//                }
//            } finally {
//                in.close();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return sb.toString();
//    }

//    public static void main(String[] args) throws FileNotFoundException {
//        FileTest.read("no_file.txt");
//        //Запись в файл
//        FileTest.write(fileName, text);
//        System.out.println(text);
//        
//    }
//    private static void exists(String fileName) throws FileNotFoundException {
//        if (!file.exists()) {
//            throw new FileNotFoundException(file.getName());
//        }
//    }
}
