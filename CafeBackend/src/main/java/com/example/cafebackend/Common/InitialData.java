package com.example.cafebackend.Common;

import com.example.cafebackend.Entity.*;
import com.example.cafebackend.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public class InitialData implements CommandLineRunner {

    IngredientRepository ingredientRepository;

    IngredientPriceRepository ingredientPriceRepository;

    UserRepository userRepository;

    MenuItemRepository menuItemRepository;

    MainMenuItemRepository mainMenuItemRepository;


    public InitialData(IngredientRepository ingredientRepository, IngredientPriceRepository ingredientPriceRepository,
                       UserRepository userRepository, MenuItemRepository menuItemRepository, MainMenuItemRepository mainMenuItemRepository) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientPriceRepository = ingredientPriceRepository;
        this.userRepository = userRepository;
        this.menuItemRepository = menuItemRepository;
        this.mainMenuItemRepository = mainMenuItemRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Ingredient ingredient1 = new Ingredient("Abocado", "kg", 12.0);
        Ingredient ingredient2 = new Ingredient("Rice", "kg", 100.0);
        Ingredient ingredient3 = new Ingredient("Carrot", "kg", 18.0);
        Ingredient ingredient4 = new Ingredient("Orange", "kg", 150.0);
        Ingredient ingredient5 = new Ingredient("Spinach", "kg", 9.0);
        Ingredient ingredient6 = new Ingredient("Bread", "pcs", 10.0);


        ingredientRepository.save(ingredient1);
        ingredientRepository.save(ingredient2);
        ingredientRepository.save(ingredient3);
        ingredientRepository.save(ingredient4);
        ingredientRepository.save(ingredient5);
        ingredientRepository.save(ingredient6);


        User user1 = new User("Anjellie", "?", "Admin");
        User user2 = new User("Sajeta", "password", "Staff");


        userRepository.save(user1);
        userRepository.save(user2);

        IngredientPrice ingredientPrice1 = new IngredientPrice(55.5, 10.5, LocalDate.of(2022, 11, 25));
        IngredientPrice ingredientPrice2 = new IngredientPrice(10.5, 7.5, LocalDate.of(2022, 11, 22));
        IngredientPrice ingredientPrice3 = new IngredientPrice(50.0, 17.5, LocalDate.of(2022, 11, 20));
        IngredientPrice ingredientPrice4 = new IngredientPrice(15.5, 15.5, LocalDate.of(2022, 11, 21));
        IngredientPrice ingredientPrice5 = new IngredientPrice(35.5, 10.0, LocalDate.of(2022, 11, 24));

        ingredientPriceRepository.save(ingredientPrice1);
        ingredientPriceRepository.save(ingredientPrice2);
        ingredientPriceRepository.save(ingredientPrice3);
        ingredientPriceRepository.save(ingredientPrice4);
        ingredientPriceRepository.save(ingredientPrice5);


        MenuItem humus = new MenuItem("Humus", "");
        MenuItem jackfruitAdobo = new MenuItem("Jackfruit Adobo", "Instructions\n" +
                "1. Fry the garlic in the oil until the garlic becomes light brown \n" +
                "2. Add the soy sauce, vinegar and sugar to the pot. Move until the sugar dissolves completely \n" +
                "3. Add the jackfruit that has already drained .\n" +
                "4. let the jackfruit boil and absorb the sauce. \n" +
                "5. Move with spoon to obtain shredded jackfruit. Pack in boxes with date and stickers with its name \"adobo\"");
        MenuItem tuna = new MenuItem("Tuna", "");
        MenuItem tunaVegan = new MenuItem("Tuna Vegan", "Instructions\n" +
                "1. Drain the artichokes, prechop the basilicum\n" +
                "2. In the big food processor put all the ingredientes and process until you have a nice mouse consistency.\n" +
                "3. Pack in plastic 1 litre boxes and tag with the doate and \"vegan tuna\"");
        MenuItem burgerPaddy = new MenuItem("Burger Paddy", "Instructions\n" +
                "1. Toss first 4 ingredients in oil salt and pepper\n" +
                "2. Roast at 200 degrees for 10-15 min\n" +
                "3. when cool chop fine\n" +
                "4. Combine all in mixer and mix on high fir 8-10 minutes\n" +
                "5. Make pattys and put them on oiled gastropans\n" +
                "6. Bake at 180 degrees for 10 minutes\n" +
                "7. Cool and freeze");
        MenuItem caramalizedOnions = new MenuItem("Caramelized Onions", "Put some checkpea into");
        MenuItem pickledOnions = new MenuItem("Pickled Onions", "Instructions\n" +
                "1. Slice all cucumbers\n" +
                "2. Boil all ingredients.\n" +
                "3. seperate cucumber and devide in 4  5L containers\n" +
                "4. Cover the cucmber with liquid and let cool\n" +
                "5. Mark with date");
        MenuItem roastedPortabelloMushrooms = new MenuItem("Roasted Portabello Mushrooms", "Put some checkpea into");
        MenuItem pickledCucumber = new MenuItem("Pickled Cucumber", "Put some checkpea into");
        MenuItem pesto = new MenuItem("Pesto", "Instructions\n" +
                "1. Process everything but the oil in the big food processor until you have a paste.\n" +
                "2. Add the oil little by little to obtain a uniform pesto.");
        MenuItem crispFishPaddy = new MenuItem("Crisp Fish Paddy", "\tInstructions\n" +
                "1\tSlice the fish 45*angle and 1 cm filets\n" +
                "2\tMix flour with 2 tsp salt and the pepper \n" +
                "3\tFlour the fish filets\n" +
                "4\tEgg the fish filets one by one draining excess and immediately  cover with bred crumbs.\n" +
                "5\tArrange the breaded filets in a freezer container with oven paper squares separating individual filets.");
        MenuItem creamyCoconutLentilCurry = new MenuItem("Creamy Coconut Lentil Curry", "Instructions \n" +
                "1. Heat the oil in a big pot add the cummin seeds, then and fry the garlic, then add the ginger and let fry for 3 min, then add the onion and let become transparent.\n" +
                "2. Add the chopped tomatoes mix and let fry for some minutes, then add the lentils, the coriander  and the water. Let it boil and slow down the heat putting the pot on the rack over the stove.\n" +
                "3. When lentils are cooked add the spices mix well and let boil for 5 minutes.\n" +
                "4. Add the coconut milk, mix and let it get warm.\n" +
                "5. Pack in 1 litre plastic boxes, add the stickers with date and identification like lentils.");

        menuItemRepository.save(humus);
        menuItemRepository.save(tuna);
        menuItemRepository.save(jackfruitAdobo);
        menuItemRepository.save(tunaVegan);
        menuItemRepository.save(burgerPaddy);
        menuItemRepository.save(caramalizedOnions);
        menuItemRepository.save(pickledOnions);
        menuItemRepository.save(roastedPortabelloMushrooms);
        menuItemRepository.save(pickledCucumber);
        menuItemRepository.save(pesto);
        menuItemRepository.save(crispFishPaddy);
        menuItemRepository.save(creamyCoconutLentilCurry);


        MainMenuItem fishBurger = new MainMenuItem("Fish Burger", "It need to be ");
        MainMenuItem pokeBowl = new MainMenuItem("PokeBowl", "It need to be ");
        MainMenuItem tunaSandwich = new MainMenuItem("Tuna Sandwich", "It need to be ");
        MainMenuItem veganSandwich = new MainMenuItem("Vegan Sandwich", "It need to be ");
        MainMenuItem veganBurger = new MainMenuItem("Vegan Burger", "It need to be ");

        mainMenuItemRepository.save(fishBurger);
        mainMenuItemRepository.save(pokeBowl);
        mainMenuItemRepository.save(tunaSandwich);
        mainMenuItemRepository.save(veganSandwich);
        mainMenuItemRepository.save(veganBurger);

    }
}
