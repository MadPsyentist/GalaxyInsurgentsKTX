package com.madpsyence.galaxyinsurgents.render

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.SortedIteratingSystem
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.madpsyence.galaxyinsurgents.location.PositionComponent
import ktx.ashley.allOf
import ktx.ashley.mapperFor

class RenderSystem(val batch: SpriteBatch, val camera: OrthographicCamera)
    : SortedIteratingSystem(allOf(PositionComponent::class, TextureComponent::class).get(), DepthComparator()) {
    private val textureMap = mapperFor<TextureComponent>()
    private val positionMap = mapperFor<PositionComponent>()
    override fun update(deltaTime: Float) {
        camera.update()
        batch.projectionMatrix = camera.combined
        batch.begin()
        super.update(deltaTime)
        batch.end()
    }

    public override fun processEntity(entity: Entity, deltaTime: Float) {
        val tex = textureMap[entity]
        val pos = positionMap[entity]
        batch.draw(tex.Texture, pos.Position.x - tex.TextureOrigin.x,
                pos.Position.y - tex.TextureOrigin.y,
                tex.TextureOrigin.x, tex.TextureOrigin.y,
                tex.Texture.getRegionWidth().toFloat(), tex.Texture.getRegionHeight().toFloat(),
                tex.Scale.x * CONST.PIXELS_TO_METERS, tex.Scale.y * CONST.PIXELS_TO_METERS,
                MathUtils.radiansToDegrees * tex.Rotation)
    }
}