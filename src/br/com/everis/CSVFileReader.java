package br.com.everis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * This class implements a file reader with data print.
 * 
 * @author Gustavo
 */
public class CSVFileReader {

	private Set<Book> library = new HashSet<Book>();
	private Book book;

	/**
	 * This method get a specific file and read line by line saving the content in a
	 * Collection Set(HashSet).
	 * 
	 * @param fileAbsolutName
	 */
	public void readFile(String fileAbsolutName) {

		try {
			/*
			 * Leitura do arquivo e inicialização do buffer de leitura
			 */
			FileReader file = new FileReader(fileAbsolutName);
			BufferedReader reader = new BufferedReader(file);

			String line = reader.readLine();// read de first line.

			/*
			 * While exists lines in file, the loop will execute.
			 */
			while (line != null) {

				String saveContent[] = line.split("[,]");// Cut the String using the "," and save in String Array..

				book = new Book();

				/*
				 * Assing the values saved in String Array to the book attributes.
				 */
				book.setTitle(saveContent[0]);
				book.setAuthor(saveContent[1]);
				book.setIsbn(saveContent[2]);
				book.setYear(Integer.parseInt(saveContent[3]));

				library.add(book);// Add the book informations in Set Colletion.

				line = reader.readLine();//Jump to the next line.
			}

			file.close();//Close de file stream.
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo");
			e.printStackTrace();
		}

	}

	/**
	 * This method print the information of Colletion library in console.
	 */
	public void printContent() {

		/*
		 * Data print.	
		 */
		for (Book book : library) {
			System.out.println(book.getTitle());
			System.out.println(book.getAuthor());
			System.out.println(book.getIsbn());
			System.out.println(book.getYear());
			System.out.println("");
		}

	}

}
