package Homework13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example1 {
    public static void main(String[] args) throws IOException {
        Path writeFilePath = Paths.get("/tmp/file.txt");

        // Создаём файл
        Path createdFilePath = Files.createFile(writeFilePath);
        System.out.println("Файл создан: " + createdFilePath);

        // Записываем данные в файл
        String str = "Hello world!";
        // Строку переводим в двоичный тип данных
        byte[] strToBytes = str.getBytes();

        Files.write(createdFilePath, strToBytes);
    }
}
