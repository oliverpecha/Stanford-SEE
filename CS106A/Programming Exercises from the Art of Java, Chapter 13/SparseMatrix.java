/*
 * File: SparseMatrix.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 13 / Programming Exercise 10
 * -----------------
 */

import java.util.HashMap;

public class SparseMatrix {

	public SparseMatrix() {
		matrix = new HashMap<Integer, Index> ();
	}
	
	public void put(double x, double y) {
		if (x + y != 0) {
			Index input = new Index(x,y);
			matrix.put(input.hashCode(), input);
		}
	}
	
	public Index get(double x, double y) {
		if (x + y != 0) {
			Index input = new Index(x,y);
			Index search = matrix.get(input.hashCode());
			if (search != null) return search;
			else return null;
		}
		else return new Index(0.0, 0.0);
	}
	
	HashMap<Integer, Index> matrix;
	
	public class Index {

	    private double x=0; // nr of rows
	    private double y=0; // nr of columns
	    private int hashvalue = 0;

	    public Index (final double x, final double y) {
	        this.x=x;
	        this.y=y;
	        hashvalue=((x+"")+(y+"")).hashCode();
	    }

	    public boolean equals (final Object obj)
	    {
	        if (obj instanceof Index)
	        {
	            Index index = (Index) obj;
	            return ((x==index.x) && (y==index.y));
	        }
	        else
	            return false;
	    }

	    public int hashCode()
	    {
	        return hashvalue;
	    }
	    
	    public String toString() {
	    	return x + ", " + y;
	    }

	}
}
