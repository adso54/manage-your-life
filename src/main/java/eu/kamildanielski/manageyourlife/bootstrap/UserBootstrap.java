package eu.kamildanielski.manageyourlife.bootstrap;

import eu.kamildanielski.manageyourlife.domain.Category;
import eu.kamildanielski.manageyourlife.domain.Expenditure;
import eu.kamildanielski.manageyourlife.domain.SubCategory;
import eu.kamildanielski.manageyourlife.domain.User;
import eu.kamildanielski.manageyourlife.repositories.CategoryRepository;
import eu.kamildanielski.manageyourlife.repositories.ExpenditureRepository;
import eu.kamildanielski.manageyourlife.repositories.SubCategoryRepository;
import eu.kamildanielski.manageyourlife.repositories.UserRepository;
import org.hibernate.mapping.Subclass;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private final CategoryRepository categoryRepository;
    private final ExpenditureRepository expenditureRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final UserRepository userRepository;

    public UserBootstrap(CategoryRepository categoryRepository, ExpenditureRepository expenditureRepository, SubCategoryRepository subCategoryRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.expenditureRepository = expenditureRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        userRepository.saveAll(getUsers());
        expenditureRepository.saveAll(getExpenditures());
    }

    private List<Expenditure> getExpenditures(){

        List<Expenditure> expenditures = new ArrayList<>();

        Optional<Category> foodCatOptional = categoryRepository.findByName("Food");

        if(!foodCatOptional.isPresent())
            throw new RuntimeException("Food category not found!");

        Optional<Category> carCatOptional = categoryRepository.findByName("Car");

        if(!carCatOptional.isPresent())
            throw new RuntimeException("Car category not found!");

        Optional<Category> flatCatOptional = categoryRepository.findByName("Flat");

        if(!flatCatOptional.isPresent())
            throw new RuntimeException("Flat category not found!");

        Optional<SubCategory> restaurantSubCatOptional = subCategoryRepository.findByName("Restaurant");

        if(!restaurantSubCatOptional.isPresent())
            throw new RuntimeException("Restaurant sub-category not found!");

        Optional<SubCategory> milkSubCatOptional = subCategoryRepository.findByName("Milk");

        if(!milkSubCatOptional.isPresent())
            throw new RuntimeException("Milk sub-category not found!");

        Optional<SubCategory> sugarSubCatOptional = subCategoryRepository.findByName("Sugar");

        if(!sugarSubCatOptional.isPresent())
            throw new RuntimeException("Sugar sub-category not found!");

        Optional<SubCategory> gasolineSubCatOptional = subCategoryRepository.findByName("Gasoline");

        if(!gasolineSubCatOptional.isPresent())
            throw new RuntimeException("Gasoline sub-category not found!");

        Optional<SubCategory> insuranceSubCatOptional = subCategoryRepository.findByName("Insurance");

        if(!insuranceSubCatOptional.isPresent())
            throw new RuntimeException("Insurance sub-category not found!");

        Optional<SubCategory> rentSubCatOptional = subCategoryRepository.findByName("Rent");

        if(!rentSubCatOptional.isPresent())
            throw new RuntimeException("Rent sub-category not found!");

        Optional<SubCategory> loanSubCatOptional = subCategoryRepository.findByName("Loan installment");

        if(!loanSubCatOptional.isPresent())
            throw new RuntimeException("Loan installment sub-category not found!");

        Category foodCat = foodCatOptional.get();
        Category carCat = carCatOptional.get();
        Category flatCat = flatCatOptional.get();

        SubCategory restaurantSubCat = restaurantSubCatOptional.get();
        restaurantSubCat.setCategory(foodCat);
        subCategoryRepository.save(restaurantSubCat);

        SubCategory milkSubCat = milkSubCatOptional.get();
        milkSubCat.setCategory(foodCat);
        subCategoryRepository.save(milkSubCat);

        SubCategory sugarSubCat = sugarSubCatOptional.get();
        sugarSubCat.setCategory(foodCat);
        subCategoryRepository.save(sugarSubCat);

        SubCategory gasolineSubCat = gasolineSubCatOptional.get();
        gasolineSubCat.setCategory(carCat);
        subCategoryRepository.save(gasolineSubCat);

        SubCategory insuranceSubCat = insuranceSubCatOptional.get();
        insuranceSubCat.setCategory(carCat);
        subCategoryRepository.save(insuranceSubCat);

        SubCategory rentSubCat = rentSubCatOptional.get();
        rentSubCat.setCategory(flatCat);
        subCategoryRepository.save(rentSubCat);

        SubCategory loanSubCat = loanSubCatOptional.get();
        loanSubCat.setCategory(flatCat);
        subCategoryRepository.save(loanSubCat);

        User kamilUser = userRepository.findByLogin("kdanielski").get();
        User monikaUser = userRepository.findByLogin("mnowogorska").get();



        Expenditure sugar = new Expenditure();
        sugar.setUser(kamilUser);
        sugar.setCategory(foodCat);
        sugar.setSubCategory(sugarSubCat);
        sugar.setDate(LocalDate.now().minusDays(5));
        sugar.setValue(BigDecimal.valueOf(4.99));

        Expenditure milk = new Expenditure();
        milk.setUser(monikaUser);
        milk.setCategory(foodCat);
        milk.setSubCategory(milkSubCat);
        milk.setDate(LocalDate.now().minusDays(2));
        milk.setValue(BigDecimal.valueOf(2.99));

        Expenditure gasoline = new Expenditure();
        gasoline.setUser(kamilUser);
        gasoline.setCategory(carCat);
        gasoline.setSubCategory(gasolineSubCat);
        gasoline.setDate(LocalDate.now().minusDays(1));
        gasoline.setValue(BigDecimal.valueOf(245.43));

        expenditures.add(sugar);
        expenditures.add(milk);
        expenditures.add(gasoline);

        return expenditures;
    }

    private List<User> getUsers(){

        List<User> users = new ArrayList<>();

        User kamilUser = new User();
        kamilUser.setFirstName("Kamil");
        kamilUser.setLastName("Danielski");
        kamilUser.setEmail("kamil.danielski@gmail.com");
        kamilUser.setLogin("kdanielski");
        kamilUser.setPhone("695-585-499");

        User monikaUser = new User();
        monikaUser.setFirstName("Monika");
        monikaUser.setLastName("Nowogórska");
        monikaUser.setEmail("monika258@gmail.com");
        monikaUser.setLogin("mnowogorska");
        monikaUser.setPhone("661-802-820");

        users.add(kamilUser);
        users.add(monikaUser);

        return users;
    }


}
