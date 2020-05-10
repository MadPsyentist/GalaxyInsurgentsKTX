package com.madpsyence.galaxyinsurgents.location

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import ktx.ashley.allOf

class MovementSystem : IteratingSystem(allOf(
    PositionComponent::class,
    VelocityComponent::class).get()) {
    private val positionMap = ComponentMapper.getFor(PositionComponent::class.java)
    private val velocityMap = ComponentMapper.getFor(VelocityComponent::class.java)

    override fun processEntity(entity: Entity, deltaTime: Float) {
        val positionComponent = positionMap[entity]
        val velocityComponent = velocityMap[entity]
        positionComponent.Position.x += velocityComponent.Velocity.x * deltaTime
        positionComponent.Position.y += velocityComponent.Velocity.y * deltaTime
    }
}