***Btw, I warned that it is going to be a lot of coding //at least we are not dealing with graphics, phew
--- 
This is a devlog file for the Adventure game we are building. Please add commited changes into the devlog with appropriate signature.
+
Game structure and explanations
  -Gameflow-
  Player is greeted by some text
  Player is prompted to enter characters name and choose class for the character from the list
  Player is given a mission to defeat the boss of the dungeon to protect the kingdom(lore doesn't really matter; you 
  can change it on your discretion)

  Player is moved to the beginning of the dungeon with coordinates of 0,0
  *?Note - I am not sure how to implement rooms 
    *I can make a class for each room type or create a big class that encompasses all rooms
  Player is given a set of commands that he can do: walk North/South/West/East, search the room(chance to fight enemies or find loot),
   rest
  Player must travel through at least 5 rooms of which: 3 enemy rooms, 1 loot room, 
    1 puzzle room, in order to find boss room and finish quest 
  In boss room, player fights boss - if victory then end of the game and some lore - otherwise player restarts the game or quits


---

Devlog 1.0(Max)
- created raw outline of the game - main, player class, monster class - no map or rooms yet
