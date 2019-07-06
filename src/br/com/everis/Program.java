package br.com.everis;

import javax.swing.JOptionPane;

public class Program {

	public static void main(String[] args) {

		CSVFileReader leitor1 = new CSVFileReader();

		String archiveName = JOptionPane.showInputDialog(null, "Informe o nome absoluto do arquivo");
		if (archiveName == null || archiveName.contentEquals("")) {
			JOptionPane.showMessageDialog(null, "Entrada vazia", "Erro", JOptionPane.ERROR_MESSAGE);

			return;
		}

		leitor1.readFile(archiveName);
		
		leitor1.printContent();
		

	}
}
