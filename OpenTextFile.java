import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OpenTextFile
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		int n, n2;
		ArrayList<String> a = new ArrayList<String>();
			
		// PROMPT WINDOW
		JOptionPane askWindow = new JOptionPane();
		String reservedWords = askWindow.showInputDialog("Enter external TextFile to open:");
		
		Scanner scanner = new Scanner(new File(reservedWords));
		
		// ORIGINAL TEXT WINDOW	
		JTextArea originalTextOutput = new JTextArea(10,30);
		JScrollPane scroll = new JScrollPane(originalTextOutput);
		
		while(scanner.hasNext())
		{
			String w = scanner.nextLine();
			originalTextOutput.append(w + "\n");
		}
		JOptionPane.showMessageDialog(null, scroll, "Opened file...\n",JOptionPane.INFORMATION_MESSAGE);
		
		// EDITTED TEXT WINDOW
		JTextArea newTextOutput = new JTextArea(10, 30);
		JScrollPane scroll2 = new JScrollPane(newTextOutput);
		
		Scanner scanner2 = new Scanner(new File(reservedWords));
		
		while(scanner2.hasNext())
		{
			String w2 = scanner2.nextLine();
			a.add(w2);
		}
		
		// SORT ALPHABETICALLY
		Collections.sort(a, String.CASE_INSENSITIVE_ORDER);
		
		for(int x = 0; x <= a.size() - 1; x++)
		{
			newTextOutput.append(a.get(x) + "\n");
		}
		JOptionPane.showMessageDialog(null, scroll2, "Results:\n",JOptionPane.INFORMATION_MESSAGE);
		
		// PROMPT WINDOW FOR SEARCH
		JOptionPane searchWindow = new JOptionPane();
		String word = searchWindow.showInputDialog("Enter the word needed for searching:");
		Scanner scanner3 = new Scanner(new String(word));
		String item = scanner3.next();
		
		// PROCESS SEARCIHNG
		JOptionPane ansWindow = new JOptionPane();
		if (a.contains(item))
			JOptionPane.showMessageDialog(ansWindow, "The term '" + word + "' FOUND in the text file.");
		else
			JOptionPane.showMessageDialog(ansWindow, "The term '" + word + "' NOT FOUND in the text file.");
	}
}
//http://stackoverflow.com/questions/20303944/java-how-to-search-a-word-from-text-file
//http://stackoverflow.com/questions/20418319/find-a-string-or-a-line-in-a-txt-file-java
