/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sciencefair;

import java.io.*;
import java.util.*;
import java.time.*;

public class ScienceFair {
    static ArrayList<String> types;
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner (System.in);
        String actual;
        Instant before;
        Instant after;
        double compare;
        for (int i=0; i<25; i++) {
            before = Instant.now();
            actual = input.nextLine();
            find(actual);
            after = Instant.now();
            compare = (after.getNano()-before.getNano())/(Math.pow(10,9));
            System.out.println("Took "+compare+" seconds to find password");
        }
    }
    public static void find(String i) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/marshal/Downloads/passwords.txt"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("password.out")));
        
        String guess;
        
        while (true) {
                guess = br.readLine();
                if (guess == null) {
                    System.out.println("Password not found.");
                    break;
                }
                if (guess.equals(i)) {
                    pw.println(guess);
                    pw.close();
                    System.out.println("Password found: "+guess);
                    break;
                }
            }
    }
}
/*
25 MOST COMMON PASSWORDS

1. 123456

2. password

3. 12345

4. 12345678

5. qwerty

6. 123456789

7. 1234

8. baseball

9. dragon

10. football

11. 1234567

12. monkey

13. letmein

14. abc123

15. 111111

16. mustang

17. access

18. shadow

19. master

20. michael

21. superman

22. 696969

23. 123123

24. batman

25. trustno1
*/