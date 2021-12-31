package Lab2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MyArrayListTest {

	@Test
	void testSize() {
		MyArrayList<Integer> mine = new MyArrayList<Integer>();
		assertEquals(0, mine.size() );
		mine.add(23);
		assertEquals(1, mine.size() );
		mine.add(34);
		assertEquals(2, mine.size() );
	}

	
	@Test
	void testAddE() {
		MyArrayList<Integer> mine = new MyArrayList<Integer>();
		mine.add(23);
		int result = mine.get(0);
		assertEquals(23, result);
	} 
	
	
	@Test
    void testDoTheSame() {
        MyArrayList<Integer>mine = new MyArrayList<Integer>();
        ArrayList<Integer>standard = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            mine.add(2*i+3);
            standard.add(2*i+3);
        }
        for (int i=0; i < 10; i++)
            assertEquals(mine.get(i), standard.get(i));
        }

	
	@Test
    void testAddThrows() {
		MyArrayList<Integer> mine = new MyArrayList<Integer>();
		assertThrows( IndexOutOfBoundsException.class, () -> mine.add(5, 23) );
	}


    MyArrayList mine;

    @BeforeEach
    void init() {
	    mine = new MyArrayList<Integer>();
    }

    @est
    void testSize2() {
	    mine.add(23);
	    assertEquals(1, mine.size(), "size should have been 1");		
    }
    
}
