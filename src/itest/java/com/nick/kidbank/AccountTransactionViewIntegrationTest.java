package com.nick.kidbank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AccountTransactionViewIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void newAccountViewHasNoTransactions() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/"))
                .andReturn();

        Collection<TransactionView> transactions = transactionsFromModel(mvcResult);
        assertThat(transactions).isEmpty();
    }

    @Test
    public void depositToNewAccountShouldHaveOneDepositTransaction() throws Exception {
        mockMvc.perform(post("/deposit")
                        .param("amount", "12.45")
                        .param("source", "the source")
                        .param("date", "10/29/2019"))
                .andExpect(redirectedUrl("/"));

        MvcResult mvcResult = mockMvc.perform(get("/"))
                .andReturn();

        Collection<TransactionView> transactions = transactionsFromModel(mvcResult);
        assertThat(transactions)
                .containsExactly(new TransactionView("10/29/2019", "Deposit", "$12.45", "the source"));
    }

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    private Collection<TransactionView> transactionsFromModel(MvcResult mvcResult) {
        return (Collection<TransactionView>) mvcResult.getModelAndView().getModel().get("transactions");
    }
}
