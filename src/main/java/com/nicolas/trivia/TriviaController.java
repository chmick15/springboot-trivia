package com.nicolas.trivia;

import com.nicolas.trivia.entities.Categoria;
import com.nicolas.trivia.entities.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriviaController {
    @GetMapping("/hola")
    public String holaMundo(){
        return "Hello Wooooorld";
    }

    @GetMapping("/categories")
    public Categoria[] getCategories(){
        Categoria cat = new Categoria();
        cat.setCategory("Cultura");
        cat.setDescription("Preguntas relacionadas con arte, literatura, música y otras expresiones culturales.");

        Categoria cat2 = new Categoria();
        cat2.setCategory("Deportes");
        cat2.setDescription("Preguntas relacionadas con diversos deportes y eventos deportivos.");

        //Categoria[] categorias = {cat, cat2};

        Categoria[] categorias = new Categoria[2];
        categorias[0] = cat;
        categorias[1] = cat2;
        return categorias;
    }

    @GetMapping("/question/{categoria}")
    public Question getQuestion(@PathVariable String categoria){
        Question pregunta = new Question();
        pregunta.setCategory("Cultura");
        pregunta.setQuestion("Quel célèbre dramaturge a écrit 'Roméo et Juliette' ?");
        pregunta.setAnswer(0);
        pregunta.setExplanation("C'est effectivement le dramaturge Shakespeare, William de son prénom qui a écrit 'Roméo et Juliette'");
        String[] options = {"A. William Shakespeare","B. Anton Tchekhov","C. Molière"};
        pregunta.setOptions(options);
        return pregunta;
    }
}
