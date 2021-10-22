CREATE TABLE dog_breed (dog_breed VARCHAR(255) NOT NULL PRIMARY KEY);

CREATE TABLE dog_table (entry_number int NOT NULL PRIMARY KEY AUTO_INCREMENT, dog_breed VARCHAR(255) REFERENCES dog_breed(dog_breed), dog_name VARCHAR(255), dog_owner VARCHAR(255), dog_gender VARCHAR(255), classorspecialty VARCHAR(255));

CREATE TABLE show_list (amount int, breed VARCHAR(255), class_males int, class_females int, specialty_males int, specialty_females int, FOREIGN KEY(breed) REFERENCES dog_breed(dog_breed));