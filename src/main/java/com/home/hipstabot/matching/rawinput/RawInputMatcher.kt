package com.home.hipstabot.matching.rawinput

import com.home.hipstabot.matching.Matcher
import com.home.hipstabot.matching.Media
import org.springframework.stereotype.Service

@Service
class RawInputMatcher: Matcher {
    override fun getMedia(query: String): Media? {
        val parts = query.split("-")
        val media = Media()
        try {
            media.artist = parts[0]
            media.title = parts[1]
            media.link = ""
            media.type = Media.ServiceType.NO_SERVICE
            media.album = ""
            return media
        } catch (e : Exception) {
            return null
        }
    }

    override fun getMedia(media: Media): Media? {
        return null
    }

    override fun service(): Media.ServiceType {
        return Media.ServiceType.NO_SERVICE
    }

    override fun matchesUri(uri: String): Boolean {
        return !(uri.contains("itunes.apple.com") ||
                uri.contains("music.google.com") ||
                uri.contains("music.yandex.ru"))
    }
}