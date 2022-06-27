package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.models.Potion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class PotionServiceTest {
    @Autowired
    PotionService potionService;

    @Test
    public void testAddNewPotion() {
        Potion potion1 = new Potion("PP Increase");
        potionService.addNewPotion(potion1);
        assertTrue(potionService.getPotions().contains(potion1));
    }
}
