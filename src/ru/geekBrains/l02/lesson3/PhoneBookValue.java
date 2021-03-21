package ru.geekBrains.l02.lesson3;

public class PhoneBookValue {
    private String surame;
    private String phoneNr;

    public PhoneBookValue(String surame, String phoneNr) {
        this.surame = surame;
        this.phoneNr = phoneNr;
    }

    public String getSurame() {
        return surame;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    @Override
    public String toString() {
//        return super.toString();
        return (String) "{ " +
                "surname: " + this.getSurame() + "; " + " phoneNr: " + this.getPhoneNr() +
                " }";
    }
}
