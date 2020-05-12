package com.madpsyence.galaxyinsurgents.engine

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.signals.Signal
import com.badlogic.ashley.utils.ImmutableArray
import com.badlogic.gdx.utils.Array
import com.madpsyence.galaxyinsurgents.location.PositionComponent
import com.madpsyence.galaxyinsurgents.physics.BoundingAreaComponent
import ktx.ashley.allOf
import ktx.ashley.mapperFor

abstract class BroadcastSystem<T>(val family: Family): EntitySystem() {
    protected var entities = ImmutableArray<Entity>(Array<Entity>())
    protected val signal = Signal<T>()

    override fun addedToEngine(engine: Engine) {
        super.addedToEngine(engine)
        entities = engine.getEntitiesFor(family)
    }

    override fun removedFromEngine(engine: Engine) {
        entities = ImmutableArray<Entity>(Array<Entity>())
    }

    fun Signal(): Signal<T> {
        return signal
    }
}