package game;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private int score = 0;
    private int attempts = 3;
    private String word;
    private String mix;
    private MixedWord mixed = new MixedWord();

    @GetMapping("/game")
    public String showGame(Model model) {
        mixed.getRandom();
        word = mixed.getWord();
        mix = mixed.mixWord();
        model.addAttribute("mix", mix);
        model.addAttribute("score",score);
        model.addAttribute("attemps", attempts);
        if (attempts==0) {
            return "finish";
        }  if (mixed.wordsIsEmpty() == true) {
            return "finish";
        } else  return "game";
    }

    @PostMapping("/game")
    public String postGame(@RequestParam String answer, Model model) {
        if (answer.equals(word)) {
            score++;
            return "true";
        } else {
            attempts--;
            return "false";
        }
    }
}
