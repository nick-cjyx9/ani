package me.him188.animationgarden.datasources.bangumi.client

import me.him188.animationgarden.datasources.api.Paged
import me.him188.animationgarden.datasources.bangumi.models.search.BangumiSort
import me.him188.animationgarden.datasources.bangumi.models.subjects.BangumiSubject
import me.him188.animationgarden.datasources.bangumi.models.subjects.BangumiSubjectDetails
import me.him188.animationgarden.datasources.bangumi.models.subjects.BangumiSubjectImageSize
import me.him188.animationgarden.datasources.bangumi.models.subjects.BangumiSubjectType

interface BangumiClientSubjects {
    /**
     * 搜索条目.
     *
     * @param keyword 关键字, 例如番剧名称
     * @param types 条目类型, 默认为 [BangumiSubjectType.ANIME]
     * @param responseGroup 返回数据大小, 默认为 [BangumiResponseGroup.SMALL]
     * @param offset 开始条数, 默认为 0
     * @param limit 返回条数, 最大为 25
     * @return 搜索结果, null 表示已经到达最后一条
     */
    suspend fun searchSubjectByKeywords(
        keyword: String,
        offset: Int? = null,
        limit: Int? = null,
        sort: BangumiSort? = null,
        types: List<BangumiSubjectType>? = null,
        tags: List<String>? = null, // "童年", "原创"
        airDates: List<String>? = null, // YYYY-MM-DD
        ratings: List<String>? = null, // ">=6", "<8"
        ranks: List<String>? = null,
        nsfw: Boolean? = null,
    ): Paged<BangumiSubject>

    suspend fun getSubjectById(
        id: Long,
    ): BangumiSubjectDetails?

    suspend fun getSubjectImageUrl(
        id: Long,
        size: BangumiSubjectImageSize,
    ): String
}