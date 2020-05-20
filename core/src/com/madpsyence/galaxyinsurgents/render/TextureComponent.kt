package com.madpsyence.galaxyinsurgents.render

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Vector2

class TextureComponent(var Texture: TextureRegion, var TextureOrigin: Vector2, var Scale: Vector2, var Rotation: Float)
    : Component {
}