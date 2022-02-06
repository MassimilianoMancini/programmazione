package compito;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import auxi.Biglia;
import auxi.BigliaNumerata;

public class RibaltaMatriceTest_Base {
	
	@Test
	public void test1() {
		
		int[][] A = new int[][] {{0,1,2}, 
				               {3,4,5}};
		             
		int[][] Ris = new int[][] {{0,1,2},
								 {3,4,5},
								 {3,4,5},
								 {0,1,2}};
		char[] asse = {'O'}; 
	
		Assert.assertEquals(RibaltaMatrice.ribalta(A,asse), Ris);
	}
	
	@Test
	public void test2() {
		
		int[][] A = new int[][] {{0,1,2,3}};
		             
		int[][] Ris = new int[][] {{0,1,2,3},
									{0,1,2,3}};
		char[] asse = {'O'}; 
	
		Assert.assertEquals(RibaltaMatrice.ribalta(A,asse), Ris);
	}
	
	@Test
	public void test3() {
		
		int[][] A = new int[][] {{0,1,2}, 
				               {3,4,5}};
		             
		int[][] Ris = new int[][] {{0,1,2,2,1,0},
								 {3,4,5,5,4,3}};
		char[] asse = {'V'}; 
	
		Assert.assertEquals(RibaltaMatrice.ribalta(A,asse), Ris);
	}
	
	@Test
	public void test4() {
		
		int[][] A = new int[][] {{0,1,2}};
		             
		int[][] Ris = new int[][] {{0,1,2,2,1,0}};
		char[] asse = {'V'}; 
	
		Assert.assertEquals(RibaltaMatrice.ribalta(A,asse), Ris);
	}
	
	@Test
	public void test5() {
		
		int[][] A = new int[][] {{0}};
		             
		int[][] Ris = new int[][] {{0,0}};
		char[] asse = {'V'}; 
	
		Assert.assertEquals(RibaltaMatrice.ribalta(A,asse), Ris);
	}
	
	@Test
	public void test6() {
		
		int[][] A = new int[][] {{0}};
		             
		int[][] Ris = new int[][] {{0},
									{0}};
		char[] asse = {'O'}; 
	
		Assert.assertEquals(RibaltaMatrice.ribalta(A,asse), Ris);
	}
			
	@Test
	public void test7() {
		
		int[][] A = new int[][] {{0},
								 {1},
								 {2},
								 {3}};
		             
		int[][] Ris = new int[][] {{0},
			 						{1},
			 						{2},
			 						{3},
			 						{3},
			 						{2},
			 						{1},
			 						{0}};
		char[] asse = {'O'}; 
	
		Assert.assertEquals(RibaltaMatrice.ribalta(A,asse), Ris);
	}
}
 