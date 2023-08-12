package com.nicolas.trivia;

import com.nicolas.trivia.entities.Category;
import com.nicolas.trivia.entities.Question;
import com.nicolas.trivia.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TriviaController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/hola")
    public String holaMundo(){
        return "Hello Wooooorld";
    }

    @GetMapping("/search-{id}")
    public Category findById(@PathVariable Long id){
        return categoryRepository.findById(id);
    }


    @GetMapping("/categories")
    public Category[] getCategories(){
        Category cat = new Category();
        cat.setName("Cultura");
        cat.setDescription("Preguntas relacionadas con arte, literatura, música y otras expresiones culturales.");

        Category cat2 = new Category();
        cat2.setName("Deportes");
        cat2.setDescription("Preguntas relacionadas con diversos deportes y eventos deportivos.");

        //Categoria[] categorias = {cat, cat2};

        Category[] categories = new Category[2];
        categories[0] = cat;
        categories[1] = cat2;
        return categories;
    }

    @GetMapping("/question/{categoria}")
    public Question getQuestion(@PathVariable String categoria){
        Question pregunta = new Question();
        pregunta.setQuestion("Quel célèbre dramaturge a écrit 'Roméo et Juliette' ?");
        pregunta.setAnswer(0);
        pregunta.setExplanation("C'est effectivement le dramaturge Shakespeare, William de son prénom qui a écrit 'Roméo et Juliette'");
        String[] options = {"A. William Shakespeare","B. Anton Tchekhov","C. Molière"};
        pregunta.setOptions(options);
        return pregunta;
    }
}
