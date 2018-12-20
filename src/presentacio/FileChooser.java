package presentacio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class FileChooser{

	public static File carregaFitxer() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getParentDirectory(new File(".")));
		int returnValue = jfc.showOpenDialog(null);
        File selectedFile = null;
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = jfc.getSelectedFile();
		}
        return selectedFile;
	}
}