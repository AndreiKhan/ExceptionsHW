import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Exceptions.DateException;
import Exceptions.FIOException;
import Exceptions.InfoException;
import Exceptions.SexException;
import Exceptions.TelephoneException;

public class PrintInfo {

    // Метод записи информации
    public void information(ParsingInfo parsingInfo) {

        boolean trig = true;
        System.out.println("Введите: Фамилию Имя Отчество  Дату рождения(дд.мм.гггг)  Номер телефона(8...)  Пол(f или m)");
        System.out.println("Вводите все через пробел одной строкой");

        while(trig == true) {

            try {

                Scanner scanner = new Scanner(System.in);
                String[] info = scanner.nextLine().split(" ");

                if (info.length != 6) {
                    throw new InfoException("Количество введенных данных неверно");
                }

                if (parsingInfo.fio(info) && parsingInfo.date(info) && parsingInfo.telephone(info) && parsingInfo.sex(info)) {
                    trig = false;
                    scanner.close();
                    writeFile(info);

                } else {
                    System.out.println("Введенные данные не корректны, повторите ввод: ");
                }

            } catch (FIOException | DateException | TelephoneException | SexException | InfoException e) {
                System.out.println(e);
            }
        }
    }

    
    // Метод для записи файла по фамили, и однофамильцы будут записываться в один файл
    public void writeFile(String[] info) {

        try(FileWriter writer = new FileWriter(info[0] + ".txt", true)) {

            for (String string : info) {
                
                writer.write("<" + string + "> ");
            }

            writer.write("\n");
            
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи файла");
            e.printStackTrace();
        }
    }
}
