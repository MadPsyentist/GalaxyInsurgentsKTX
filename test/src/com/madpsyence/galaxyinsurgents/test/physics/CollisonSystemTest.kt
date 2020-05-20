package com.madpsyence.galaxyinsurgents.test.physics

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.signals.Signal
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector3
import com.madpsyence.galaxyinsurgents.location.PositionComponent
import com.madpsyence.galaxyinsurgents.physics.BoundingAreaComponent
import com.madpsyence.galaxyinsurgents.physics.CollisionSystem
import com.madpsyence.galaxyinsurgents.physics.PhysicsEvent
import ktx.ashley.mapperFor
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class CollisonSystemTest {
    var engine = Engine()
    var entityA = Entity()
    var entityB = Entity()

    @BeforeEach
    fun testSetup() {
        engine = Engine()
        entityA = Entity()
        var positionA = PositionComponent(Vector3(10.0f, 10.0f, 0.0f))
        var boundingAreaA = BoundingAreaComponent(Rectangle(0.0f, 0.0f, 10.0f, 10.0f))
        entityA.add(positionA)
        entityA.add(boundingAreaA)

        entityB = Entity()
        var positionB = PositionComponent(Vector3(5.0f, 5.0f, 0.0f))
        var boundingAreaB = BoundingAreaComponent(Rectangle(20.0f, 20.0f, 20.0f, 20.0f))
        entityB.add(positionB)
        entityB.add(boundingAreaB)

        engine.addEntity(entityA)
        engine.addEntity(entityB)
    }

    @Test
    fun updates_bounding_area_with_position() {
        val entity = Entity()
        val position = PositionComponent(Vector3(10.0f, 10.0f, 0.0f))
        val boundingArea = BoundingAreaComponent(Rectangle(0.0f, 0.0f, 30.0f, 30.0f))
        entity.add(position)
        entity.add(boundingArea)

        val collisonSys = CollisionSystem()

        engine.addEntity(entity)
        engine.addSystem(collisonSys)
        engine.update(1.0f)

        assertEquals(10.0f, boundingArea.Area.x, 0.00001f)
        assertEquals(10.0f, boundingArea.Area.y, 0.00001f)
    }

//    @Test
//    fun broadcasts_physics_event_when_two_entitys_have_overlaping_areas() {
//        val entityA = Entity()
//        val positionA = PositionComponent(Vector3(10.0f, 10.0f, 0.0f))
//        val boundingAreaA = BoundingAreaComponent(Rectangle(0.0f, 0.0f, 10.0f, 10.0f))
//        entityA.add(positionA)
//        entityA.add(boundingAreaA)
//
//        val entityB = Entity()
//        val positionB = PositionComponent(Vector3(5.0f, 5.0f, 0.0f))
//        val boundingAreaB = BoundingAreaComponent(Rectangle(20.0f, 20.0f, 10.0f, 10.0f))
//        entityB.add(positionB)
//        entityB.add(boundingAreaB)
//
//        val mockCollison = Mockito.mock(CollisionSystem::class.java)
//        val collisionSystem = CollisionSystem()
//        val signal = collisionSystem.Signal()
//
//        engine.addEntity(entityA)
//        engine.addEntity(entityB)
//        engine.addSystem(collisionSystem)
//        engine.update(1.0f)
//
//        // val updatedArea = collisionSystem.updateAreaPosition(boundingArea, position)
//        assertEquals(10.0f, boundingArea.Area.x, 0.00001f)
//        assertEquals(10.0f, boundingArea.Area.y, 0.00001f)
//    }
//
//    @Test
//    fun broadcasts_no_physicis_event_if_no_entities_overlap() {
//        assertEquals(1 , 2)
//    }
}