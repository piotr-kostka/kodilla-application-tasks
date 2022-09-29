package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloCardDtoTestSuite {

    @Test
    void shouldCreateTrelloBoardWithNoArgsTest() {
        //Given & When
        TrelloCardDto trelloCardDto = new TrelloCardDto();

        //Then
        assertNull(trelloCardDto.getListId());
        assertNull(trelloCardDto.getName());
        assertNull(trelloCardDto.getDescription());
        assertNull(trelloCardDto.getPos());
    }

    @Test
    void shouldCreateTrelloBoardWithAllArgsTest() {
        //Given & When
        TrelloCardDto trelloCardDto = new TrelloCardDto();
        trelloCardDto.setName("test");
        trelloCardDto.setDescription("description");
        trelloCardDto.setPos("position");
        trelloCardDto.setListId("1");

        //Then
        assertNotNull(trelloCardDto.getName());
        assertNotNull(trelloCardDto.getDescription());
        assertNotNull(trelloCardDto.getPos());
        assertNotNull(trelloCardDto.getListId());
        assertEquals("test", trelloCardDto.getName());
        assertEquals("description", trelloCardDto.getDescription());
        assertEquals("position", trelloCardDto.getPos());
        assertEquals("1", trelloCardDto.getListId());
    }
}