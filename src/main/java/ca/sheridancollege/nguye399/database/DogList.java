package ca.sheridancollege.nguye399.database;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.nguye399.dogs.Dog;

@Repository
public class DogList {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public ArrayList<Dog> getDogs() {
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dog_table";
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);

		for (Map<String, Object> row : rows) {
			Dog dog = new Dog();
			dog.setId((int) (row.get("entry_number")));
			dog.setName((String) (row.get("dog_name")));
			dog.setOwnerName((String) (row.get("dog_owner")));
			dog.setBreed((String) (row.get("dog_breed")));
			dog.setGender((String) (row.get("dog_gender")));
			dog.setType((String) (row.get("classorspecialty")));
			dogs.add(dog);
		}

		return dogs;
	}

	public ArrayList<Dog> getShowList() {
		ArrayList<Dog> showList = new ArrayList<Dog>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM show_list";
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);

		for (Map<String, Object> row : rows) {
			Dog breed = new Dog();
			breed.setAmount((int) (row.get("amount")));
			breed.setBreed((String) (row.get("breed")));
			breed.setMaleClass((int) (row.get("class_males")));
			breed.setFemaleClass((int) (row.get("class_females")));
			breed.setMaleSpecialty((int) (row.get("specialty_males")));
			breed.setFemaleSpecialty((int) (row.get("specialty_females")));
			showList.add(breed);
		}

		return showList;
	}

	public ArrayList<String> getBreeds() {
		ArrayList<String> breeds = new ArrayList<String>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dog_breed";
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);

		for (Map<String, Object> row : rows) {
			String breed = new String();
			breed = ((String) row.get("dog_breed"));
			breeds.add(breed);
		}

		return breeds;
	}

	public Dog getDogById(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dog_table WHERE entry_number=:id";
		parameters.addValue("id", id);
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);

		for (Map<String, Object> row : rows) {
			Dog dog = new Dog();
			dog.setId((int) (row.get("entry_number")));
			dog.setName((String) (row.get("dog_name")));
			dog.setOwnerName((String) (row.get("dog_owner")));
			dog.setBreed((String) (row.get("dog_breed")));
			dog.setGender((String) (row.get("dog_gender")));
			dog.setType((String) (row.get("classorspecialty")));
			dogs.add(dog);
		}

		if (dogs.isEmpty())
			return null;
		else
			return dogs.get(0);
	}

	public void addDog(Dog dog) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = ("INSERT INTO dog_table (dog_name, dog_breed, dog_owner, dog_gender, classorspecialty) VALUES (:name, :breed, :owner_name, :gender, :type)");
		parameters.addValue("name", dog.getName());
		parameters.addValue("breed", dog.getBreed());
		parameters.addValue("owner_name", dog.getOwnerName());
		parameters.addValue("gender", dog.getGender());
		parameters.addValue("type", dog.getType());
		jdbc.update(query, parameters);
	}

	public void updateDog(Dog dog) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = ("UPDATE dog_table SET dog_name=:name, dog_breed=:breed, dog_owner=:owner_name, dog_gender=:gender, classorspecialty=:type WHERE entry_number=:id");
		parameters.addValue("id", dog.getId());
		parameters.addValue("name", dog.getName());
		parameters.addValue("breed", dog.getBreed());
		parameters.addValue("owner_name", dog.getOwnerName());
		parameters.addValue("gender", dog.getGender());
		parameters.addValue("type", dog.getType());
		jdbc.update(query, parameters);
	}

	public void updateShowList(Dog dog) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = ("UPDATE show_list SET amount = (SELECT COUNT(*) FROM dog_table WHERE dog_table.dog_breed=breed)");
		jdbc.update(query, parameters);
		query = ("UPDATE show_list SET class_males = (SELECT COUNT(*) FROM dog_table WHERE dog_gender='Male' AND classorspecialty='Class' AND dog_table.dog_breed=breed)");
		jdbc.update(query, parameters);
		query = ("UPDATE show_list SET class_females = (SELECT COUNT(*) FROM dog_table WHERE dog_gender='Female' AND classorspecialty='Class' AND dog_table.dog_breed=breed)");
		jdbc.update(query, parameters);
		query = ("UPDATE show_list SET specialty_males = (SELECT COUNT(*) FROM dog_table WHERE dog_gender='Male' AND classorspecialty='Specialty' AND dog_table.dog_breed=breed)");
		jdbc.update(query, parameters);
		query = ("UPDATE show_list SET specialty_females = (SELECT COUNT(*) FROM dog_table WHERE dog_gender='Female' AND classorspecialty='Specialty' AND dog_table.dog_breed=breed)");
		jdbc.update(query, parameters);
	}

	public void addBreed(Dog dog) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO dog_breed VALUES (:breed)";
		parameters.addValue("breed", dog.getBreed());
		jdbc.update(query, parameters);
	}

	public void deleteDog(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "DELETE FROM dog_table WHERE entry_number=:id";
		parameters.addValue("id", id);
		jdbc.update(query, parameters);
	}
}
