/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport",
)

package me.him188.ani.datasources.bangumi.models


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 *
 *
 * @param id
 * @param type `0` 本篇，`1` SP，`2` OP，`3` ED
 * @param name
 * @param nameCn
 * @param sort 同类条目的排序和集数
 * @param airdate
 * @param comment
 * @param duration 维基人填写的原始时长
 * @param desc 简介
 * @param disc 音乐曲目的碟片数
 * @param ep 条目内的集数, 从`1`开始。非本篇剧集的此字段无意义
 * @param durationSeconds 服务器解析的时长，无法解析时为 `0`
 */
@Serializable

data class BangumiEpisode(

    @SerialName(value = "id") @Required val id: kotlin.Int,

    /* `0` 本篇，`1` SP，`2` OP，`3` ED */
    @SerialName(value = "type") @Required val type: kotlin.Int,

    @SerialName(value = "name") @Required val name: kotlin.String,

    @SerialName(value = "name_cn") @Required val nameCn: kotlin.String,

    /* 同类条目的排序和集数 */
    @SerialName(value = "sort") @Required val sort: @Serializable(me.him188.ani.utils.serialization.BigNumAsDoubleStringSerializer::class) me.him188.ani.utils.serialization.BigNum,

    @SerialName(value = "airdate") @Required val airdate: kotlin.String,

    @SerialName(value = "comment") @Required val comment: kotlin.Int,

    /* 维基人填写的原始时长 */
    @SerialName(value = "duration") @Required val duration: kotlin.String,

    /* 简介 */
    @SerialName(value = "desc") @Required val desc: kotlin.String,

    /* 音乐曲目的碟片数 */
    @SerialName(value = "disc") @Required val disc: kotlin.Int,

    /* 条目内的集数, 从`1`开始。非本篇剧集的此字段无意义 */
    @SerialName(value = "ep") val ep: @Serializable(me.him188.ani.utils.serialization.BigNumAsDoubleStringSerializer::class) me.him188.ani.utils.serialization.BigNum? = null,

    /* 服务器解析的时长，无法解析时为 `0` */
    @SerialName(value = "duration_seconds") val durationSeconds: kotlin.Int? = null

)
