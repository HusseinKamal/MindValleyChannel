package com.hussein.mindvalleychannel.model.channel

data class ChannelItem(
    var coverAsset: CoverAsset,
    var iconAsset: IconAsset,
    var id: String,
    var latestMedia: List<LatestMedia> = ArrayList(),
    var mediaCount: Int,
    var series: List<Sery> = ArrayList(),
    var slug: String,
    var title: String
)
{
    val valueIconAsset = iconAsset
        get(): IconAsset {
            return if (field == null) IconAsset("","") else field
        }
    val valueCoverAsset = coverAsset
        get(): CoverAsset {
            return if (field == null) CoverAsset("") else field
        }
}