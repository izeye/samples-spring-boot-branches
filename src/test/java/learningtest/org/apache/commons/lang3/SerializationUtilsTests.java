package learningtest.org.apache.commons.lang3;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by izeye on 15. 4. 4..
 */
public class SerializationUtilsTests {
	
	@Test
	public void testClone() {
		Person[][] persons = new Person[2][2];
		persons[0][0] = new Person("Johnny", "Lim", 35);
		persons[0][1] = new Person("John", "Lim", 20);
		persons[1][0] = new Person("Johnny", "Lee", 45);
		persons[1][1] = new Person("John", "Lee", 10);

		Person[][] clonedPersons = SerializationUtils.clone(persons);
		
		assertTrue(clonedPersons[0][0].equals(persons[0][0]));
		assertTrue(clonedPersons[0][1].equals(persons[0][1]));
		assertTrue(clonedPersons[1][0].equals(persons[1][0]));
		assertTrue(clonedPersons[1][1].equals(persons[1][1]));
		
		assertFalse(clonedPersons[0][0] == persons[0][0]);
		assertFalse(clonedPersons[0][1] == persons[0][1]);
		assertFalse(clonedPersons[1][0] == persons[1][0]);
		assertFalse(clonedPersons[1][1] == persons[1][1]);
	}
	
	static class Person implements Serializable {
		private String firstName;
		private String lastName;
		private int age;

		public Person(String firstName, String lastName, int age) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Person person = (Person) o;

			if (age != person.age) return false;
			if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
			if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = firstName != null ? firstName.hashCode() : 0;
			result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
			result = 31 * result + age;
			return result;
		}

		@Override
		public String toString() {
			return "Person{" +
					"firstName=" + firstName +
					", lastName=" + lastName +
					", age=" + age +
					'}';
		}
	}
	
}
