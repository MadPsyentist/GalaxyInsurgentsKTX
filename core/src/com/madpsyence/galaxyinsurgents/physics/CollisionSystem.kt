package com.madpsyence.galaxyinsurgents.physics

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.madpsyence.galaxyinsurgents.engine.BroadcastSystem
import com.madpsyence.galaxyinsurgents.location.PositionComponent
import ktx.ashley.allOf
import ktx.ashley.mapperFor
import java.io.Console

class CollisionSystem:
        BroadcastSystem<PhysicsEvent>(allOf(BoundingAreaComponent::class, PositionComponent::class).get()) {
    private val positionMap = mapperFor<PositionComponent>()
    private val boundingAreaMap = mapperFor<BoundingAreaComponent>()

    override fun update(deltaTime: Float) {
        for (i in 0 until entities.size() - 1) {
            var entityA = entities[i]
            var entityABoundingArea = boundingAreaMap[entityA]
            updateAreaPosition(entityABoundingArea, positionMap[entityA])
            for (j in i + 1 until entities.size()) {
                var entityB = entities[j]
                var entityBBoundingArea = boundingAreaMap[entityB]
                updateAreaPosition(entityABoundingArea, positionMap[entityB])
                if (entityABoundingArea.Area.overlaps(entityBBoundingArea.Area)) {
                    Signal().dispatch(PhysicsEvent(entityA, entityB))
                }
            }
        }
    }

    fun updateAreaPosition(boundingArea: BoundingAreaComponent, position: PositionComponent) : BoundingAreaComponent {
        System.out.println(boundingArea.toString())
        boundingArea.Area.setPosition(position.Position.x, position.Position.y)
        return boundingArea
    }
}