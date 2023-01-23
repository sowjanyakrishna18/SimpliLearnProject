package web.LockedMe.com;

import java.io.IOException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LockerMain {

	public static void main(String[] args) throws Exception {
		//display welcome screen
		
		System.out.println("------------------------------------");
		System.out.println("LockedMe.com\nDeveloped by G Krishna Sowjanya");
		System.out.println("------------------------------------");
		availableOptions();
		
	}
	
public static void availableOptions() throws Exception
{
	/*
	 * displaying the user interaction information 
	 * The first option should return the current file names in ascending order
	 * The root directory can be either empty or contain few files or folders in it
	 */
	
	Locker l1= new Locker();
	Scanner sc=new Scanner(System.in);
	try
	{
	outer:while(true)
	{
	
	
	System.out.println("enter the option from the following\n");
	System.out.println("1.Display current files in the directory\n");
	System.out.println("2.Add/Delete/Search for a file\n");
	System.out.println("3.go back to main menu\n");
	System.out.println("4.exit from the application");
	int option=sc.nextInt();
	switch(option)
	{
	case 1:
		
		String[] files=l1.getFiles();
		if(files.length==0)
		{
			System.out.println("files are empty");
		}
		else
		{
			System.out.println("Current files in the directory");
			for(String s:files)
				System.out.println(s);
		}
		break;
	case 2:
		System.out.println("a.Add\nb.Delete\nc.Search");
		String input=sc.next();
		switch(input)
		{
		case "a":
			System.out.println("enter the file name");
			String inputfile=sc.next();
			l1.addFile(inputfile);
			break;
		case "b":
			if(l1.getFiles().length==0)
			{
				System.out.println("files are empty");
			}
			else
			{
			System.out.println("enter the file name to be deleted");
			String filename=sc.next();
			l1.deleteFile(filename);
			//System.out.println("Delete a user specified file from the existing directory list");
			}
			break;
			
		case "c":
			if(l1.getFiles().length==0)
			{
				System.out.println("There are no availble files for the search.Directory is empty");
			}
			else
			{
			System.out.println("Enter the file to be search from main directory");
			String searchfilename=sc.next();
			
			if(l1.searchFile(searchfilename)>=0)
				System.out.println("file is available in the directory");
			else
				System.out.println("file is not available in the directory");
			}
			break;
			
		default:
			System.out.println("option not available");
			break;
		}
		
		break;
	case 3:
		System.out.println("going back to main menu");
		continue outer;
	case 4:
		System.out.println("application is closed");
		System.exit(0);
	}
	System.out.println("Do you wanted to continue y/n");
	String loop=sc.next();
	if(loop.equalsIgnoreCase("n"))
	{
		System.out.println("applciation closed");
		break;
	}
	
	}
	}
	catch(InputMismatchException e)
	{
		System.out.println("input mismatch: please enter the valid input");
	}
	
	finally
	{
		sc.close();
		
	}
	
}
}
