package program;

import java.io.File;

import javax.swing.JFileChooser;

public class FileOperations {
	
	//get full path of a file
	public void attachFile(String filePath) {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File file =chooser.getSelectedFile();
		filePath = file.getAbsolutePath();
	}
	
	//convert image to bytes array then insert it into DB
	public void convertImageToBLOB() {
		//TODO: Handle this method
	}
	
}
