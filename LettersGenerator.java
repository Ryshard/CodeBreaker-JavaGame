/**********************************************************
*   Author: Gabriel Garus
*   Assignment: WE21,  codebreaker assignment, Digital Skills Academy
*   Student ID: D09122844
*   Date : 2013/07/14
*   Ref: 
***********************************************************/


public class LettersGenerator {
  char[] letters;
  
    public LettersGenerator()
    {
      letters = new char[7];
      letters[0] = 'R';
      letters[1] = 'O';
      letters[2] = 'Y';
      letters[3] = 'G';
      letters[4] = 'B';
      letters[5] = 'I';
      letters[6] = 'V';  
    }

  

    public char[] getLetters(int aCodeLength)
    {
        char[] randomLetters;
        randomLetters = new char[aCodeLength];
        
        char randomLetter;
        
        for (int i=0; i<aCodeLength; i++)
           {
           int randomNum = getRandom(letters.length)-1;
           randomLetter = letters[randomNum];
           randomLetters[i] = randomLetter;
           }
        
        
        return randomLetters; 
    }
    
     
       public int getRandom(int sides)
		{
			return( 1 + (int) (Math.random() * sides));

		}     
           
    
    
    
    
    
    
    
    
    
    
    
    
}


