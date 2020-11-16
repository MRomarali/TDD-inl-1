package org.example;

/**
 * Interface for handling an array of integers.
 */
public interface IIntArray {
    /**
         * Get the average value of the entire array.
         * @return Average.
         */
        double getAverage();
        /**
         * Find and return all positions where an element's value is <val>.
         * @param val Value to find positions for.
         * @return Positions.
         */
        int[] findPositions(int val);
        /**
         * Append a value after the last element.
         * @param
         */
        void appendLast(int value);
        /**
         * Insert a value at position <pos>.
         * @param pos
         * @param value
         */
        void insertAt(int pos, int value);
        /**
         * Get value at position <pos>.
         * @param pos
         * @return value.
         */
        int getAt(int pos);
        /**
         * Set a new value at position <pos>.
         * @param pos
         * @param element
         */
        void setAt(int pos, int element);
        /**
         * Delete element at position <pos>.
         * Return the deleted element's value.
         * @param pos
         * @return
         */
        int deleteAt(int pos);
}
