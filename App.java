/**********************************************************
*   Author: Gabriel Garus
*   Assignment: WE21,  codebreaker assignment, Digital Skills Academy
*   Student ID: D09122844
*   Date : 2013/07/14
*   Ref: 
***********************************************************/

import javabook.*;

public class App {

 MainWindow mBox; 
 OutputBox oBox;
 InputBox iBox;


 int lives = 8;
 int codeLength = 4;


 //objects

 LettersGenerator code = new LettersGenerator();
 Validator hal = new Validator();



 int currentLives = lives;
 char[][] userCodes = new char[lives][codeLength];
 char[] userCode = new char[]{'_','_','_','_',};
 char[] partCode = new char[]{'_','_','_','_',};
 int hint;
 char[] randomCode;
       
        
 
 String userString;

 
public App()
	{
                
		mBox = new MainWindow();
		iBox = new InputBox(mBox);
		oBox = new OutputBox(mBox,980,650, "The Code Breaker Game");

		mBox.show();
		gameBoard();

		System.exit(0);
	} 
 
 
 
 
 //*******************************************************
	private void gameBoard()
	{
			boolean playAgain = false;
			String userInput;
			char firstLetter;
		do
		{
			oBox.clear();
			playGame();

			userInput = iBox.getString("Play Again?  Y / N");

			firstLetter = userInput.charAt(0);
			if (firstLetter == 'Y' || firstLetter == 'y')
				{
					playAgain = true;
				}
			else
			{
				playAgain = false;
			}

		}
		while (playAgain);

	} //end of GameBoard


	//*****************************************

    
public void playGame()
        {
        boolean codeGuessed = false; 
        boolean badInput = false;
        boolean codeUsed = false;
        String aMessage = " ";
        
        // reseting arrays
        for (int q=0; q<codeLength; q++)
        {
            userCode[q] = '_';
            partCode[q] = '_';
        }
        // reseting current Lives
        currentLives = lives; 
          
                
        //get random code array
        randomCode = new char[codeLength];
        randomCode = code.getLetters(codeLength);
       
       // for testing purposes print generated code
        System.out.println(randomCode);
    
        
        mBox.setVisible(true);
        oBox.setVisible(true);
          
         startScreen();
     
     
     for (int x=0; x<lives; x++)
     {
           gameMessage();
           
           aMessage = " ";
        do
            {
                           
                //get user input
                userString = iBox.getString(aMessage + "please enter your guess");
           
                //validate input
                badInput = hal.validateCode(userString, code.letters.length, codeLength);
                aMessage = hal.getMessage();
                if (badInput == false)
                {
                  //save input string into Array 'userCode'
                   for (int i=0; i<codeLength; i++)
                  {
                       userCode[i] = Character.toUpperCase(userString.charAt(i));
                  }
                  
                  //check if userCode has been used already
                  codeUsed = hal.compare2Arrays(userCode, userCodes);
                  if(codeUsed)
                  {
                      badInput = true;
                      aMessage = "Code already used. ";
                  }
                }
             }
            while(badInput);
    
      
    
        //check if WIN - Compare userCode Array with randomCode Array
         codeGuessed = hal.compareArrays(userCode,randomCode);


        // check if any of the letters is correct (partial guess)
          for (int a=0; a<codeLength; a++)
          {
              if(userCode[a] == randomCode[a])
              { partCode[a] = randomCode[a]; }
              else
              { partCode[a] = '_';}
          }
   
         // check for hints 
         hint = hal.getHints(userCode,randomCode,codeLength); 
           
   
        //IF win - end Game Loop    
        if (codeGuessed)
        {break;}
        else
        {
           // save userCode into array with all entered codes
            for (int i=0; i<codeLength; i++)
              {
                  userCodes[x][i] = userCode[i];
              }
        
            currentLives--;
          
        }
  
  } // end of main game loop        
    
 gameMessage();
 
    if (codeGuessed)
    {
        oBox.println("*****************************");
        oBox.println("Congratulations, You WON!!!!!");
        oBox.println("*****************************");
    }
   else
    {
        oBox.println("You Loose....");
        oBox.println("Code Was: " );
        for (int i=0; i<codeLength; i++ )
             {
                oBox.print(randomCode[i] + " ");
             }
    }

}


//**************************************************************
public void startScreen()
{
   oBox.clear();
     oBox.println("Try to guess the sequence of 4 colors.");
     oBox.println("The possible colors are");
     oBox.println("R - Red");
     oBox.println("O - Orange");
     oBox.println("Y - Yellow");
     oBox.println("G - Green");
     oBox.println("B - Blue");
     oBox.println("I - Indigo");
     oBox.println("V - Violet");
     oBox.println("You have " + lives + " chances to guess the code.");
     oBox.println("----------------------------------------------------");
     oBox.println("Please enter " + codeLength + " characters,");
     oBox.println("At any time you can enter '0' to exit the program.");
     oBox.println("Characters allowed:");    
     for (int t=0; t<code.letters.length; t++)
      { oBox.print(code.letters[t] + " ");}

     oBox.println(" ");
     oBox.println("-----------------------");   
     oBox.println("Start: ");   
       
}

//****************************************************************

  public void gameMessage()
  {
      oBox.print("You entered: ");
        for (int u=0; u<codeLength; u++)
        {
            oBox.print(userCode[u] + " ");
        }
          oBox.print(" || ");
         
          oBox.print("Code: ");
          for (int k=0; k<codeLength; k++)
            {
               oBox.print(partCode[k] + " ");
            }
          oBox.print(" || ");
          
          oBox.print("Hints: " + hint);
          oBox.print(" || ");
          
          oBox.print("Lives: " + currentLives);
          oBox.println(" ");
  }
   
  public static void main(String[] args) 
  {
          App codeBreaker = new App();
  }

}