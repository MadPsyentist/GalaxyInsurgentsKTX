package com.madpsyence.galaxyinsurgents.desktop

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.madpsyence.galaxyinsurgents.GalaxyInsurgents

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = Lwjgl3ApplicationConfiguration()
        config.setTitle("Galaxy Insurgents")
        config.setWindowedMode(1920, 1080)

        Lwjgl3Application(GalaxyInsurgents(), config)
    }
}