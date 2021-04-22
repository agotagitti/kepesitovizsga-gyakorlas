package gyaxi.kviz;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Hm {
    public static String findDay(int month, int day, int year) {
        LocalDate localDate = LocalDate.of(month, day, year);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(dayOfWeek);
        String dayString = dayOfWeek.toString();
        System.out.println(dayString);
        return dayString;
    }

    public static void main(String[] args) {

        System.out.println(findDay(12, 5, 31));

    }
}