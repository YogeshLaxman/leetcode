class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    
    int width;
    int height;
    int[][] food;
    int foodIndex;
    Set<String> positions = new HashSet<>();
    LinkedList<String> snake = new LinkedList<>();
    int[] head;
    int score = 0;
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        int[] start = {0, 0};
        String key = "0#0";
        snake.addLast(key);
        positions.add(key);
        head = start;
        foodIndex = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] newHead = {head[0], head[1]};
        if (direction.equals("U")) {
            newHead[0]--;
        } else if (direction.equals("D")) {
            newHead[0]++;
        } else if (direction.equals("L")) {
            newHead[1]--;
        } else {
            newHead[1]++;
        }
        // System.out.println(snake);
        if (newHead[0] < 0 || newHead[1] < 0 || newHead[0] >= height || newHead[1] >= width) {
            return -1;
        }
        
        String key = newHead[0] + "#" + newHead[1];
        if (positions.contains(key) && !snake.getLast().equals(key)) {
            return -1;
        }
        
        if (foodIndex < food.length 
            && food[foodIndex][0] == newHead[0] && food[foodIndex][1] == newHead[1]) {
            score++;
            foodIndex++;
            positions.add(key);
            snake.addFirst(key);
            head = newHead;
            return score;
        }
        positions.remove(snake.removeLast());
        positions.add(key);
        snake.addFirst(key);
        head = newHead;
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */