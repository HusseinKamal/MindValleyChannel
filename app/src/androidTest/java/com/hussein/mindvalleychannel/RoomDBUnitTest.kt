package com.hussein.mindvalleychannel

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hussein.mindvalleychannel.database.AppDatabase
import com.hussein.mindvalleychannel.database.ChannelDao
import com.hussein.mindvalleychannel.model.category.Category
import com.hussein.mindvalleychannel.model.category.CategoryName
import com.hussein.mindvalleychannel.model.category.Data
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


/**
 * Example local unit test
 *
 * Unit test RoomDB
 */
@RunWith(AndroidJUnit4::class)
class RoomDBUnitTest {
    private lateinit var channelDao: ChannelDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
        channelDao = db.getShopDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertCategoryData() {
        val name=CategoryName("Hussein")
        val categories = ArrayList<CategoryName>()
        categories.add(name)
        val data=Data(categories)
        val categoryItem=Category(3,data)
        channelDao.insertCategoryRecord(categoryItem)
        val category = channelDao.getCategoryRecord(3)
        assertThat(category.data.categories[0].name, equalTo("Hussein"))
    }
    @Test
    @Throws(Exception::class)
    fun deleteCategoryData() {
        val name=CategoryName("Hussein")
        val categories = ArrayList<CategoryName>()
        categories.add(name)
        val data=Data(categories)
        val categoryItem=Category(3,data)
        channelDao.insertCategoryRecord(categoryItem)
        channelDao.deleteCategoryRecord(3)
        val categoryNewValue = channelDao.getCategoryRecord(3)
        assertThat(categoryNewValue,equalTo(null))
    }
}