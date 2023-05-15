**Introduction** 

***STREAK*** is a one- or two-player card game that uses a standard deck of playing cards where each player is dealt a hand of cards.  The object of the game is to have the longest possible streak of consecutive ranks when the hard is sorted into ascending order of rank. The number of points awarded to a player is the length of the streak achieved, with a bonus of one point if the streak is of cards of a single colour and a bonus of two points if the streak is of cards of a single suit. 

For example, for a sorted hand of 5 cards, scoring might be as follows  



|**Hand** |**Score** |**Commentary** |
| - | - | - |
|5♠  10♦  J♣  Q♠  A ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)♦![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)|3 |The consecutive 3-card streak consisting of 10, Jack, Queen |
|5♦  10♠  J♣  Q♠  A ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)♦![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)|4 |The consecutive 3-card streak consisting of 10, Jack, Queen plus a bonus point for a run of a single colour |
|5♦ 10♠  J♠  Q♠  A ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)♦![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)|5 |The consecutive 3-card streak consisting of 10, Jack, Queen plus two bonus points for a streak of a single suit |

After the cards have been dealt and sorted, a player can attempt to improve their longest streak by nominating a card from their hand to be exchanged for one dealt from the remaining cards in the deck. The nominate and exchange process can be repeated for as many times as cards that were originally dealt. For example, in a 5-card game, up to 5 cards can be exchanged; in a 6-card game, up to 6 cards can be exchanged, and so on.  

In a one-player game, a single hand of cards is dealt and played, but a two-player game consists of three hands where the winner is the player with the highest cumulative score after all hands have been played.  

**Challenge** 

This task is to produce a computer-based version of ***STREAK*** for **1 or** **2 players** and a **hand size of between 5 and 10 cards**. After the number of cards in a hand has been selected, the hand is dealt, and the player’s cards are sorted by ascending rank and are revealed. A player can then nominate a card to be replaced by one dealt from the deck in a process that can be repeated a number of times up to the size of the hand. In a 2-player game, the first player makes all their nomination and exchange selections and receives their score before the second player takes their turn. 

|**HAND 1:** ||
| - | :- |
|||
|Player1 ||
|<p>2 3 5 7 K (longest streak is 2)  ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)</p><p>    </p>|<p>Player1 exchanges K![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)</p><p></p>|
|<p>2 3 5 6 7 (longest streak is 4 – including colour bonus) ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)</p><p>    </p>|<p>Player1 exchanges 2![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)</p><p></p>|
|<p>3 5 6 7 A (longest streak is 4 – including colour bonus) ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)</p><p>    </p>|<p>Player1 exchanges A ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)</p><p></p>|
|<p>3 5 6 7 J (longest streak is 4 – including colour bonus) ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)</p><p>    </p>|<p>Player1 exchanges J ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)</p><p></p>|
|<p>3 5 6 6 7 (longest streak is 4 – including suit bonus)  ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)</p><p>    </p>|<p>Player1 exchanges 6![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)</p><p></p>|
|3 4 5 6 7 ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png) (longest streak is 5)  ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.003.png)|All 5 exchanges done |
|||
|Player2 ||
|<p>6 7 10 K  A   (longest streak is 4 – including suit bonus)  ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)</p><p>    </p>|<p>Player2 exchanges 10![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)</p><p></p>|
|<p>2 6 7 K  A (longest streak is 4 – including suit bonus)  ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)</p><p>    </p>|<p>Player2 exchanges 2![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)</p><p></p>|
|6 7 Q K  A ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)   (longest streak is 5 – including suit bonus)  ![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.002.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)![](Aspose.Words.0e6c49d2-4b44-4b75-bb7d-38d233d3e0c1.004.png)|Player2 sticks |
|||
|**Current score** ||
|Player1   5   Player2   5 ||
|||
|**HAND 2** ||
|… ||
|||
|**HAND 3:** ||
|**…** ||
|||
|**Final score** ||
|Player1   10  Player2   8 ||
**Required Functionality** 

There are 8 levels to which the submission can be completed – attracting increasing rewards. 

**Level 1:** A single player is dealt 5 cards from a shuffled deck which are displayed sorted in 

ascending order of rank. 

**Level 2:** The application automatically reports the length of the longest streak of 

successive ranks. 

**Level 3:** The user can change up to 5 cards, one at a time, with the aim of creating the 

longest possible streak of successive rank values. 

**Level 4:** A number of points is calculated as the length of the longest streak. A bonus point 

is awarded if the longest streak consists of cards of the same colour, while two bonus points are awarded if the longest streak consists of cards of the same suit. 

**Level 5:** The number of cards (both that to be dealt and the maximum number that can be 

changed is variable in the range 5-10. The number of cards is selected by the player before the hand is dealt. 

**Level 6:** A 2-player game is provided where the first player plays out their turn and 

receives a score before the second player begins. The winner of a 2-player game is that with the highest total score after 3 hands are played. 

**Level 7:** A high-score table holding the name and score for the 5 best single-hand 

performances (i.e., the 5 best streaks when colour and suit bonuses are included) is implemented. The high-score table can be viewed on demand before and after each match. 

**Level 8:** Following a single-player game (only), the player is offered the opportunity to view a replay in which each hand and choice of card to be replaced is displayed. 
