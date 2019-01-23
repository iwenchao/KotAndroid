package com.iwenchaos.kotandroid.ui.main.activity

import android.content.Intent
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.iwenchaos.kotandroid.R
import com.iwenchaos.kotandroid.base.BaseActivity
import com.iwenchaos.kotandroid.base.BaseApplication
import com.iwenchaos.kotandroid.common.Constants
import com.iwenchaos.kotandroid.ui.main.mvp.MainContract
import com.iwenchaos.kotandroid.ui.main.mvp.MainPresenter
import com.iwenchaos.kotandroid.util.SnackUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

/**
 * Created by chaos
 * on 2019/1/14. 15:35
 * 文件描述：
 */
class MainActivity : BaseActivity<MainPresenter>(), MainContract.View, NavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {


    private var lastClickTime: Long = 0;

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initialize() {
        setupDrawerAndToolbar()
        mPresenter.onAttach(this)

    }

    private fun setupDrawerAndToolbar() {
        setSupportActionBar(toolbar)
        toolbar.post {
            toolbar.title = getString(R.string.text_home)
        }
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navView.setNavigationItemSelectedListener(this)
        bottomNavView.setOnNavigationItemSelectedListener(this)
        navView.setCheckedItem(R.id.nav_home)
    }


    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            //底部tab
            R.id.action_home, R.id.nav_home -> navigateToPage(0)
            R.id.action_knowledge -> navigateToPage(1)
            R.id.action_navigation -> navigateToPage(2)
            R.id.action_project -> navigateToPage(3)
            //其他menu...
            R.id.nav_public_account -> startActivity(Intent(this, MainActivity::class.java))//公众号
            R.id.nav_collection -> mPresenter.checkCollectionState()
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true


    }

    private fun navigateToPage(index: Int) {
        val currentIndex = viewPager.currentItem
        if (currentIndex == index) return
        viewPager.setCurrentItem(index, true)
    }


    override fun onBackPressed() {
        when {
            drawerLayout.isDrawerOpen(GravityCompat.START) -> drawerLayout.closeDrawer(GravityCompat.START)
            else -> quitApp()
        }
    }

    private fun quitApp() {
        if ((System.currentTimeMillis() - lastClickTime) > Constants.APP_QUIT_TIME) {
            lastClickTime = System.currentTimeMillis()
            SnackUtil.showNormalToast(this, getString(R.string.click_again_quit))
        } else {
            BaseApplication.INSTANCE.quitApp()
        }
    }

}