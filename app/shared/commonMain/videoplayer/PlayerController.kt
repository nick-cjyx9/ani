package me.him188.ani.app.videoplayer

import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import me.him188.ani.app.platform.Context
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * 播放器控制器. 控制暂停, 播放速度等.
 */
interface PlayerController {
    @Stable
    val state: StateFlow<PlayerState>

    @Stable
    val videoProperties: Flow<VideoProperties>

    /**
     * 是否正在 buffer (暂停视频中)
     */
    @Stable
    val isBuffering: Flow<Boolean>

    /**
     * 当前播放进度秒数
     */
    @Stable
    val playedDuration: StateFlow<Duration>

    @Stable
    val bufferProgress: StateFlow<Float>

    /**
     * 当前播放进度比例 `0..1`
     */
    @Stable
    val playProgress: StateFlow<Float>

    /**
     * 暂停播放, 直到 [pause]
     */
    fun pause()

    /**
     * 恢复播放
     */
    fun resume()

    fun setSpeed(speed: Float)
}

abstract class AbstractPlayerController : PlayerController {
    override val isBuffering: Flow<Boolean> by lazy {
        state.map { it == PlayerState.PAUSED_BUFFERING }
    }
}


enum class PlayerState(
    val isPlaying: Boolean,
) {
    /**
     * Player is loaded and will be playing as soon as metadata and first frame is available.
     */
    READY(isPlaying = false),

    /**
     * 用户主动暂停. buffer 继续充, 但是充好了也不要恢复 [PLAYING].
     */
    PAUSED(isPlaying = false),

    PLAYING(isPlaying = true),

    /**
     * 播放中但因没 buffer 就暂停了. buffer 填充后恢复 [PLAYING].
     */
    PAUSED_BUFFERING(isPlaying = false),

    FINISHED(isPlaying = false),
    ;
}

fun interface PlayerControllerFactory {
    fun create(context: Context, videoSource: Flow<VideoSource<*>?>): PlayerController
}

/**
 * For previewing
 */
class DummyPlayerController : PlayerController {
    override val state: StateFlow<PlayerState> = MutableStateFlow(PlayerState.PAUSED_BUFFERING)
    override val videoProperties: Flow<VideoProperties> = MutableStateFlow(
        VideoProperties(
            title = "Test Video",
            heightPx = 1080,
            widthPx = 1920,
            videoBitrate = 100,
            audioBitrate = 100,
            frameRate = 30f,
            duration = 100.seconds,
        )
    )
    override val isBuffering: Flow<Boolean> = MutableStateFlow(true)
    override val playedDuration: StateFlow<Duration> = MutableStateFlow(10.seconds)
    override val bufferProgress: StateFlow<Float> = MutableStateFlow(0.5f)
    override val playProgress: StateFlow<Float> = MutableStateFlow(0.3f)

    override fun pause() {
    }

    override fun resume() {
    }

    override fun setSpeed(speed: Float) {
    }
}