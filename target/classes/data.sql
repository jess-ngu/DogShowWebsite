INSERT INTO dog_breed (dog_breed) VALUES
('Barbet'), ('Golden Retriever'), ('Brittany'), ('English Setter'), ('Gordon Setter'),
('Irish Setter'), ('Pointer'), ('Sussex Spaniel'), ('Weimaraner'), ('Vizsla');

INSERT INTO dog_table (dog_breed, dog_name, dog_owner, dog_gender, classorspecialty) VALUES 
('Golden Retriever', 'Gunner', 'Jess', 'Male', 'Class'), ('Brittany', 'Sunny', 'Bob', 'Female', 'Class'),
('Brittany', 'Ash', 'Sasha', 'Male', 'Specialty'), ('English Setter', 'Apollo', 'Austin', 'Male', 'Class'),
('Irish Setter', 'Bentley', 'Angus', 'Male', 'Specialty'), ('Gordon Setter', 'Blossom', 'Quinn', 'Female', 'Specialty'),
('Pointer', 'Bingo', 'Ivy', 'Male', 'Class'), ('Weimaraner', 'Brandy', 'Maeve', 'Female', 'Class'),
('Sussex Spaniel', 'Blaze', 'Alisae', 'Male', 'Specialty'), ('Brittany', 'Birdie', 'Nova', 'Female', 'Class'),
('Vizsla', 'Bandit', 'Alphinaud', 'Male', 'Class'), ('Brittany', 'Biscuit', 'Amara', 'Female', 'Class'),
('Golden Retriever', 'Barkley', 'Urianger', 'Male', 'Class'), ('Irish Setter', 'Eva', 'Elliot', 'Female', 'Class'),
('Golden Retriever', 'Chief', 'Rhyn', 'Male', 'Specialty'), ('Irish Setter', 'Georgia', 'Noelle', 'Female', 'Class'),
('Irish Setter', 'Cody', 'Elaine', 'Male', 'Specialty'), ('English Setter', 'Hope', 'Hayden', 'Female', 'Specialty'),
('Golden Retriever', 'Dodge', 'Theodore', 'Male', 'Specialty'), ('Weimaraner', 'Jasmine', 'Zoey', 'Female', 'Class'),
('Barbet', 'Gizmo', 'Hannah', 'Male', 'Specialty'), ('English Setter', 'Karma', 'Logan', 'Female', 'Specialty'),
('Weimaraner', 'Griffin', 'Jade', 'Male', 'Specialty'), ('Sussex Spaniel', 'Liberty', 'Ezra', 'Female', 'Specialty'),
('Golden Retriever', 'Gus', 'Alexander', 'Male', 'Class'), ('Vizsla', 'Lily', 'Ava', 'Female', 'Class'),
('Pointer', 'Hawkeye', 'Juliana', 'Male', 'Class'), ('English Setter', 'London', 'Zane', 'Female', 'Class'),
('Pointer', 'King', 'Sydney', 'Male', 'Specialty'), ('Weimaraner', 'Marley', 'Grayson', 'Female', 'Specialty'),
('Vizsla', 'Judge', 'Chloe', 'Male', 'Class'), ('English Setter', 'Peanut', 'Harper', 'Female', 'Class'),
('Golden Retriever', 'Hunter', 'Emma', 'Male', 'Class'), ('Brittany', 'Pebbles', 'Oliver', 'Female', 'Specialty'),
('Pointer', 'Maverick', 'Tiana', 'Male', 'Specialty'), ('Sussex Spaniel', 'Raven', 'Hudson', 'Female', 'Specialty'),
('Barbet', 'Moose', 'Ethan', 'Male', 'Specialty'), ('Gordon Setter', 'Shadow', 'Alyssa', 'Female', 'Class'),
('Sussex Spaniel', 'Prince', 'Zarya', 'Male', 'Class'), ('Pointer', 'Smokey', 'Xavier', 'Female', 'Specialty'),
('Barbet', 'Tank', 'Maya', 'Male', 'Specialty'), ('Gordon Setter', 'Summer', 'Lennox', 'Female', 'Class'),
('Irish Setter', 'Ziggy', 'Remington', 'Male', 'Class'), ('Vizsla', 'Willow', 'Rayne', 'Female', 'Class');

INSERT INTO show_list(breed) SELECT * FROM dog_breed;

UPDATE show_list SET amount = (SELECT COUNT(*) FROM dog_table WHERE dog_table.dog_breed=breed);
UPDATE show_list SET class_males = (SELECT COUNT(*) FROM dog_table WHERE dog_gender='Male' AND classorspecialty='Class' AND dog_table.dog_breed=breed);
UPDATE show_list SET class_females = (SELECT COUNT(*) FROM dog_table WHERE dog_gender='Female' AND classorspecialty='Class' AND dog_table.dog_breed=breed);
UPDATE show_list SET specialty_males = (SELECT COUNT(*) FROM dog_table WHERE dog_gender='Male' AND classorspecialty='Specialty' AND dog_table.dog_breed=breed);
UPDATE show_list SET specialty_females = (SELECT COUNT(*) FROM dog_table WHERE dog_gender='Female' AND classorspecialty='Specialty' AND dog_table.dog_breed=breed);