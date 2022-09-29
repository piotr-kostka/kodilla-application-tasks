package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloListDtoTestSuite {
    @Test
    void shouldCreateTrelloListDto() {
        //Given & When
        TrelloListDto trelloList = new TrelloListDto("1", "name", true);

        //Then
        assertEquals("1", trelloList.getId());
        assertEquals("name", trelloList.getName());
        assertTrue(trelloList.isClosed());
    }
}