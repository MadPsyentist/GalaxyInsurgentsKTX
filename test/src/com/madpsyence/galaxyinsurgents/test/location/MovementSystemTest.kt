package com.madpsyence.tavernkeeper.test.location

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.math.Vector3
import com.madpsyence.galaxyinsurgents.location.MovementSystem
import com.madpsyence.galaxyinsurgents.location.PositionComponent
import com.madpsyence.galaxyinsurgents.location.VelocityComponent
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach

class MovementSystemTest {
    var engine = Engine()

    @BeforeEach
    fun testSetup() {
        engine = Engine()
    }

    @Test
    fun updates_position_with_velocity() {
        val position = PositionComponent(Vector3(1.0f,1.0f,0.0f))
        val velocity = VelocityComponent(Vector3(10.0f,10.0f,0.0f))
        val entity = Entity()
        entity.add(position)
        entity.add(velocity)

        engine.addEntity(entity)
        engine.addSystem(MovementSystem())

        engine.update(1.0f)

        assertEquals( 11.0f,position.Position.x, 0.00001f)
        assertEquals( 11.0f, position.Position.y,0.00001f)
    }

    @Test
    fun updates_position_with_half_of_velocity_when_time_delta_is_half() {
        val position = PositionComponent(Vector3(1.0f,1.0f,0.0f))
        val velocity = VelocityComponent(Vector3(10.0f,10.0f,0.0f))
        val entity = Entity()
        entity.add(position)
        entity.add(velocity)

        engine.addEntity(entity)
        engine.addSystem(MovementSystem())

        engine.update(0.5f)

        assertEquals(6.0f, position.Position.x, 0.00001f)
        assertEquals(6.0f, position.Position.y, 0.00001f)
    }
}