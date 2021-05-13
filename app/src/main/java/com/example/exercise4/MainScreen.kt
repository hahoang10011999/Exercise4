package com.example.exercise4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager
import com.example.exercise4.fragment.*
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreen : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        imgHome.setBackgroundResource(R.drawable.cus_item_nav)
        val home = Home()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, home)
            .addToBackStack(null)
            .commit()
        homeFragment.setOnClickListener {
            val home = Home()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, home)
                .addToBackStack(null)
                .commit()
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
            val coin = Coin()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, coin)
                .addToBackStack(null)
                .commit()
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
            val new = News()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, new)
                .addToBackStack(null)
                .commit()
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
            val home = Customer()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, home)
                .addToBackStack(null)
                .commit()
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
        if (supportFragmentManager.backStackEntryCount == 0) {
            var al = AlertDialog.Builder(this)
            al.setTitle("Xác nhận!!")
            al.setMessage("Bạn có muốn thoát ứng dụng ??")
            al.setNegativeButton("Không") { dialogInterface, i ->
                val home = Home()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, home)
                    .addToBackStack(null)
                    .commit()
                imgHome.clearColorFilter()
                imgNews.clearColorFilter()
                imgCustomer.clearColorFilter()
                imgCoin.clearColorFilter()

                imgHome.setBackgroundResource(R.drawable.cus_item_nav)
                imgCoin.background = null
                imgNews.background = null
                imgCustomer.background = null
            }
            al.setPositiveButton("Có") { dialogInterface, i ->
                finish()
            }
            al.show()
        }
        if (supportFragmentManager.findFragmentById(R.id.container) is Coin) {
            imgNews.clearColorFilter()
            imgCustomer.clearColorFilter()

            imgCoin.setColorFilter(resources.getColor(R.color.colorWhile))
            imgHome.setColorFilter(R.color.colorN)


            imgCoin.setBackgroundResource(R.drawable.cus_item_nav)
            imgHome.background = null
            imgCustomer.background = null
            imgNews.background = null
        } else if (supportFragmentManager.findFragmentById(R.id.container) is News) {
            imgCustomer.clearColorFilter()
            imgCoin.clearColorFilter()

            imgNews.setColorFilter(resources.getColor(R.color.colorWhile))
            imgHome.setColorFilter(R.color.colorN)

            imgNews.setBackgroundResource(R.drawable.cus_item_nav)
            imgCoin.background = null
            imgCustomer.background = null
            imgHome.background = null
        } else if (supportFragmentManager.findFragmentById(R.id.container) is Customer) {
            imgNews.clearColorFilter()
            imgCoin.clearColorFilter()

            imgCustomer.setColorFilter(resources.getColor(R.color.colorWhile))
            imgHome.setColorFilter(R.color.colorN)

            imgCustomer.setBackgroundResource(R.drawable.cus_item_nav)
            imgCoin.background = null
            imgNews.background = null
            imgHome.background = null
        } else {
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

    override fun sendData(title: String) {
        val bundle = Bundle()
        bundle.putString("title", title)
        val transaction = supportFragmentManager.beginTransaction()
        val newsArticle = NewsArticle()
        newsArticle.arguments = bundle
        transaction.replace(R.id.container, newsArticle)
        transaction.commit()
    }


}