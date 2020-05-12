package com.madpsyence.galaxyinsurgents.location

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import ktx.ashley.allOf
import ktx.ashley.mapperFor

class MovementSystem()
    : IteratingSystem(allOf(
        PositionComponent::class,
        VelocityComponent::class).get()) {
    private val positionMap = mapperFor<PositionComponent>()
    private val velocityMap = mapperFor<VelocityComponent>()

    override fun processEntity(entity: Entity, deltaTime: Float) {
        val positionComponent = positionMap[entity]
        val velocityComponent = velocityMap[entity]
        positionComponent.Position.x += velocityComponent.Velocity.x * deltaTime
        positionComponent.Position.y += velocityComponent.Velocity.y * deltaTime
    }
}