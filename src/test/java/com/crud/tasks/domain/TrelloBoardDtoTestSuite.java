package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloBoardDtoTestSuite {

    @Test
    void shouldCreateTrelloBoardWithNoArgsTest() {
        //Given & When
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto();

        //Then
        assertNull(trelloBoardDto.getId());
        assertNull(trelloBoardDto.getName());
        assertNull(trelloBoardDto.getLists());
    }

    @Test
    void shouldCreateTrelloBoardWithAllArgsTest() {
        //Given & When
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto();
        trelloBoardDto.setId("1");
        trelloBoardDto.setName("test");
        trelloBoardDto.setLists(new ArrayList<>());

        //Then
        assertNotNull(trelloBoardDto.getId());
        assertNotNull(trelloBoardDto.getName());
        assertNotNull(trelloBoardDto.getLists());
        assertEquals("1", trelloBoardDto.getId());
        assertEquals("test", trelloBoardDto.getName());
        assertEquals(new ArrayList<>(), trelloBoardDto.getLists());
    }
}