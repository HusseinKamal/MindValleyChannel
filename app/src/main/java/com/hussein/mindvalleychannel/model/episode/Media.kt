package com.hussein.mindvalleychannel.model.episode

import com.hussein.mindvalleychannel.model.channel.CoverAsset

data class Media(
    var channel: Channel,
    var coverAsset: CoverAsset,
    var title: String,
    var type: String
)