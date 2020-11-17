package sapteh;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException, ParseException {

        //read from a file
        String fileName = "listStudents.txt";
        List<Person> personList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                Person person = getPerson(br.readLine());
                personList.add(person);
            }
        }

        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите id сотрудника:");
        int id = Integer.parseInt(br1.readLine());
        for(Person person : personList){
            if (id == person.getId()) {
                System.out.printf("Сотрудник: %s %s %s \nВозраст: %d", person.getFirstName(), person.getLastName(), person.getPatronymic(), person.count());
            }
        }

        //write
        String outFileName = "outListStudents.txt";
        File file = new File(outFileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (Person person : personList) {
                fileWriter.write(person.toString());
                fileWriter.write("\n");
            }
        }
    }
    public static Person getPerson(String stringLine) throws ParseException {
        String[] arrayPerson = stringLine.split(" ");
        int id = Integer.parseInt(arrayPerson[0]);
        String lastName = arrayPerson[1];
        String firstName = arrayPerson[2];
        String patronomic = arrayPerson[3];
        Date date = new SimpleDateFormat("MM/dd/yyyy").parse(arrayPerson[4]);
        return new Person(id, lastName,firstName,patronomic,date);
    }
}