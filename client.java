import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class client {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("192.168.2.33", 4999); 
        Scanner in = new Scanner(System.in);
        System.out.println("------------ Kangaroo Words ------------");
        System.out.println("==================================");
        System.out.print("Enter Word : ");
        String word1 = in.nextLine();
        System.out.print("Enter word do you want to find : ");
        String fWord = in.nextLine();
        System.out.println("==================================");
        PrintWriter p = new PrintWriter(s.getOutputStream());
        p.println(word1);
        p.flush();
        p.println(fWord);
        p.flush();
        InputStreamReader i = new InputStreamReader(s.getInputStream());
        BufferedReader Bf = new BufferedReader(i);
        String a = Bf.readLine();
        System.out.println("Server : "+ a);
        s.close();
        in.close();
        p.close();
        i.close();
        Bf.close();
    }
}