package homework2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    public static void writeToFile (String string, String filePath) {
        Logger logger = Logger.getLogger(Task2.class.getName());
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler logFile = null;
        try {
            logFile = new FileHandler("log.txt");
            logFile.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(logFile);
        try (FileWriter fileWriter = new FileWriter(filePath, false)){
            fileWriter.write(string);
        } catch (IOException e){
            logger.log(Level.ALL, "Ошибка записи");
        }
    }
}
