package com.hivemq.cli.utils;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordUtils {

    public static char[] readPassword(String... args) throws IOException {
        if (args.length > 1) throw new IllegalArgumentException();
        String promptMessage = "";
        if (args.length == 1) {
            promptMessage = args[0];
        }

        Console console = System.console();
        if (console != null) {
            return console.readPassword("%s", promptMessage);
        }
        else { // Safe password prompt is not possible - maybe called program from IDE?
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(promptMessage);
            return in.readLine().toCharArray();
        }

    }

}
