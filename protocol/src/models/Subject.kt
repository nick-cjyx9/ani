/*
 * Animation Garden App
 * Copyright (C) 2022  Him188
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package me.him188.animationgarden.shared.models

import kotlinx.serialization.Serializable
import me.him188.animationgarden.datasources.api.DataSourceSubjectImages

@Serializable
data class Subject(
    val id: String, // database id
    val officialName: String,
    val chineseName: String,
    val dataSourceId: String,

    val episodeCount: Int,
    /**
     * 平均评分
     */
    val ratingScore: Double,
    /**
     * 评分人数
     */
    val ratingCount: Int,
    val rank: Int,
    val sourceUrl: String, // 数据源
    val images: DataSourceSubjectImages,
)

interface SubjectImages {
    /**
     * Get image URL for grid view.
     */
    fun forGrid(): String?

    fun forPoster(): String?
}
