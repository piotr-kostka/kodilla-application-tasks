package com.crud.tasks.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ConfigTestSuite {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    void getAdminMail() {
        //When
        String result = adminConfig.getAdminMail();

        //Then
        assertEquals("piotrek.kostka94@gmail.com", result);
    }

    @Test
    void getTrelloConfigTest() {
        //When
        String apiEndpoint = trelloConfig.getTrelloApiEndpoint();
        String appKey = trelloConfig.getTrelloAppKey();
        String trelloToken = trelloConfig.getTrelloToken();
        String trelloUsername = trelloConfig.getTrelloUsername();

        //Then
        assertEquals("https://api.trello.com/1", apiEndpoint);
        assertEquals("6f1e93bad28b95e1d6759ebaca87e330", appKey);
        assertEquals("28e7fa5fb42d29f349e8696daaaa4f468e708ff79e6ac948717011f589550459", trelloToken);
        assertEquals("piotrekkostka", trelloUsername);
    }
}