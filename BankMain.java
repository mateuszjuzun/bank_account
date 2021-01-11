package edu.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class BankMain {

    public static Bank bank = new Bank();




    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        String command = "";
        do {
            System.out.println("Podaj komendę:");
            command = keyboard.nextLine();
            if ("CREATE ACCOUNT".toLowerCase().equals(command)) {
                createAccount(keyboard);
            } else if("DEPOSIT".toLowerCase().equals(command)){
                depositMoney(keyboard);
            }

        } while (!command.equals("E"));

    }

    public static void depositMoney(Scanner keyboard) {
        System.out.println("Podaj numer konta i wartość");
        String rawData = keyboard.nextLine();
        String[] simpleData = rawData.split(" ");
        if (simpleData.length != 2) {
            System.out.println("coś poszło nie tak");
            return;
        }
        String accountNumber = simpleData[0].trim();
        BigDecimal value = new BigDecimal(simpleData[1].trim());
        System.out.println(bank.depositMoney(accountNumber, value));
    }

    private static void createAccount(Scanner keyboard) {
        System.out.println("Podaj dane w formacie imie:nazwisko:adres:data_urodzenia");
        String rawUserData = keyboard.nextLine();
        String[] userData = rawUserData.split(":");
        if(userData.length != 4){
            System.out.println("coś poszło nie tak");
            return;
        }

        String firstName = userData[0].trim();
        String lastName = userData[1].trim();
        String address = userData[2].trim();
        LocalDate dateOfBirth = LocalDate.parse(userData[3].trim());
        Person person = new Person(firstName, lastName, address, dateOfBirth);
        Account account = bank.createAccount(person);
       // System.out.println("Stworzono konto o nr " + account.getNumber());
        System.out.println("Stworzono konto" + account.toString());
        System.out.println(account);
    }



}