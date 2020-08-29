package ru.bedsus.spotifyapp.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ru.bedsus.spotifyapp.R
import ru.bedsus.spotifyapp.modules.playlist.view.PlaylistFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(R.id.vContainerFrag, PlaylistFragment())
            .commit()
    }
}