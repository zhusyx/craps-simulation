import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PredictableDieTest
{
	private PredictableDie pd;

	@Before
	public void setUp()
	{
		pd = new PredictableDie();
	}
	
	@Test
	public void roll_1() 
	{
		pd.setThrowSequence(new int[] {1,2,3});
		pd.roll();
		assertEquals(1,pd.getLastRoll());
	}
	
	@Test
	public void roll_2() 
	{
		pd.setThrowSequence(new int[] {1,2,3});
		pd.roll();
		pd.roll();
		assertEquals(2,pd.getLastRoll());
	}
	
	@Test
	public void roll_3() 
	{
		pd.setThrowSequence(new int[] {1,2,3});
		pd.roll();
		pd.roll();
		pd.roll();
		assertEquals(3,pd.getLastRoll());
	}
	
	@Test
	public void test_PD_Wrap() 
	{
		pd.setThrowSequence(new int[] {1,2,3});
		pd.roll();
		pd.roll();
		pd.roll();
		pd.roll();
		assertEquals(1,pd.getLastRoll());
	}
	
	@Test
	public void test_PD_Wrap2() 
	{
		pd.setThrowSequence(new int[] {1,2,3});
		pd.roll();
		pd.roll();
		pd.roll();
		pd.roll();
		pd.roll();
		assertEquals(2,pd.getLastRoll());
	}
	
	@Test(expected = RuntimeException.class)
	public void test_PD_empty()
	{
		pd.setThrowSequence(new int[] {});
		pd.roll();
		
	}
	
	@Test(expected = RuntimeException.class)
	public void test_PD_null()
	{
		pd.setThrowSequence(null);;
		pd.roll();
		assertNull(null,pd.getLastRoll());
	}


}
