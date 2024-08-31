import java.util.Scanner;
import java.util.ArrayList;
public class MyProgram

{
    public static void main(String[] args)
    {
        
        Scanner input = new Scanner (System.in);
        
        
        
        String LastResult = "";
        
       // Find N and Q values 
        System.out.println("Enter N and Q");
        int N = input.nextInt();
        System.out.println("-");
        input.nextLine();
        int Q = input.nextInt();
        
        System.out.println("Enter Keyword");
        String fill = input.nextLine();
        String key = input.nextLine();
        
        
        int x = 0;
        
        ArrayList<String> k = new ArrayList<String>();
            String words[] = key.split(" ");
            for(int i = 0; i < words.length; i++)
            {
                k.add(words[i]);
                
            }
    
        // FIND instances that whish to be removed
        while(x < Q){
        System.out.println("Enter L and R along with Result: ");
        int L = input.nextInt();
        System.out.println("-");
        input.nextLine();
        int R = input.nextInt();
        System.out.print(": ");
        Boolean Prediction = input.nextBoolean();
        
        
        //Final Result (Ex: NYNNY)
        
        //Array consisting of the Key, Resets every itteration of while loop
        ArrayList<String> temp = new ArrayList<String>();
        
       // String str = "";
        ArrayList<Boolean> temp1 = new ArrayList<Boolean> ();
        
        //Removes L -> R
        for(int i = L - 1; i < R; i++)
        {
            temp.add(k.get(i));
            temp1.add(Boolean.parseBoolean(k.get(i)));
        }
        Boolean F = true;
        // Checks "New" Key case
        for(int i = 0; i < temp.size(); i++)
        {                                               
            System.out.println(i + "  " + temp.get(i));
            if (temp.get(i).equals("and")) {
                //boolean and of left and right string of and operator
                F = temp1.get(i-1) & temp1.get(i+1);
                
                temp.remove(i+1); temp.remove(i); temp.remove(i-1);
                System.out.println("Result = "+F+"  For i ="+i);
                temp1.set(i-1,F);
        } 
        }
        for(int i = 0; i < temp.size(); i++)
        {                                               
            System.out.println(i + "  " + temp.get(i));
            if (temp.get(i).equals("or")) {
                //boolean or of left and right string of and operator
                F = temp1.get(i-1) | temp1.get(i+1);
                 
                temp.remove(i+1 ); temp.remove(i); temp.remove(i-1);
                temp1.set(i-1, F);
        }   
        }
        
        //Adds to Final result (N or Y)
        if(F == Prediction)
        {
       
        LastResult += "Y";
        }
        else 
        {
    
        LastResult += "N";
        }
}



System.out.println(LastResult);





}

}
