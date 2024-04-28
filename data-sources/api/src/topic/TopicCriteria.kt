package me.him188.ani.datasources.api.topic

import me.him188.ani.datasources.api.EpisodeSort
import me.him188.ani.datasources.api.source.MediaFetchRequest

class TopicCriteria(
    val episodeSort: EpisodeSort?,
    val episodeEp: EpisodeSort?,
) {
    companion object {
        val ANY = TopicCriteria(null, null)
    }
}

fun TopicCriteria.matches(topic: Topic, allowEpMatch: Boolean): Boolean {
    val details = topic.details ?: return true
    if (!isEpisodeSortMatch(details)) {
        if (!allowEpMatch) return false
        if (!isEpisodeEpMatch(details)) return false
    }
    return true
}

private fun TopicCriteria.isEpisodeSortMatch(details: TopicDetails): Boolean {
    episodeSort?.let { expected ->
        val ep = details.episodeRange
        if (ep != null && expected !in ep) return false
    }
    return true
}

private fun TopicCriteria.isEpisodeEpMatch(details: TopicDetails): Boolean {
    episodeEp?.let { expected ->
        val ep = details.episodeRange
        if (ep != null && expected !in ep) return false
    }
    return true
}


fun MediaFetchRequest.toTopicCriteria(): TopicCriteria {
    return TopicCriteria(
        episodeSort = episodeSort,
        episodeEp = episodeEp,
    )
}