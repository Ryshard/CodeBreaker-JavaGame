/**********************************************************
*   Author: Gabriel Garus
*   Assignment: WE21,  codebreaker assignment, Digital Skills Academy
*   Student ID: D09122844
*   Date : 2013/07/14
*   Ref: 
***********************************************************/
import javabook.*;

public class Validator {
    
    String message = " ";
    
    public Validator ()
    {
        
    }
    String userString = "_";
    

      //******************************
     // Validating Input
    //******************************

public boolean validateCode(String userString, int lettersPool, int aCodeLength) 
    {
        LettersGenerator letGen = new LettersGenerator();
        boolean invalidInput = false;

          //exit at 0
            for (int d=0; d<userString.length(); d++)
            {  
              if (userString.charAt(d) == '0')  { System.exit(0); }
            }

            
             
              // check string length       
              if (userString.length() != aCodeLength)
                  {
                   message = "You are supposed to enter 4 colours. ";
                   invalidInput = true;
                  }
              else 
              {
                  // check if used allowed characters      
                  for (int i=0; i<aCodeLength; i++)
                  {
                   
                      char userLetter = Character.toUpperCase(userString.charAt(i));
                    
                      for (int j=0; j<lettersPool; j++)
                      {
                          if (userLetter != letGen.letters[j] ) 
                          { 
                              invalidInput = true;
                              message = "Invalid character used. ";
                             
                          }
                          else {invalidInput = false; break;}
                      }
                      if (invalidInput == true) {break;}
                  }

              }

                        
              
        return invalidInput;   
    }
    
    
public String getMessage()
    {
      return message;
    }
    




      //******************************
     // Comparing 2 given Arrays
    //******************************
public boolean compareArrays(char[] array1, char[] array2)
    {
        boolean samesame = false; 
        if (array1.length != array2.length)
        {System.exit(0);}
        else
        {
           for (int i=0; i<array1.length; i++) 
           {
               if (array1[i] == array2[i])
               {
                   samesame = true;
               }
               else
               {
               samesame = false; 
               break;
               }
           }      
        }
        
     return samesame;    
    }
    


       //******************************
     // Looking for clues / hints
    //******************************
public int getHints(char[] userCode, char[] randomCode, int codeLength)
{
  int hint1=0;
       boolean[] used = new boolean[]{false,false,false,false,};
       
       
       for (int b=0; b<codeLength; b++)
      {
          if (userCode[b] != randomCode[b])
          {
            for (int c=0; c<codeLength;c++)
            {
                if (userCode[b] == randomCode[c] && randomCode[c] != userCode[c] && used[c] == false)
                {
                    hint1++;
                    used[c] = true;
                    break;
                }
            }
          }
      }

      return(hint1);
}




      //******************************
     // Comparing 2 given Arrays - ArrayA(normal), ArrayB(multi-dimensional)
    //******************************

public boolean compare2Arrays(char[] arrayA, char[][] arrayB)
    {
        boolean arrayExists = false;
        boolean[] letterExists = new boolean[arrayA.length]; 
        int counter = 0;
        
        for (int i=0; i<arrayB.length; i++)
        {
           
            
            for(int j=0; j<arrayA.length; j++)
                {
                    if(arrayA[j] == arrayB[i][j])
                    {
                      letterExists[j] = true; 
                    }
                    else
                    {
                      letterExists[j] = false;  
                    }
               
                 }
            counter = 0; 
            
            for (int e=0; e<letterExists.length; e++)
               {
                   if(letterExists[e] == true)
                        {counter = counter + 1;}
                  
               }
            if (counter == letterExists.length)
               {
                   arrayExists = true;
                   break;
               }
               else
               {
                   arrayExists = false;
               }
            
        }
        
        
      
        
        return arrayExists;
    }

   
}