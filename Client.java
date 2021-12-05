import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args){
        try (Socket clientSocket = new Socket("127.0.0.1", 23444);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("Соединение с сервером установлено");

            System.out.println(in.readLine());
            String number = reader.readLine();
            out.println(number+"\n");
            String serverWord = in.readLine();
            System.out.println(serverWord);
        } catch (IOException e){
            System.err.println(e);
        }
    }
}
