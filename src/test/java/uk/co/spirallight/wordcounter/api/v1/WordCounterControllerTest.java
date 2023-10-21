package uk.co.spirallight.wordcounter.api.v1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WordCounterController.class)
class WordCounterControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  void putWords() throws Exception {
    mvc.perform(put("/api/v1/words/addwords")
            .param("word", "word")
            .param("additionalWords", ""))
        .andExpect(status().isOk());
  }

  @Test
  void putInvalidWords() throws Exception {
    mvc.perform(put("/api/v1/words/addwords")
            .param("word", "word123")
            .param("additionalWords", ""))
        .andExpect(status().isBadRequest());
  }

  @Test
  void getWordCount() throws Exception {
    mvc.perform(get("/api/v1/words/wordcount").param("word", "word"))
        .andExpect(status().isOk())
        .andExpect(content().string("0"));
  }
}