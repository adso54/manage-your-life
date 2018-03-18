package eu.kamildanielski.manageyourlife.bootstrap;

import eu.kamildanielski.manageyourlife.domain.User;
import eu.kamildanielski.manageyourlife.repositories.CategoryRepository;
import eu.kamildanielski.manageyourlife.repositories.ExpenditureRepository;
import eu.kamildanielski.manageyourlife.repositories.SubCategoryRepository;
import eu.kamildanielski.manageyourlife.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
       // userRepository.saveAll(getUsers());

    }

    private List<User> user = new ArrayList<>(2);



}
