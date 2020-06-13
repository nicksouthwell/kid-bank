package com.nick.kidbank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AccountDepositIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homePageExists() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void submitDepositAddsAmountToAccount() throws Exception {
        mockMvc.perform(post("/deposit")
                .param("amount", "12.45")
                .param("date", "2019-10-29")
                .param("source", "the source"))
                .andExpect(redirectedUrl("/"));

        mockMvc.perform(get("/"))
                .andExpect(model().attribute("balance", "$12.45"));
    }
}
