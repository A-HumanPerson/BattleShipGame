
/**
 * Write a description of class Ship here.
 *
 * @author Jacob Katz
 * @version 2025-05-08
 */
public class Ship
{
    private int length;
    private int startRow;
    private int startCol;
    private boolean isHorizontal;
    private boolean[] hits;

    /**
     * Constructor for objects of class Ship
     */
    public Ship(int l, int sR, int sC, boolean isH)
    {
        length = l;
        startRow = sR;
        startCol = sC;
        isHorizontal = isH;
        hits = new boolean[l];
    }

    /**
     * Checks if the point described by the parameters row and col is occupied by the ship
     * Helped by AI
     *
     * @param row   The row being checked
     * @param col   The column being checked
     * @return      If the point described by the parameters is occupied
     */
    public boolean occupies(int row, int col)
    {
        if(isHorizontal){
            return row == startRow && col >= startCol && col < startCol + length;
        }
        else{
            return col == startCol && row >= startRow && row < startRow + length;
        }
    }

    /**
     * Marks the part of the ship at the specified row and column as hit, if occupied.
     * Helped by AI
     *
     * @param row The row to check and mark.
     * @param col The column to check and mark.
     * @return true if the ship occupies the given position and it was marked as hit, false otherwise.
     */
    public boolean isHit(int row, int col)
    {
        if(!occupies(row, col)){
            return false;
        }
        int index = 0;
        if(isHorizontal){
            index = col - startCol;
        }
        else{
            index = row - startRow;
        }
        
        hits[index] = true;
        return true;
    }

    /**
     * Checks if the ship has been sunk, meaning all its parts have been hit.
     * 
     * @return true if every segment of the ship is hit, false otherwise.
     */
    public boolean isSunk()
    {
        for(int i = 0; i < length; i++){
            if(hits[i] == false){
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a string representation of the ship, showing its length and the grid points it occupies, along with their hit status.
     * Occupied points function helped by AI
     *
     * @return A string showing the ship's length and all occupied points with hit status.
     */
    public String toString()
    {
        String str = "Ship length: " + length + "\n";
        str += "Occupied points:\n";
        for(int i = 0; i < length; i++){
            int row = isHorizontal ? startRow : startRow + i;
            int col = isHorizontal ? startCol + i : startCol;
            str += "(" + row + ", " + col + ")";
            str += hits[i] ? " [hit]\n" : " []\n";
        }
        return str;
    }

}
