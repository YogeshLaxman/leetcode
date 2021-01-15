                    if( newX < 0 || newX >= forest.size() || newY < 0 || newY >= forest.get(0).size() || forest.get(newX).get(newY) == 0 || visitedHS.contains(temp)){
                        continue;
                    }
                     //System.out.println("FilTERED  newX: " + newX + " newY: " + newY);
                    if( newX == toPos[0] && newY == toPos[1]){
                        //System.out.println(" return currMoves***********: " + (currMoves + 1));
                        return currMoves + 1;
                    }
                    
                    int[] newCoord = {newX,newY};
                    q.add(newCoord);
                    visitedHS.add(temp);
                }
            }
            //System.out.println("currMoves increment " + currMoves);
            currMoves += 1;
            //System.out.println("currMoves incremented to: " + currMoves);
            
        }
        
        return -1;
        
    }
    
     public class Tree{
        int height;
        int row;
        int col;
        Tree(int h, int r, int c){
            height = h;
            row = r;
            col = c;
        }
    }
}
