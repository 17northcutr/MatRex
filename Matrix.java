/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mecknavorz the best dragon
 */
public class Matrix {
    //object variables and what have you
    public Object[] ndMatrix; //basically the actuall n-dimensional matrix
    private final int[] dimensions; //used to store dimensions of the matrix
    
    //instatiation function
    public Matrix(int... ndims){
        dimensions = ndims; //store the input in the dimensions attribute
        ndMatrix = recFor(ndims, 0); //actually create the ndMatrix
    }
    
    
    public int[] size(Matrix poop){
        return poop.dimensions;
    }
    
    private Object[] recFor(int[] dims, int fillwith){
        int L = (dims.length-1); // a variable used to help make sure that the function doesn't reccur endlessly
        int[] recfeed = new int[L]; //used to create recursive versions of this function each with less dimensions
        Object[] tbr = new Object[dims[L]]; //the actualy matrix being created
        for(int i=0; i<(L-1); i++){
            recfeed[i] = dims[i]; //make sure that recfeed is the same is dims but shorter
        }
        if(L==0){ //if the ndims only have one value in it, stop recurring
            for(int i=0; i<recfeed[0]; i++){
                tbr[i]=fillwith; //create an array filled with the number desired
            }
        }
        else{ //if reccuring still needs to happen...
            Object[] thingy = recFor(recfeed, fillwith); //reccur with a smalled matrix for dimensions
            for(int i=0; i<dims[L]; i++){
                tbr = thingy; //fill all levels of this matrix with lower ones
            }
        }
        return tbr; //return the matrix
    }
}
