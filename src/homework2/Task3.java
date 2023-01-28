/*
 *Получить исходную json строку из файла, используя FileReader или Scanner
 */
package homework2;

import java.io.File;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(reformat(readFile("text.txt")));
    }
    static String readFile (String filePath){
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    static String reformat (String string) {
        String original = string.replace("Студент ", "\"фамилия\":\"").
                replace(" получил ", "\",\"оценка\":\"").
                replace(" по предмету ", "\",\"предмет\":\"").
                replace(".", "\"},{");
        String substring = original.substring(0, original.length() - 1);
        String substring2 = substring.substring(0,substring.length() - 1);
        substring2 = "{{" + substring2 + "}";
    return substring2;
    }
}
