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
        ndMatrix = recMat(ndims, 0); //actually create the ndMatrix
    }
    
    
    public int[] size(Matrix poop){
        return poop.dimensions;
    }
    
	//code for actually creating n dimensionall matricies
	//is a recursive function as it is impossible to know how many dimensions a matrix will have.
    private Object[] recMat(int[] dims, int fillwith){
        int L = (dims.length-1); // a variable used to help make sure that the function doesn't reccur endlessly
        int[] recfeed = new int[L-1]; //used to create recursive versions of this function each with less dimensions
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
            Object[] thingy = recMat(recfeed, fillwith); //reccur with a smalled matrix for dimensions
            for(int i=0; i<dims[L]; i++){
                tbr = thingy; //fill all levels of this matrix with lower ones
            }
        }
        return tbr; //return the matrix
    }
	
	//sort of a basic function for element by element mathmatics with matricies.
	private Object[] arith(Matrix one, Matrix two, String funky){
		if(!mCheck(one, two)){
			System.out.println("Matricies are not the same size!");
			return null;
		}
		int[] dims = one.size;
        int L = (dims.length-1); // a variable used to help make sure that the function doesn't reccur endlessly
        int[] recfeed = new int[L-1]; //used to create recursive versions of this function each with less dimensions
		Object[] tbr = new Object[dims[L]]; //the actualy matrix being created
        for(int i=0; i<(L-1); i++){
            recfeed[i] = dims[i]; //make sure that recfeed is the same is dims but shorter
        }
        if(L==0){ //if the ndims only have one value in it, stop recurring
            for(int i=0; i<recfeed[0]; i++){
				if(funky.equals("add" || "+")){
					tbr[i] = one[i] + two[i]; //create an array filled with the number desired
				}
				else if(funky.equals("subtract" || "sub" || "-")){
					tbr[i] = one[i] - two[i]; //subtract the matricies from each other
				}
				else if(funky.equals("hadamard" || "had" || "*")){
					tbr[i] = one[i] * two[i]; //hadamard multiplication: multiplying each element of a matric by the same element of annother one
				}
				else{
					System.out.println("Woah there, that function isn't recognized!")
					return null;
				}
            }
        }
        else{ //if reccuring still needs to happen...
			//Need to edit this to be actually correct instead of garbage... maybe?
            Object[] thingy = arith(one, two, funky); //reccur with a smalled matrix for dimensions
            for(int i=0; i<dims[L]; i++){
                tbr = thingy; //fill all levels of this matrix with lower ones
            }
        }
        return tbr; //return the matrix
    }
	
	//Ndimensional matrix multiplication function. Dear gods.
	public Object[] multiply(Matrix one, Matrix two){
		if(!mcheck(one, two)){
			System.out.println("Matricies are not the same size!");
			return null;
		}
	}
	
	//a function to check if the matricies are the same size, usefull to prevent errors in most of the functions later
	public boolean mCheck(Matrix first, Matrix other){
		if(first.size == other.size){
			return true;
		}
		else{
			return false;
		}
	}
}
