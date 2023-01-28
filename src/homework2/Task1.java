/*
Дана json строка { { "фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}}
Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
Используйте StringBuilder для подготовки ответа
 */
package homework2;
import java.io.IOException;

import static homework2.Task2.writeToFile;
public class Task1 {
    public static void main(String[] args) throws IOException {
        String jsonStr = "{{ \"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}}";
        System.out.println(result(jsonStr));
        writeToFile(result(jsonStr), "text.txt");
    }

    public static String result(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] data = string.replace("{", "").
                replace(" ", "").
                replace("\"", "").
                replace(",", "").
                replace("фамилия:", "Студент ").
                replace("оценка:", " получил ").replace("предмет:", " по предмету ").
                split("}");
        stringBuilder.append(data[0]);
        stringBuilder.append(".");
        stringBuilder.append("\n");
        stringBuilder.append(data[1]);
        stringBuilder.append(".");
        stringBuilder.append("\n");
        stringBuilder.append(data[2]);
        stringBuilder.append(".");
        return stringBuilder.toString();
    }
}