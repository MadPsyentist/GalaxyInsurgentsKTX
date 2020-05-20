package com.madpsyence.galaxyinsurgents.render

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.madpsyence.galaxyinsurgents.location.PositionComponent
import ktx.ashley.allOf
import ktx.ashley.mapperFor
import java.util.Comparator

class DepthComparator : Comparator<Entity?> {
    private val positionMap = mapperFor<PositionComponent>()
    override fun compare(o: Entity?, t1: Entity?): Int {
        return Math.round(positionMap[o].Position.z - positionMap[t1].Position.z)
    }
}