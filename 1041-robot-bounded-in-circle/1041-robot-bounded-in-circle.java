class Solution {
    public boolean isRobotBounded(String instructions) {
        char currentDirection = 'N';
        int x = 0, y =0;
        for (int c: instructions.toCharArray()) {
            if (c == 'L') {
                if (currentDirection == 'N') {
                    currentDirection = 'W';
                } else if (currentDirection == 'W') {
                    currentDirection = 'D';
                } else if (currentDirection == 'D') {
                    currentDirection = 'E';
                } else {
                    currentDirection = 'N';
                }
            } else if (c == 'R') {
                if (currentDirection == 'N') {
                    currentDirection = 'E';
                } else if (currentDirection == 'W') {
                    currentDirection = 'N';
                } else if (currentDirection == 'D') {
                    currentDirection = 'W';
                } else {
                    currentDirection = 'D';
                }
            } else {
                if (currentDirection == 'N') {
                    y++;
                } else if (currentDirection == 'W') {
                    x--;
                } else if (currentDirection == 'D') {
                    y--;
                } else {
                    x++;
                }
            }
        }
        
        return (x == 0 && y == 0) || currentDirection != 'N';
    }
}