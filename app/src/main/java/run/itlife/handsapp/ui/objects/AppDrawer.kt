package run.itlife.handsapp.ui.objects

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import run.itlife.handsapp.R
import run.itlife.handsapp.ui.fragments.ProfileFragment
import run.itlife.handsapp.utils.replaceFragment

class AppDrawer (val mainActivity: AppCompatActivity, val toolbar: Toolbar) {
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader
    private lateinit var mDrawerLayout: DrawerLayout

    fun create() {
        createHeader()
        createDrawer()
        mDrawerLayout = mDrawer.drawerLayout
    }

    fun disableDrawer() {
        mDrawer.actionBarDrawerToggle?.isDrawerIndicatorEnabled = false
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        toolbar.setNavigationOnClickListener {
            mainActivity.supportFragmentManager.popBackStack()
        }
    }

    fun enableDrawer() {
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        mDrawer.actionBarDrawerToggle?.isDrawerIndicatorEnabled = true
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        toolbar.setNavigationOnClickListener {
            mDrawer.openDrawer()
        }
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(mainActivity)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(
                /*PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("Моя лента")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_channel),
                PrimaryDrawerItem().withIdentifier(110)
                    .withIconTintingEnabled(true)
                    .withName("Создать пост")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_invate),
                PrimaryDrawerItem().withIdentifier(120)
                    .withIconTintingEnabled(true)
                    .withName("Моя страница")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_contacts),*/
                PrimaryDrawerItem().withIdentifier(130)
                    .withIconTintingEnabled(true)
                    .withName("Мой профиль")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_settings),
                /*PrimaryDrawerItem().withIdentifier(140)
                    .withIconTintingEnabled(true)
                    .withName("Мои лайки")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_favorites),
                PrimaryDrawerItem().withIdentifier(150)
                    .withIconTintingEnabled(true)
                    .withName("Мои диалоги")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_channel),
                PrimaryDrawerItem().withIdentifier(160)
                    .withIconTintingEnabled(true)
                    .withName("Мой вишлист")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_favorites),
                PrimaryDrawerItem().withIdentifier(170)
                    .withIconTintingEnabled(true)
                    .withName("Мой QR-код")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_secret_chat),*/
                DividerDrawerItem(),
                PrimaryDrawerItem().withIdentifier(180)
                    .withIconTintingEnabled(true)
                    .withName("Выход")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_header_night)
            ).withOnDrawerItemClickListener(object: Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when(position) {
                        1 -> mainActivity.replaceFragment(ProfileFragment())
                    }
                    return false
                }
            }).build()
    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
            .withActivity(mainActivity)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName("Павлов Александр")
                    .withEmail("aspmap@yandex.ru")
            ).build()
    }
}