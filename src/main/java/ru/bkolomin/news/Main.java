package ru.bkolomin.news;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.bkolomin.news.model.NewsItem;
import ru.bkolomin.news.parsers.Parser;
import ru.bkolomin.news.parsers.ParserD3;
import ru.bkolomin.news.util.Wiki;

import javax.sql.DataSource;
import java.io.*;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.util.stream.Collectors.toList;


//https://jsoup.org/apidocs/index.html?org/jsoup/select/Selector.html


public class Main {

    public void testParsers(){

        ArrayList<NewsItem> newsItems = new ArrayList<>();


        Parser parser = new ParserD3();
        parser.getNewPages(newsItems);


        for(NewsItem newsItem: newsItems){

            System.out.println(newsItem);

        }

    }

    private static long fib2(int i){

        long rez;

        if(i == 0) {
            rez = 0;
        }else {
            if (i == 1) {
                rez = 1;
            } else {
                rez = fib2(i - 1) + fib2(i - 2);
            }
        }

        return rez;

    }

    private static long fib1(int i){

        long sum = 0;

        if(i == 0) {
            sum = 0;
        }else {
            if (i == 1) {
                sum = 1;
            } else {
                long sum2 = 0;
                long sum1 = 1;

                for(int j = 2; j <= i; j++){

                    sum = sum2 + sum1;

                    sum2 = sum1;

                    sum1 = sum;

                }
            }
        }

        return sum;

    }


    private static long fib10(long i){

        long sum = 0;

        if(i == 0) {
            sum = 0;
        }else {
            if (i == 1) {
                sum = 1;
            } else {
                long sum2 = 0;
                long sum1 = 1;

                for(long j = 2; j <= i; j++){

                    sum = sum2 + sum1;

                    sum = sum % 1000000;

                    sum2 = sum1;

                    sum1 = sum;

                }
            }
        }

        return sum;

    }

    /*Write a program that prints the numbers from 1 to 100.
     But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”.
      For numbers which are multiples of both three and five print “FizzBuzz”.*/
    public static void FizzBuzz(){

        for(int i = 0; i < 100; i++){

            String rez = "";

            if(i % 3 == 0)
                rez = rez + "Fizz";

            if(i % 5 == 0)
                rez = rez + "Buzz";

            System.out.println(rez.isEmpty()? i: rez);

        }

    }

    public static int nod1(int a, int b){

        int d;

        for(d = Math.min(a, b); d > 0; d--){
            if(a % d == 0 && b % d == 0)
                return d;
        }

        return 0;

    }

    /*Большее число делим на меньшее.
    Если делится без остатка, то меньшее число и есть НОД (следует выйти из цикла).
    Если есть остаток, то большее число заменяем на остаток от деления.
    Переходим к пункту 1.*/

    public static int nod_evklid_rec(int a, int b){

        int mod;

        int min = Math.min(a, b);
        int max = Math.max(a, b);


        mod = max % min;

        if(mod == 0)
            return min;
        else
            return nod_evklid_rec(min, mod);
    }


    /*Большее число делим на меньшее.
    Если делится без остатка, то меньшее число и есть НОД (следует выйти из цикла).
    Если есть остаток, то большее число заменяем на остаток от деления.
    Переходим к пункту 1.*/
    public static int nod_evklid_loop(int a, int b){

        while(a != 0 && b != 0){

            if(a > b)
                a = a % b;
            else
                b = b % a;

        }

        return a+b;

    }

    public static String minimumBribes(int[] q){

        int num = 0;

        for(int i = 0; i < q.length; i++){

            //int delta = q[i] - q[i + 1];

            int delta = q[i] - (i + 1);

            if(delta > 2){
                return  "Too chaotic";
            }else if(delta > 0){
                num += delta;
            }

        }
        return  String.valueOf(num);

    }



    public static void main(String [] args){

        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();

        String text = Wiki.getText(18);

        System.out.println(text);

    }

}
