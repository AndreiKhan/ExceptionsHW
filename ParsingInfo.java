import java.text.SimpleDateFormat;
import java.util.Date;

import Exceptions.DateException;
import Exceptions.FIOException;
import Exceptions.SexException;
import Exceptions.TelephoneException;

// класс для проверки информации
public class ParsingInfo {
    
    // Метод проверки ФИО
    public boolean fio(String[] fio) throws FIOException {
        boolean trig = false;

        try {

            // Проверка на длину
            if ((fio[0].length() >= 1 && 
                fio[1].length() >= 1 && 
                fio[2].length() >= 1)) {
                
                trig = true;

            } else {
                System.out.println("ФИО введены неверно");
            }
            
        } catch (Exception e) {
            throw new FIOException("ФИО введены неверно", e);
        }
        
        return trig;
    }

    // Метод проверки даты рождения
    public boolean date(String[] date) throws DateException {
        boolean trig = false;

        // Задаем формат даты
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");

        try {

            // Приводим полученную информацию в дату
            Date docDate = format.parse(date[3]);

            trig = true;
            
        } catch (Exception e) {
            throw new DateException("Дата рождения введена неверно", e);
        }

        return trig;
    }

    // Метод проверки номера телефона
    public boolean telephone(String[] telephone) throws TelephoneException {
        boolean trig = false;

        try {

            // Приводим номер в число
            Long number = Long.valueOf(telephone[4]);

            if (telephone[4].length() == 11) {

                trig = true;
            } else {
                System.out.println("Номер Телефона введен неверно");
            }
            
        } catch (Exception e) {
            throw new TelephoneException("Номер Телефона введен неверно", e);
        }

        return trig;
    }

    // Метод проверки пола
    public boolean sex(String[] sex) throws SexException {
        boolean trig = false;
        
        try {
            
            // проверяем что ввели для пола
            if (sex[5].equals("f") || 
                sex[5].equals("m")) {

                trig = true;
            } else {
                System.out.println("Пол введен неверно");
            }
           
        } catch (Exception e) {
            throw new SexException("Пол введен неверно", e);
        }
            
        return trig;
    }
}
