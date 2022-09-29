package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreatedTrelloCardDtoTestSuite {

    @Test
    void shouldCreateCardWithNoArgsTest() {
        //Given & When
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto();

        //Then
        assertNull(createdTrelloCardDto.getId());
        assertNull(createdTrelloCardDto.getName());
        assertNull(createdTrelloCardDto.getShortUrl());
    }
}