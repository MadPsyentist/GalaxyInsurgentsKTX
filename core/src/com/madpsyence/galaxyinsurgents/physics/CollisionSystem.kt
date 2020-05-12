package com.madpsyence.galaxyinsurgents.physics

import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.madpsyence.galaxyinsurgents.engine.BroadcastSystem
import com.madpsyence.galaxyinsurgents.location.PositionComponent
import ktx.ashley.allOf
import ktx.ashley.mapperFor

class CollisionSystem:
        BroadcastSystem<PhysicsEvent>(allOf(BoundingAreaComponent::class, PositionComponent::class).get()) {
    private val positionMap = mapperFor<PositionComponent>()
    private val boundingAreaMap = mapperFor<BoundingAreaComponent>()

    override fun update(deltaTime: Float) {
        for (i in 0 until entities.size() - 1) {
            val entityA = entities[i]
            val entityABoundingArea = boundingAreaMap[entityA]
            updateAreaPosition(entityABoundingArea, positionMap[entityA])
            for (j in i + 1 until entities.size()) {
                val entityB = entities[j]
                val entityBBoundingArea = boundingAreaMap[entityB]
                updateAreaPosition(entityABoundingArea, positionMap[entityB])
                if (entityABoundingArea.Area.overlaps(entityBBoundingArea.Area)) {
                    Signal().dispatch(PhysicsEvent(entityA, entityB))
                }
            }
        }
    }

    fun updateAreaPosition(boundingArea: BoundingAreaComponent, position: PositionComponent) : BoundingAreaComponent {
        boundingArea.Area.setPosition(position.Position.x, position.Position.y)
        return boundingArea
    }
}