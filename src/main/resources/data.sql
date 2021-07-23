-- Levi details
INSERT INTO users (username, password, enabled, email, first_name, last_name, news_letter,country)
    VALUES ('Levi', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE, 'levi@broeksma.nl', 'Levi', 'Broeksma', FALSE, 'netherlands');
INSERT INTO authorities (username, authority) VALUES ('Levi', 'USER');

-- User details
INSERT INTO users (username, password, enabled, email, first_name, last_name, news_letter,country)
    VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE, 'user@user.nl', 'user', 'usersson', FALSE, 'netherlands');
INSERT INTO authorities (username, authority) VALUES ('user', 'USER');

-- Admin details
INSERT INTO users (username, password, enabled, email, first_name, last_name, news_letter, country)
    VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE, 'admin@admin.nl', 'admin', 'adminson', FALSE, 'netherlands');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ADMIN');

-- Example recipe one
INSERT INTO recipes (id, beef, fish, poultry, lamb, vegan, vegetarian, pork, spicy, calories, cookingtime, country, description, file_name, location, title, username, user_country)
    VALUES (1001, false, false, true, false, false, false, false, true, 500, 75, 'mexico', 'Insanely tasty, smokey shredded chicken. Believe me, this tastes insane!', 'shredded_chicken.jpeg', 'uploads/shredded_chicken.jpeg', 'Mexican style shredded chipotle chicken (Instant pot)', 'Levi', 'netherlands');

INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (1, '1 tbsp Olive oil', 1001);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (2, '500 grams of chicken tights', 1001);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (3, '2 tsp Kosher salt (or sea salt)', 1001);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (4, '1/2 tsp Black pepper', 1001);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (5, '1 small yellow onion', 1001);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (6, '4 cloves of garlic', 1001);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (7, '2 tsp chipotle powder', 1001);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (8, '3 chipotle peppers in adobo', 1001);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (9, '1/2 tsp Black pepper', 1001);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (10, '1 can diced tomatoes', 1001);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (11, '1 lime juiced', 1001);

INSERT INTO directions (id, direction_name, recipe_id) VALUES (1, 'Season both sides of the chicken with 1 teaspoon kosher salt and black pepper.', 1001);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (2, 'Set the Instant Pot to sauté. Heat 1/2 tablespoon of the olive oil. Once hot and shimmering, add half the chicken and sear both sides for 2 to 3 minutes each, just until brown (the chicken does not need to be cooked through). Do not disturb the chicken while each side sears.  Remove to a plate and set aside. Add the second half of the chicken and sear each side for 2 to 3 minutes each. Remove to the same plate.', 1001);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (3, 'With the Instant Pot still on sauté, add the remaining 1/2 tablespoon olive oil. Add the onion, garlic, chili powder, and remaining 1/2 teaspoon kosher salt. Let cook 3 minutes, until the onion beings to soften. Turn the Instant Pot off (on my model, I hit CANCEL). Stir in the chipotle peppers, tomatoes, and reserved chicken. Arrange the chicken pieces in a single layer (a little overlap is OK, and the chicken will be touching). Pour the lime juice over the top.', 1001);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (4, 'Lock the lid in place. Cook on manual pressure for 8 minutes. As soon as the time is up, vent immediately. Once you can open the lid, turn the Instant Pot off, and then remove the chicken to a large bowl or plate. Turn the Instant Pot to SAUTE. Bring the cooking liquid to a simmer. Let simmer for 5 to 10 minutes, stirring occasionally, until the liquid reduces by about half. Meanwhile, shred the chicken with two forks (or, once it is cool enough, your fingers).', 1001);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (5, 'Once the liquid is reduced, turn the Instant Pot off, return the chicken into the Instant Pot, and then stir the chicken to coat in the sauce.', 1001);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (6, 'Prepare the avocado sauce (I like to do this while the chicken is pressure cooking): In a food processor, blend together the avocado, Greek yogurt, 2 tablespoons lime juice, and salt until smooth. Taste and add additional salt or lime juice as desired.', 1001);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (7, 'To serve: Fill the shells or tortillas with the chicken, drizzle with avocado sauce, and add any desired toppings. Enjoy immediately.', 1001);

INSERT INTO reviews (id, review, recipe_id, stars, user_country, username) VALUES (100, 'This was amazing, will definitely make this again. It was a big hit with the kids as well', 1001, 5, 'netherlands', 'user');
INSERT INTO reviews (id, review, recipe_id, stars, user_country, username) VALUES (101, 'One of my favorites so far, delicious!', 1001, 4, 'netherlands', 'Levi');

-- Example recipe two
INSERT INTO recipes (id, beef, fish, poultry, lamb, vegan, vegetarian, pork, spicy, calories, cookingtime, country, description, file_name, location, title, username, user_country)
VALUES (1002, false, false, false, false, true, true, false, true, 100, 20, 'mexico', 'An amazing topping for tacos and burgers, but be warned! Extremely spicy, up to 350.000 on the scovile scale.' , 'habaneros.jpeg', 'uploads/habaneros.jpeg', 'Pickled habaneros', 'Levi', 'netherlands');

INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (12, '100 grams of habaneros', 1002);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (13, '300 ml apple cider vinegar', 1002);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (14, '2 tsp Kosher salt (or sea salt)', 1002);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (15, '2 tbsp sugar', 1002);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (16, '1 tbsp mustard seeds', 1002);


INSERT INTO directions (id, direction_name, recipe_id) VALUES (8, 'Put the vinegar, salt and sugar in a small pan and bring to a light simmer.', 1002);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (9, 'In the meantime, cut the habaneros in thin rings of roughly 3 mm. (I recommend using cloves, you dont want to touch anything with habanero hands)', 1002);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (10, 'Add the habaneros and mustard to an empty jar. Then pour the vinegar mixture over it. Let it cool down and put in the fridge. They are best if you leave them in there for at least 3 days.', 1002);

INSERT INTO reviews (id, review, recipe_id, stars, user_country, username) VALUES (102, 'Waaaaaay to spicy for my taste, I cant believe that people like to eat this willingly.', 1002, 1, 'netherlands', 'user');
INSERT INTO reviews (id, review, recipe_id, stars, user_country, username) VALUES (103, 'Holy Mole, these are spicy, however, they give a really nice kick to your taco!', 1002, 3, 'netherlands', 'Levi');

-- Example recipe three
INSERT INTO recipes (id, beef, fish, poultry, lamb, vegan, vegetarian, pork, spicy, calories, cookingtime, country, description, file_name, location, title, username, user_country)
    VALUES (1003, false, false, false, false, true, true, false, true, 900, 5, 'netherlands', 'A quick and easy, delicious chipotle mayonaise.' , 'chipotle_mayo.jpg', 'uploads/chipotle_mayo.jpg', '5 minute chipotle mayonaise', 'Levi', 'netherlands');

INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (17, '1 egg', 1003);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (18, '250 ml sunflower oil', 1003);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (19, '1 pinch of salt to taste', 1003);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (20, '1 tbsp of mustard', 1003);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (21, '1 tbsp apple cider vinegar', 1003);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (22, '1 tsp of black pepper', 1003);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (23, '1 can of chipotles in adobo (100 grams)', 1003);

INSERT INTO directions (id, direction_name, recipe_id) VALUES (11, 'Put all your ingredients (the whole egg as well), except the chipotle in a small high measuring cup. Put in your hand mixer and while mixing, slowly pull up your mixer to the surface of you mixture. By the time you reach the top, your mayonaise is finished.', 1003);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (12, 'Add the chipotles to your mayonaise and mix well.', 1003);

INSERT INTO reviews (id, review, recipe_id, stars, user_country, username) VALUES (104, 'Never knew that mayonaise was so easy to make. I will do this much more often to impress my dinner guests.', 1003, 5, 'netherlands', 'user');
INSERT INTO reviews (id, review, recipe_id, stars, user_country, username) VALUES (105, 'Amazing!', 1003, 3, 'netherlands', 'Levi');

-- Example recipe four
INSERT INTO recipes (id, beef, fish, poultry, lamb, vegan, vegetarian, pork, spicy, calories, cookingtime, country, description, file_name, location, title, username, user_country)
    VALUES (1004, true, false, false, false, false, false, true, true, 500, 60, 'italy', 'Perfect Tagliatelle with a creamy, rich mushroom sauce' , 'tagliatelle_mushroom.jpeg', 'uploads/tagliatelle_mushroom.jpeg', 'Tagliatelle with a creamy mushroom sauce', 'Levi', 'netherlands');

INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (24, '250 ml of cream (I use non sweetened whipping cream)', 1004);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (25, '400 grams of chestnut mushrooms', 1004);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (26, 'salt and pepper to taste', 1004);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (27, '3 tbsp all purpose flour', 1004);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (28, '400 grams of tagliatelle', 1004);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (29, '125 grams of bacon cubes', 1004);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (30, '1 yellow onion', 1004);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (31, '10 grams of parsley', 1004);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (32, '1 tbsp of unsalted butter', 1004);
INSERT INTO ingredients (id, ingredient_name, recipe_id) VALUES (33, '1 tbsp of extra virgin olive oil', 1004);

INSERT INTO directions (id, direction_name, recipe_id) VALUES (13, 'Slice your mushrooms, dice your onion and chop up your parsley. ', 1004);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (14, 'Put a pan on your stove and bring water up to a boil. Add salt to the water (pasta water should be as salt as the sea, do not skip this step!). When the water is boiling putt in the pasta.', 1004);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (15, 'Add the oil and butter to a sauce pan, once your butter is melted, add your bacon cubes. Fry for about 2 minutes before adding you onion. Fry until glassy.', 1004);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (16, 'Once your onions turned glassy, add the mushrooms, fry for about 5 minutes on medium high heat. Than add your flour and bake it for at least 3 minutes.', 1004);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (17, 'Add your cream, while you do this keep stirring slowly, your sauce should start thickening due to the added flour.', 1004);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (18, 'Always aim for your pasta to be al dente (so it has a bite), get rid of the water and add the pasta to your sauce. Mix up for about a minute before taking it of the stove and start serving.', 1004);
INSERT INTO directions (id, direction_name, recipe_id) VALUES (19, 'Add some of your finely chopped parsley when plated to give it that extra look.', 1004);


INSERT INTO reviews (id, review, recipe_id, stars, user_country, username) VALUES (106, 'So quick, so tasty, I recommend!', 1004, 5, 'netherlands', 'user');
INSERT INTO reviews (id, review, recipe_id, stars, user_country, username) VALUES (107, 'I want to warn everybody, watch yourself, you easily overeat with this delicious dish!', 1004, 5, 'netherlands', 'Levi');