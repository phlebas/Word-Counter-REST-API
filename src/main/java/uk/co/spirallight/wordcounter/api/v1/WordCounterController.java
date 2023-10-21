package uk.co.spirallight.wordcounter.api.v1;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uk.co.spirallight.wordcounter.exception.InvalidWordException;
import uk.co.spirallight.wordcounter.service.SimpleWordCounter;
import uk.co.spirallight.wordcounter.service.WordCounter;

@RestController
@RequestMapping("/api/v1/words")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Word Counter", description = "Word Counter Library APIs")
public class WordCounterController {

  private final WordCounter wordCounter = new SimpleWordCounter();

  @PutMapping("/addwords")
  public void putWords(@RequestParam String word, @RequestParam String... additionalWords) {
    try {
      wordCounter.addWords(word, additionalWords);
    } catch (InvalidWordException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @GetMapping("/wordcount")
  public Integer getWordCount(@RequestParam String word) {
    return wordCounter.getWordCount(word);
  }
}
