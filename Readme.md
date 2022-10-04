# connect4 scala
Connect4 in Scala! For interviewing people who know some scala.

## Playing
```bash 
> sbt run
```

## Run the tests
```bash 
> sbt test
```
    
## User Requirements

```
As a Player,
I want to be able to select a column
So that I can play the game
```

```
As a Player,
I want to have a different identifier for my pieces
So that I know which pieces are mine
```

```
As a Player,
I want to be able to win by connecting 4 of my characters horizontally
So that I can beat my opponent
```

```
As a Player,
I want to be able to win by connecting 4 of my characters vertically
So that I can beat my opponent
```

```
As a Player,
I want to be able to win by connecting 4 of my characters diagonally
So that I can destroy my opponent
```

```
As a Games Master,
I want to be able to only accept column numbers
So that I know which column to insert the piece for that player
```

```
As a Games Master,
I do not want Players to be able to insert their pieces into columns which are already full
So that I can keep play within bounds
```

```
As a Games Master,
When there's no more room to insert pieces and there's no winner
I want to declare the game a draw
```


```
