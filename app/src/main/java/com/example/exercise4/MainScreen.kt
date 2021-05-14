package com.example.exercise4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.exercise4.fragment.*
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreen : AppCompatActivity(), Communicator {
    lateinit var listTag: ArrayList<String>
    var f: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        listTag = arrayListOf()
        imgHome.setBackgroundResource(R.drawable.cus_item_nav)
        replaceHomeFragment()
        homeFragment.setOnClickListener {
            replaceHomeFragment()

            imgHome.clearColorFilter()
            imgNews.clearColorFilter()
            imgCustomer.clearColorFilter()
            imgCoin.clearColorFilter()

            imgHome.setBackgroundResource(R.drawable.cus_item_nav)
            imgCoin.background = null
            imgNews.background = null
            imgCustomer.background = null
        }
        coinFragment.setOnClickListener {
            replaceCoinFragment()

            imgNews.clearColorFilter()
            imgCustomer.clearColorFilter()

            imgCoin.setColorFilter(resources.getColor(R.color.colorWhile))
            imgHome.setColorFilter(R.color.colorN)


            imgCoin.setBackgroundResource(R.drawable.cus_item_nav)
            imgHome.background = null
            imgCustomer.background = null
            imgNews.background = null
        }
        newsFragment.setOnClickListener {
            replaceNewsFragment()

            imgCustomer.clearColorFilter()
            imgCoin.clearColorFilter()

            imgNews.setColorFilter(resources.getColor(R.color.colorWhile))
            imgHome.setColorFilter(R.color.colorN)

            imgNews.setBackgroundResource(R.drawable.cus_item_nav)
            imgCoin.background = null
            imgCustomer.background = null
            imgHome.background = null
        }
        customerFragment.setOnClickListener {
            replaceCustomerFragment()

            imgNews.clearColorFilter()
            imgCoin.clearColorFilter()

            imgCustomer.setColorFilter(resources.getColor(R.color.colorWhile))
            imgHome.setColorFilter(R.color.colorN)

            imgCustomer.setBackgroundResource(R.drawable.cus_item_nav)
            imgCoin.background = null
            imgNews.background = null
            imgHome.background = null

        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 1) {
            f = supportFragmentManager.findFragmentById(R.id.container)
        }
        if (supportFragmentManager.backStackEntryCount == 0) {
            var al = AlertDialog.Builder(this)
            al.setTitle("Xác nhận!!")
            al.setMessage("Bạn có muốn thoát ứng dụng ??")
            al.setNegativeButton("Không") { dialogInterface, i ->
                when (f) {
                    is Home -> {
                        replaceHomeFragment()
                        imgHome.clearColorFilter()
                        imgNews.clearColorFilter()
                        imgCustomer.clearColorFilter()
                        imgCoin.clearColorFilter()

                        imgHome.setBackgroundResource(R.drawable.cus_item_nav)
                        imgCoin.background = null
                        imgNews.background = null
                        imgCustomer.background = null
                    }
                    is Coin -> {
                        replaceCoinFragment()

                        imgNews.clearColorFilter()
                        imgCustomer.clearColorFilter()

                        imgCoin.setColorFilter(resources.getColor(R.color.colorWhile))
                        imgHome.setColorFilter(R.color.colorN)


                        imgCoin.setBackgroundResource(R.drawable.cus_item_nav)
                        imgHome.background = null
                        imgCustomer.background = null
                        imgNews.background = null
                    }
                    is News -> {
                        replaceNewsFragment()

                        imgCustomer.clearColorFilter()
                        imgCoin.clearColorFilter()

                        imgNews.setColorFilter(resources.getColor(R.color.colorWhile))
                        imgHome.setColorFilter(R.color.colorN)

                        imgNews.setBackgroundResource(R.drawable.cus_item_nav)
                        imgCoin.background = null
                        imgCustomer.background = null
                        imgHome.background = null
                    }
                    else -> {
                        replaceCustomerFragment()

                        imgNews.clearColorFilter()
                        imgCoin.clearColorFilter()

                        imgCustomer.setColorFilter(resources.getColor(R.color.colorWhile))
                        imgHome.setColorFilter(R.color.colorN)

                        imgCustomer.setBackgroundResource(R.drawable.cus_item_nav)
                        imgCoin.background = null
                        imgNews.background = null
                        imgHome.background = null
                    }
                }
            }
            al.setPositiveButton("Có") { dialogInterface, i ->
                finish()
            }
            al.show()
        } else {
            when {
                supportFragmentManager.findFragmentById(R.id.container) is Coin -> {
                    imgNews.clearColorFilter()
                    imgCustomer.clearColorFilter()

                    imgCoin.setColorFilter(resources.getColor(R.color.colorWhile))
                    imgHome.setColorFilter(R.color.colorN)


                    imgCoin.setBackgroundResource(R.drawable.cus_item_nav)
                    imgHome.background = null
                    imgCustomer.background = null
                    imgNews.background = null
                }
                supportFragmentManager.findFragmentById(R.id.container) is News -> {
                    imgCustomer.clearColorFilter()
                    imgCoin.clearColorFilter()

                    imgNews.setColorFilter(resources.getColor(R.color.colorWhile))
                    imgHome.setColorFilter(R.color.colorN)

                    imgNews.setBackgroundResource(R.drawable.cus_item_nav)
                    imgCoin.background = null
                    imgCustomer.background = null
                    imgHome.background = null
                }
                supportFragmentManager.findFragmentById(R.id.container) is Customer -> {
                    imgNews.clearColorFilter()
                    imgCoin.clearColorFilter()

                    imgCustomer.setColorFilter(resources.getColor(R.color.colorWhile))
                    imgHome.setColorFilter(R.color.colorN)

                    imgCustomer.setBackgroundResource(R.drawable.cus_item_nav)
                    imgCoin.background = null
                    imgNews.background = null
                    imgHome.background = null
                }
                else -> {
                    imgHome.clearColorFilter()
                    imgNews.clearColorFilter()
                    imgCustomer.clearColorFilter()
                    imgCoin.clearColorFilter()

                    imgHome.setBackgroundResource(R.drawable.cus_item_nav)
                    imgCoin.background = null
                    imgNews.background = null
                    imgCustomer.background = null
                }
            }
        }

    }

    override fun sendData(title: String) {
        val bundle = Bundle()
        bundle.putString("title", title)
        val transaction = supportFragmentManager.beginTransaction()
        val newsArticle = NewsArticle()
        newsArticle.arguments = bundle
        transaction.replace(R.id.container, newsArticle)
        transaction.commit()
    }

    fun replaceHomeFragment() {
        val homeFragment = supportFragmentManager.findFragmentByTag("homeFragment")
        if (homeFragment == null) {
            val homeFragment = Home()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, homeFragment, "homeFragment")
                .addToBackStack("homeFragment")
                .commit()
        } else {
            for (i in 0 until supportFragmentManager.backStackEntryCount - 1) {
                if (supportFragmentManager.getBackStackEntryAt(i).name.equals(homeFragment.tag)) {
                    for (k in i + 1 until (supportFragmentManager.backStackEntryCount)) {
                        var tag = supportFragmentManager.getBackStackEntryAt(k).name
                        if (tag != null) {
                            listTag.add(tag)
                        }
                    }
                    supportFragmentManager.popBackStack(
                        supportFragmentManager.getBackStackEntryAt(i).id,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                    )

                    for (j in 0 until listTag.size) {
                        val str = listTag[j]
                        if (str.equals("coinFragment")) {
                            val coinFragment = Coin()
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.container, coinFragment, "coinFragment")
                                .addToBackStack("coinFragment")
                                .commit()
                        }
                        if (str.equals("newsFragment")) {
                            val newsFragment = News()
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.container, newsFragment, "newsFragment")
                                .addToBackStack("newsFragment")
                                .commit()
                        }
                        if (str.equals("customerFragment")) {
                            val customerFragment = Customer()
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.container, customerFragment, "customerFragment")
                                .addToBackStack("customerFragment")
                                .commit()
                        }
                    }
                    val homeFragment = Home()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, homeFragment, "homeFragment")
                        .addToBackStack("homeFragment")
                        .commit()
                    listTag.clear()
                }
            }
        }
    }

    fun replaceCoinFragment() {
        val coinFragment = supportFragmentManager.findFragmentByTag("coinFragment")
        if (coinFragment == null) {
            val coinFragment = Coin()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, coinFragment, "coinFragment")
                .addToBackStack("coinFragment")
                .commit()
        } else {
            for (i in 0 until supportFragmentManager.backStackEntryCount - 1) {
                if (supportFragmentManager.getBackStackEntryAt(i).name.equals(coinFragment.tag)) {
                    for (k in i + 1 until (supportFragmentManager.backStackEntryCount)) {
                        var tag = supportFragmentManager.getBackStackEntryAt(k).name
                        if (tag != null) {
                            listTag.add(tag)
                        }
                    }
                    supportFragmentManager.popBackStack(
                        supportFragmentManager.getBackStackEntryAt(i).id,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                    )

                    for (j in 0 until listTag.size) {
                        val str = listTag[j]
                        if (str.equals("homeFragment")) {
                            val homeFragment = Home()
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.container, homeFragment, "homeFragment")
                                .addToBackStack("homeFragment")
                                .commit()
                        }
                        if (str.equals("newsFragment")) {
                            val newsFragment = News()
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.container, newsFragment, "newsFragment")
                                .addToBackStack("newsFragment")
                                .commit()
                        }
                        if (str.equals("customerFragment")) {
                            val customerFragment = Customer()
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.container, customerFragment, "customerFragment")
                                .addToBackStack("customerFragment")
                                .commit()
                        }
                    }
                    val coinFragment = Coin()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, coinFragment, "coinFragment")
                        .addToBackStack("coinFragment")
                        .commit()
                    listTag.clear()
                }
            }
        }
    }

    fun replaceNewsFragment() {
        val newsFragment = supportFragmentManager.findFragmentByTag("newsFragment")
        if (newsFragment == null) {
            val newsFragment = News()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, newsFragment, "newsFragment")
                .addToBackStack("newsFragment")
                .commit()
        } else {
            for (i in 0 until supportFragmentManager.backStackEntryCount - 1) {
                if (supportFragmentManager.getBackStackEntryAt(i).name.equals(newsFragment.tag)) {
                    for (k in i + 1 until (supportFragmentManager.backStackEntryCount)) {
                        var tag = supportFragmentManager.getBackStackEntryAt(k).name
                        if (tag != null) {
                            listTag.add(tag)
                        }
                    }
                    supportFragmentManager.popBackStack(
                        supportFragmentManager.getBackStackEntryAt(i).id,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                    )

                    for (j in 0 until listTag.size) {
                        val str = listTag[j]
                        if (str.equals("coinFragment")) {
                            val coinFragment = Coin()
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.container, coinFragment, "coinFragment")
                                .addToBackStack("coinFragment")
                                .commit()
                        }
                        if (str.equals("homeFragment")) {
                            val homeFragment = Home()
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.container, homeFragment, "homeFragment")
                                .addToBackStack("homeFragment")
                                .commit()
                        }
                        if (str.equals("customerFragment")) {
                            val customerFragment = Customer()
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.container, customerFragment, "customerFragment")
                                .addToBackStack("customerFragment")
                                .commit()
                        }
                    }
                    val newsFragment = News()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, newsFragment, "newsFragment")
                        .addToBackStack("newsFragment")
                        .commit()
                    listTag.clear()
                }
            }
        }
    }

    fun replaceCustomerFragment() {
        val customerFragment = supportFragmentManager.findFragmentByTag("customerFragment")
        if (customerFragment == null) {
            val customerFragment = Customer()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, customerFragment, "customerFragment")
                .addToBackStack("customerFragment")
                .commit()
        } else {
            for (i in 0 until supportFragmentManager.backStackEntryCount - 1) {
                if (supportFragmentManager.getBackStackEntryAt(i).name.equals(customerFragment.tag)) {
                    for (k in i + 1 until (supportFragmentManager.backStackEntryCount)) {
                        var tag = supportFragmentManager.getBackStackEntryAt(k).name
                        if (tag != null) {
                            listTag.add(tag)
                        }
                    }
                    supportFragmentManager.popBackStack(
                        supportFragmentManager.getBackStackEntryAt(i).id,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                    )

                    for (j in 0 until listTag.size) {
                        val str = listTag[j]
                        if (str.equals("coinFragment")) {
                            val coinFragment = Coin()
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.container, coinFragment, "coinFragment")
                                .addToBackStack("coinFragment")
                                .commit()
                        }
                        if (str.equals("newsFragment")) {
                            val newsFragment = News()
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.container, newsFragment, "newsFragment")
                                .addToBackStack("newsFragment")
                                .commit()
                        }
                        if (str.equals("homeFragment")) {
                            val homeFragment = Home()
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.container, homeFragment, "homeFragment")
                                .addToBackStack("homeFragment")
                                .commit()
                        }
                    }
                    val customerFragment = Customer()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, customerFragment, "customerFragment")
                        .addToBackStack("customerFragment")
                        .commit()
                    listTag.clear()
                }
            }
        }
    }
}