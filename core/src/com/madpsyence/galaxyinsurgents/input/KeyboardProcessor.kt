package com.madpsyence.galaxyinsurgents.input

import com.badlogic.ashley.signals.Signal
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputProcessor

class KeyboardProcessor(val InputEventsSignal: Signal<InputEvent>) : InputProcessor {
    override fun keyDown(keycode: Int): Boolean {
        when(keycode) {
            Input.Keys.LEFT -> InputEventsSignal.dispatch(InputEvent.MoveLeft)
            Input.Keys.RIGHT -> InputEventsSignal.dispatch(InputEvent.MoveRight)
            Input.Keys.SPACE -> InputEventsSignal.dispatch(InputEvent.Fire)
        }
        return false
    }

    override fun keyUp(keycode: Int): Boolean {
        when(keycode) {
            Input.Keys.LEFT -> InputEventsSignal.dispatch(InputEvent.StopLeft)
            Input.Keys.RIGHT -> InputEventsSignal.dispatch(InputEvent.StopRight)
            Input.Keys.SPACE -> InputEventsSignal.dispatch(InputEvent.CeaseFire)
        }
        return false
    }

    override fun keyTyped(character: Char): Boolean {
        return false
    }

    override fun touchDown(x: Int, y: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun touchUp(x: Int, y: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun touchDragged(x: Int, y: Int, pointer: Int): Boolean {
        return false
    }

    override fun mouseMoved(x: Int, y: Int): Boolean {
        return false
    }

    override fun scrolled(amount: Int): Boolean {
        return false
    }

}