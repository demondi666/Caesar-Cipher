import java.io.*;
import java.util.Scanner;

public class UI {
    private Scanner scanner = new Scanner(System.in);

    public void initialization(){
        MyFileReader reader = new MyFileReader();
        CaesarCipher caesarCipher;
        System.out.print("Введите путь к файлу: ");
        String filePath = reader.getAbsolutePath(scanner.nextLine());
        System.out.print("Введите \"Caesar\", если хотите зашифровать или введите \"Brute\", чтобы дешифровать файл: ");
        String command = scanner.nextLine();
        if(command.equalsIgnoreCase("Caesar")){
            System.out.print("Введите отступ в шифре: ");
            int offset = scanner.nextInt();
            caesarCipher = new CaesarCipher(offset);
            StringBuilder text = readFromFile(filePath);
            StringBuilder encryptText =  caesarCipher.encrypt(text);
            writeToFile(filePath, encryptText);
            System.out.println("Файл зашифрован!");
        } else if (command.equalsIgnoreCase("Brute")) {
            System.out.print("Введите отступ в шифре или \"-\": ");
            if(scanner.hasNextInt()){
                int offset = scanner.nextInt();
                caesarCipher = new CaesarCipher(offset);
                StringBuilder text = caesarCipher.decoding(readFromFile(filePath));
                writeToFile(filePath, text);
                System.out.println("Файл расшифрован!");
            }
            else if(scanner.nextLine().equals("-")){
                BruteForce bruteForce = new BruteForce();
                StringBuilder text = bruteForce.decoding(readFromFile(filePath));
                writeToFile(filePath, text);
                System.out.println("Файл расшифрован!");
            }
        }
        else {
            System.out.println("Вы ввели некоректную программу, повторите ввод!");
            initialization();
        }

    }

    private StringBuilder readFromFile(String path){
        StringBuilder text = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()){
                text.append(reader.readLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл!");
        } catch (IOException e) {
            e.getStackTrace();
        }
        return text;
    }
    private void writeToFile(String path, StringBuilder text){
        try(BufferedWriter writer =  new BufferedWriter(new FileWriter(path))) {
            writer.write(text.toString());
            writer.flush();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

}
