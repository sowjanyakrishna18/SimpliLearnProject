package web.LockedMe.com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Locker{

	private String[] files;
	private String currentDirectory = System.getProperty("user.dir");
	
	public void addFile(String filename) throws IOException
	{
		//File directoryPath = new File(currentDirectory);
		File newfile= new File(filename);
	      if(newfile.createNewFile())
	    	  System.out.println("new file created");
	      else
	    	  System.out.println("File already exists");
		
	}

	public String[] getFiles() {
		//Creating a File object for directory
		
	    //System.out.println("The current working directory is " + currentDirectory);
		File directoryPath = new File(currentDirectory);
		String files[] = directoryPath.list();
	    //System.out.println("List of files and directories in the specified directory:");
//	    for(int i=0; i<files.length; i++) 
//	    {
//	    System.out.println(files[i]);
//	    }
	    
		//String[] ArrayFiles=(String[]) files.toArray();
		
		for(int i=0;i<files.length;i++)
		{
			int min=i;
			for(int j=i+1;j<files.length;j++)
			{
				if(files[i].compareTo(files[j])>0)
					min=j;
			}
			if(min!=i)
			{
				String temp=files[i];
				files[i]=files[min];
				files[min]=temp;
			}
		}
		return files;
	}

	

	public void deleteFile(String filename) {
		//String[] existfiles=getFiles();
		boolean deleted=false;
		int index=searchFile(filename);
		
			if(index>1)
			{
				File deleteFile=new File(filename);
				if(deleteFile.delete())	
				{
					
					deleted=true;
		    	  System.out.println("File is deleted");
				}
			}
			
		if(!deleted)
			System.out.println(filename+" does not exist in the list");
			
		
	}

	public int searchFile(String filename) {
		String[] existfiles=getFiles();
		//boolean available=false;
		int firstIndex=0;
		int lastIndex=existfiles.length-1;
		while(firstIndex<=lastIndex)
		{
			int middleIndex=(firstIndex+lastIndex)/2;
			if(filename.compareToIgnoreCase(existfiles[middleIndex])==0)
			{
				return middleIndex;
			}
			else if(filename.compareToIgnoreCase(existfiles[middleIndex])>0)
			{
				firstIndex=middleIndex+1;
			}
			else if(filename.compareToIgnoreCase(existfiles[middleIndex])<0)
			{
				lastIndex=middleIndex-1;
			}
		}
		return -1;
		
	}

	

}
