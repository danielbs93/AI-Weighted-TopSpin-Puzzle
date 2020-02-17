# AI-Weighted-TopSpin-Puzzle
Solving Weighted TopSpin Puzzle by using single agent search
## Description
In this project we will solve Weighted TopSpin Puzzle problem using basic search algorithms and hueristics.
Weighted in terms of in each operation we do in the TopSpin Puzzle there is a cost for those operations.
The game is constructed with 2 rings: outer ring - includes 20 disks numbered from 1 to 20.
                                      inner ring - includes 4 disks.

3 Main Operations: 
1. Swift Left outer ring --> 10|9|8|7|6|5|4|3|2|1|20|19|18|17|16|15|14|13|12|11 {becomes} 9|8|7|6|5|4|3|2|1|20|19|18|17|16|15|14|13|12|11|10 
2. Swift Right outer ring --> 10|9|8|7|6|5|4|3|2|1|20|19|18|17|16|15|14|13|12|11 {becomes} 11|10|9|8|7|6|5|4|3|2|1|20|19|18|17|16|15|14|13|12
3. Swap inner ring --> 10|9|8|7|6|5|4|3|2|1|20|19|18|17|16|15|14|13|12|11 {becomes} 10|9|8|7|6|5|4|3|19|20|1|2|18|17|16|15|14|13|12|11
* Cost of Left/Right are 0 and cost of Swap is is the values in the inner ring (from the example above it's 20+2+1+19)
Goal: Sortted TopSpin Puzzle(Sorted array)

## Uses
4 main algorithms to solve Weighted TopSpin Puzzle:BFS, UCS, A-Star, PHS.

Each Algorithm has Class and must implement next methods:

· initLists – initilize open and closed lists.

· getOpen – check if a vertex is in open list and return it, else return null.

· isOpen – true if the vertex is in open list, false otherwise.

· isClosed - same as above for close list.

· addToOpen – add a vertex to open list.

· addToClosed – same as above for close list.

· openSize – return the open list size.

· getBest – return the best vertex according to the algorithm we use.

## Credits
Developed and solved by Daniel Ben Simon & Eran toutian

Students 4th year of Information and Software Systems Engineering, Ben Gurion University of the Negev, Israel.

More about this game: http://www.geekyhobbies.com/top-spin-puzzle-review-solution/
