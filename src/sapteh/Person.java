package sapteh;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Date birthDay;

    public Person(int id, String firstName, String lastName, String patronymic, Date birthDay){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
    }
    public int getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPatronymic(){
        return patronymic;
    }
    public Date getBirthDay(){
        return birthDay;
    }

    public int count(){
        Date datTo = new Date();
        return (int)((datTo.getTime() - getBirthDay().getTime())/1000/60/60/24/365);
    }

    private String dateToString(){
        return new SimpleDateFormat("dd.MM.yyyy").format(getBirthDay());
    }

    public String toString(){
        return String.format("%d, %s, %s, %s %s", getId(), getFirstName(), getLastName(), getPatronymic(), dateToString());
    }
}