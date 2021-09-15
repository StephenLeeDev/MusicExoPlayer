package com.example.musicexoplayer

import com.example.musicexoplayer.service.MusicDto
import com.example.musicexoplayer.service.MusicEntity

fun MusicEntity.mapper(id: Long): MusicModel =
    MusicModel(
        id = id,
        track = track,
        streamUrl = streamUrl,
        artist = artist,
        coverUrl = coverUrl
    )

fun MusicDto.mapper(): PlayerModel =
    PlayerModel(
        playerMusicList = musics.mapIndexed { index, musicEntity ->
            musicEntity.mapper(index.toLong())
        }
    )