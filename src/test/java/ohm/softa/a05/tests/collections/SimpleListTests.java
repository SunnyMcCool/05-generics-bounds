package ohm.softa.a05.tests.collections;

import ohm.softa.a05.model.*;
import ohm.softa.a05.collections.SimpleFilter;
import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.collections.SimpleListImpl;
import ohm.softa.a05.tests.models.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
class SimpleListTests {

	private final Logger logger = LogManager.getLogger();
	private SimpleList<Integer> testList;

	@BeforeEach
	void setup(){
		testList = new SimpleListImpl<>();

		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
	}

	@Test
	void testFlower() throws Exception {
		logger.info("testing flowers");
		Flower f1 = new Flower(6.0, "Wiesenblume", "Loewenzahn", PlantColor.YELLOW);
		Flower f2 = new Flower(3.0, "Rose", "Pfingstrose", PlantColor.RED);

		f1.compareTo(f2);
		f1.toString();
		f1.getFamily();
		f1.getHeight();
		f1.getName();
		f1.equals(f2);
		f1.hashCode();
	}

	@Test
	void testShrub(){
		logger.info("testing shrubs");
		Shrub s1 = new Shrub(4.0, "Unterholz", "Vogelbeerbaum");
		Shrub s2 = new Shrub(5.0, "Busch", "Heidelbeerbusch");

		s1.compareTo(s2);
		s1.toString();
		s1.getFamily();
		s1.getHeight();
		s1.getName();
		s1.equals(s2);
		s1.hashCode();
	}

	@Test
	void testPlantBed(){
		logger.info("Testing PlantBed");
		PlantBed<Plant> pb = new PlantBed<>();

		pb.add(new Flower(4.0, "Tulpe", "Gelbtulpe", PlantColor.YELLOW));
		pb.size();

		pb.getPlantsByColor(PlantColor.BLUE);
	}

	@Test
	void testAddElements(){
		logger.info("Testing if adding and iterating elements is implemented correctly");
		int counter = 0;
		for(Object o : testList){
			counter++;
		}
		assertEquals(5, counter);
	}

	@Test
	void testSize(){
		logger.info("Testing if size() method is implemented correctly");
		assertEquals(5, testList.size());
	}

	@Test
	void testFilterAnonymousClass(){
		logger.info("Testing the filter possibilities by filtering for all elements greater 2");
		SimpleList<Integer> result = testList.filter(new SimpleFilter<Integer>() {
			@Override
			public boolean include(Integer item) {
				return item > 2;
			}
		});

		for(Integer i : result){
			assertTrue(i > 2);
		}
	}

	@Test
	void testFilterLambda(){
		logger.info("Testing the filter possibilities by filtering for all elements which are dividable by 2");
		SimpleList<Integer> result = testList.filter(o -> o % 2 == 0);
		for(Integer i : result){
			assertTrue(i % 2 == 0);
		}
	}

	@Test
	void testAddEmpty() throws Exception {
		logger.info("Testing to add a new empty list element");
		SimpleList<Person> l = new SimpleListImpl<>();
		l.addDefault(Person.class);
		assertEquals(1, l.size());
	}

	@Test
	void testSimpleListMap(){
		logger.info("Testing default map method");
		SimpleList<Integer> mapped = testList.map(i -> i + 1);
		assertEquals(5, mapped.size());
		for(Integer i : mapped) {
			assertTrue(i > 1);
			assertTrue(i < 7);
		}
	}

	@Test
	void testMap() {
		logger.info("Testing default map method by mapping every value to its square");
		SimpleList<Double> result = testList.map(i -> Math.pow(i, 2));
		Iterator<Integer> origIt = testList.iterator();
		Iterator<Double> mapIt = result.iterator();
		while (origIt.hasNext() && mapIt.hasNext()) {
			assertEquals(Math.pow(origIt.next(), 2), mapIt.next(), 0.1);
		}
	}

	@Test
	void testSimpleListMapChangedType() {
		logger.info("Testing default map method by mapping every integer to a char value");
		SimpleList<Character> mapped = testList.map(i -> ((char) (i + 64)));
		assertEquals(5, mapped.size());
	}
}
