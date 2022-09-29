package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloListTestSuite {
    @Test
    void shouldCreateTrelloListWithNoArgsTest() {
        //Given & When
        TrelloList trelloList = new TrelloList();

        //Then
        assertNull(trelloList.getId());
        assertNull(trelloList.getName());
        assertFalse(trelloList.isClosed());
    }
}