package com.madpsyence.galaxyinsurgents.test.physics

import com.badlogic.ashley.core.Engine
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CollisonSystemTest {
    var engine = Engine()

    @BeforeEach
    fun testSetup() {
        engine = Engine()
    }

    @Test
    fun updates_bounding_area_with_position() {
        assertEquals(1 , 2)
    }

    @Test
    fun broadcasts_physics_event_when_two_entitys_have_overlaping_areas() {
        assertEquals(1 , 2)
    }
}