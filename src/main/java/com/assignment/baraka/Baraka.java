

package com.assignment.baraka;

import io.github.cdimascio.dotenv.Dotenv;

public class Baraka {

    public static void main(String[] args) {
        
         Dotenv dotenv = Dotenv.load();

        System.out.println("Hello World!");
        System.out.println(dotenv.get("DB_USER"));

    }
}
