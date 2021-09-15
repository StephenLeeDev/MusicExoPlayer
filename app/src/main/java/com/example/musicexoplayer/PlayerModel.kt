package com.example.musicexoplayer

data class PlayerModel(
    private val playerMusicList: List<MusicModel> = emptyList(),
    var currentPosition: Int = -1,
    var isWatchingPlayListView: Boolean = true
) {

    fun getAdapterModels(): List<MusicModel> {
        return playerMusicList.mapIndexed{ index, musicModel ->
            val newItem = musicModel.copy(
                isPlaying = index == currentPosition
            )
            newItem
        }
    }

    fun updateCurrentPosition(musicModel: MusicModel) {
        currentPosition = playerMusicList.indexOf(musicModel)
    }

    fun nextMusic(): MusicModel? {
        if (playerMusicList.isEmpty()) {
            return null
        }

        currentPosition = if ((currentPosition + 1) == playerMusicList.size) 0 else currentPosition + 1
        return playerMusicList[currentPosition]
    }

    fun prevMusic(): MusicModel? {
        if (playerMusicList.isEmpty()) {
            return null
        }

        currentPosition = if ((currentPosition - 1) < 0) playerMusicList.lastIndex else currentPosition - 1
        return playerMusicList[currentPosition]
    }

    fun currentMusicModel(): MusicModel? {
        if (playerMusicList.isEmpty()) {
            return null
        }

        return playerMusicList[currentPosition]
    }
}
