package common;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	Scanner sc = new Scanner(System.in);
	int result;
	String resultString;
	public int saisirNombre() {
		do
		{
		    try
		    {
		        resultString = sc.nextLine();
		        result = Integer.parseInt(resultString);
		    }
		    catch (NumberFormatException exception)
		    {
		        System.out.println("Veuillez entrer un nombre");
		        result = -1;
		    }
		}
		while (result == -1);
        return result;
	}
}

