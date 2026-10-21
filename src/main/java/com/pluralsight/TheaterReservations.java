package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String name = getName(myScanner);
        String arrivalDate = getArrivalDate(myScanner);
        int ticketsBought = getTicketsBought(myScanner);

        reservationSummary(name, arrivalDate, ticketsBought);
    }

    public static void reservationSummary(String name, String arrivalDate, int ticketsBought) {
        String[] fullNameSplit = name.split(" ");
        String firstName = fullNameSplit[0];
        String lastName = fullNameSplit[1];

        if (ticketsBought > 1) {
            System.out.println(ticketsBought + " tickets reserved for " + arrivalDate + " under " + firstName + ", " + lastName);
        } else {
            System.out.println(ticketsBought + " ticket reserved for " + arrivalDate + " under " + firstName + ", " + lastName);
        }
    }

    private static int getTicketsBought(Scanner myScanner) {
        System.out.print("How many tickets would you like? ");
        int numOfTickets = Integer.parseInt(myScanner.nextLine());
        System.out.println(); // new line to seperate reservationSummary

        return numOfTickets;
    }

    private static String getArrivalDate(Scanner myScanner) {
        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String arrivalDate = myScanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate formattedArrivaldate = LocalDate.parse(arrivalDate, formatter);

        return formattedArrivaldate.toString();
    }

    private static String getName(Scanner myScanner) {
        System.out.print("Please enter your name: ");
        String fullName = myScanner.nextLine();

        return fullName;
    }
}
