package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	
	// frame and buttons
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addTask = new JButton();
	JButton viewTasks = new JButton();
	JButton removeTask = new JButton();
	JButton saveList = new JButton();
	JButton loadList = new JButton();
	
	ArrayList<String> tasks = new ArrayList<String>();
		
	public static void main(String[] args) {
		
		ToDoList tdl = new ToDoList();
		tdl.setup();
		
	}
	
	public void setup() {
		frame.add(panel);
		frame.setVisible(true);
		addTask.setText("Add Task");
		viewTasks.setText("View Tasks");
		removeTask.setText("Remove Task");
		saveList.setText("Save List");
		loadList.setText("Load List");
		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		addTask.addActionListener(this);
		viewTasks.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		frame.pack();
		
		BufferedReader br;
		
		try {
			br = new BufferedReader(new FileReader("src/_03_To_Do_List/ a bunch of tasks"));
			String line = br.readLine();
			while (line != null) {
				tasks.add(line);
				line = br.readLine();
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == addTask) {
			String thing = JOptionPane.showInputDialog("Add new task: ");
			tasks.add(thing);
		} else if (e.getSource() == viewTasks) {
			String thingy = "";
			for (String s : tasks) {
				thingy += s + "\n";
			}
			JOptionPane.showMessageDialog(null, thingy);
		} else if (e.getSource() == removeTask) {
			String thingamabob = "";
			for (int i = 0; i < tasks.size(); i++) {
				thingamabob += (i + 1) + ". " + tasks.get(i) + "\n";
			}
			int num = Integer.parseInt(JOptionPane.showInputDialog(thingamabob + "\nType the number of a task to delete: "));
			tasks.remove(num - 1);
		} else if (e.getSource() == saveList) {
			
			String fileName = JOptionPane.showInputDialog("Type the name of the file: ");
			
			try {
				
				FileWriter fw = new FileWriter("src/_03_To_Do_List/" + fileName);
				for (String s : tasks) {
					fw.write(s + "\n");
				}
				fw.close();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			
		} else if (e.getSource() == loadList) {
			
			try {
				
				JFileChooser jfc = new JFileChooser();
				int returnVal = jfc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String fileName = jfc.getSelectedFile().getAbsolutePath();
					tasks.clear();
					
					BufferedReader br = new BufferedReader(new FileReader(fileName));
					String line = br.readLine();
					while (line != null) {
						tasks.add(line);
						line = br.readLine();
					}
					br.close();
				}
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}
	
}
