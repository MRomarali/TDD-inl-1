package org.example;

public class IntArray implements IIntArray {

    public IntArray() {
        this.array = new int[0];
    }
    public IntArray(int[] array) {
        this.array = array;
    }

    private int[] array;


    @Override
    public double getAverage() {
        if (array.length < 1){
            return 0.0;
        }
        double total = 0;

        for(int i=0; i<array.length; i++){
            total = total + array[i];
        }
        double average = total / array.length;
        return Math.round(average * 100)/100.0;
}

    @Override
    public int[] findPositions(int val) {
        int size = 0;
        int counter = 0;
        int index = 0;
        for (int value: array) {
            if (value == val){
                size++;
            }
        }
        if (size != 0){
            int[] found = new int[size];
            for (int value: array) {
                if (value == val){
                    found[index] = counter;
                    index++;
                }
                counter++;
            }
            return found;
        }
        return new int[0];
    }

    @Override
    public void appendLast(int value) {
        int size = array.length;
        int[] newArray = new int[size +1];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        newArray[size] = value;
        this.array = newArray;
    }

    @Override
    public void insertAt(int pos, int value) {
        int[] insert = new int[array.length+1];
        for (int i = insert.length - 1; i >= 0 ; i--) {
            if (i > pos){
                insert[i] = array[i - 1];
            }
            if (i == pos){
                insert[i] = value;
            }
            if (i < pos){
                insert[i] = array[i];
            }
        }
        array = insert;
    }

    @Override
    public int getAt(int pos) {
        return array[pos];

    }

    @Override
    public void setAt(int pos, int element) {
        array[pos] = element;
    }

    @Override
    public int deleteAt(int pos) {
        int[] delete = new int[array.length-1];
        int counter = 0;
        int index = 0;
        int found = 0;
        for (int value: array) {
            if (index == pos){
                found = value;
            }
            else {
              delete[counter] = value;
              counter++;
            }
            index++;
        }
        array = delete;
        return found;
    }

    public int[] getAsArray(){
        return array;
    }
}
