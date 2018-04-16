package net.terzeron.a18masterdetailflowtest.dummy

import net.terzeron.a18masterdetailflowtest.R.id.content
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private val COUNT = 25

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }
    init {
        addItem(DummyItem("1", "google", "https://google.com"))
        addItem(DummyItem("2", "naver", "http://naver.com"))
        addItem(DummyItem("3", "terzeron", "https://terzeron.net"))
    }


    /**
     * A dummy item representing a piece of content.
     */
    data class DummyItem(val id: String, val website_name: String, val website_url: String) {
        override fun toString(): String = website_name
    }
}
