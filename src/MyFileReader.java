import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MyFileReader {

    public String getAbsolutePath(String path){
        Path file = Paths.get(path);
        if(file.isAbsolute()){
            return path;
        }
        else {
            try {
                return file.toAbsolutePath().toString();
            } catch (Exception e) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Некорректное имя пути к файлу, введите еще раз: ");
                String newPath = scanner.nextLine();
                getAbsolutePath(newPath);
            }
        }
        return path;
    }
}
