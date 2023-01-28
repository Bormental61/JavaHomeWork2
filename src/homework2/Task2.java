/*
Создать метод, который запишет результат работы в файл Обработайте исключения и запишите ошибки в лог файл
 */
package homework2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    public static void writeToFile (String string, String filePath) throws IOException {
        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler fileHandler = new FileHandler("Task2log.txt");
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        try (FileWriter fileWriter = new FileWriter(filePath, false)){
            fileWriter.write(string);
        } catch (IOException e){
            logger.info("Ошибка записи");
        } finally {
            logger.info("Запись в файл произведена");
        }
    }
}
