# BlackJack  
### Description
This is terminal based project built on Java language using VS Code.  
  
```
Gamerunner.java  
  |- Suit.java  
  |- Card.java  
  |- Deck.java  
  |- Player.java  
```  
This project perform various function such as :
 - Create cards
 - Generate deck
 - Shuffle deck
 - Deal cards
### How to run this project
Step 1 : Download the source code files  
Step 2 : Open command prompt as administrator  
Step 3 : To change drive use DriveName: eg. **D:**  
Step 4 : To change directory/folder use cd FolderName eg. **cd Source Code Files**  
Step 5 : Compile the Gamerunner.java file using **javac Gamerunner.java**  
Step 6 : Run the compiled java file using **java Gamerunner.java**  
Suppose your command prompt started from C drive and downloaded folder is in D drive
```
C:\Users\Nitin>D:
D:\>cd Source Code Files
D:\Source Code Files> javac Gamerunner.java
D:\Source Code Files> java Gamerunner.java
```
### Gameplay
At start of the game 2 cards will be dealt to each player.  
Dealer's one card will be hidden revealed at end of game.
Players have two options **Hit** or **Stay**
On pressing **Hit** new card will be dealt.
On pressing **Stay** turn will skip.
#### Objective
To create sum **closer to 21** or **21**.  
The one who will have sum closer to 21 or 21 will **win**.
#### Rules  
The **Maximum** number of card **in hand** is **10**, you can't have more than 10 cards.  
The value of **Ace** can be changed to **1 or 11** according to requirement.  
### Working  
#### Generate Card
A card will be genearted using number from 1 to 13 where 1 = Ace and 11-13 = Face Cards and Suit.  
13 card of each suit will be created one by one.  
#### Generate Deck  
User have to enter number of deck he wants to play with.  
Number of deck * 52 cards will be created.  
#### Shuffle Deck  
Cards in deck will be shuffled in random order.  
#### Deal Cards  
New card will be dealt every time user **Hits**.  


