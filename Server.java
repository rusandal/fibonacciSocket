import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(
                ServerSocket serverSocket = new ServerSocket(23444);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
        {

            System.out.println("Новое соединение установлено");
            out.println("Введите число Фибоначи");
            String numberString = in.readLine();
            int number = Integer.parseInt(numberString);
            int[] arr = new int[number];
            arr[0] = 0;
            arr[1] = 1;
            Integer result = 0;
            for (int i = 2; i < arr.length; ++i) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            result = arr[number - 1];
            out.println("Число Фибоначи " + result);
            throw new BindException("Соединение разорвано");
        } catch (IOException e){
            System.err.println(e);
        }
    }
}
