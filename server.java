import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serv = new ServerSocket(4999);
        Socket s = serv.accept();
        System.out.println("client Connected");
        InputStreamReader input = new InputStreamReader(s.getInputStream());
        BufferedReader Bf = new BufferedReader((input));
        String w1 = Bf.readLine();
        String w2 = Bf.readLine();
        System.out.println("==================================");
        System.out.println("Entered Word From Client : " + w1);
        System.out.println("Entered Word that Client want to find : " + w2);
        System.out.println("==================================");
        PrintWriter p = new PrintWriter(s.getOutputStream());
        int i, j=0, k=0;
        int c1 = w1.length();
        int c2 = w2.length();
        char[] z1 = w1.toCharArray();
        char[] z2 = w2.toCharArray();

        for(i=0;i<c1;i++){
            if(z1[i] == z2[j]){
                j++;
                if(j == c2){
                    k = 1;
                }
            }
        }

        if(k == 1){
            p.println("There is a word \" " + w2 +  "\" hidden in the word \"" + w1 + "\".");
        }
        else{
            p.println("The word \" " + w2 +  "\" is not hidden in the word \"" + w1 + "\".");
        }
    
        p.flush();
        serv.close();
        s.close();
        input.close();
        Bf.close();
        p.close();
    }
    
}
