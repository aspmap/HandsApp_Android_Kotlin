package run.itlife.handsapp.ui.objects

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import run.itlife.handsapp.R
import run.itlife.handsapp.ui.fragments.ContactsFragment
import run.itlife.handsapp.ui.fragments.ProfileFragment
import run.itlife.handsapp.utils.APP_ACTIVITY
import run.itlife.handsapp.utils.USER
import run.itlife.handsapp.utils.replaceFragment

class AppDrawer {
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var mCurrentProfile: ProfileDrawerItem

    fun create() {
        //initLoader()
        createHeader()
        createDrawer()
        mDrawerLayout = mDrawer.drawerLayout
    }

    fun disableDrawer() {
        mDrawer.actionBarDrawerToggle?.isDrawerIndicatorEnabled = false
        APP_ACTIVITY.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        APP_ACTIVITY.mToolbar.setNavigationOnClickListener {
            APP_ACTIVITY.supportFragmentManager.popBackStack()
        }
    }

    fun enableDrawer() {
        APP_ACTIVITY.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        mDrawer.actionBarDrawerToggle?.isDrawerIndicatorEnabled = true
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        APP_ACTIVITY.mToolbar.setNavigationOnClickListener {
            mDrawer.openDrawer()
        }
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(APP_ACTIVITY)
            .withToolbar(APP_ACTIVITY.mToolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("Мои контакты")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_contacts),
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
                    .withIcon(R.drawable.ic_menu_settings)
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
                /*DividerDrawerItem(),
                PrimaryDrawerItem().withIdentifier(180)
                    .withIconTintingEnabled(true)
                    .withName("Выход")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_btn_action_menu_exit)*/
            ).withOnDrawerItemClickListener(object: Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    clickToItem(position)
                    return false
                }
            }).build()
    }

    private fun clickToItem(position: Int) {
        when(position) {
            1 -> APP_ACTIVITY.replaceFragment(ContactsFragment())
            2 -> APP_ACTIVITY.replaceFragment(ProfileFragment())
        }
    }

    private fun createHeader() {
        mCurrentProfile = ProfileDrawerItem()
            .withName(USER.fullname)
            .withEmail(USER.phone)
            //.withIcon(USER.photoUrl)
            .withIdentifier(200)
        mHeader = AccountHeaderBuilder()
            .withActivity(APP_ACTIVITY)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                mCurrentProfile
            ).build()
    }

    fun updateHeader() {
        mCurrentProfile
            .withName(USER.fullname)
            .withEmail(USER.phone)
            //.withIcon(USER.photoUrl)
        mHeader.updateProfile(mCurrentProfile)
    }

/*    private fun initLoader() {
        DrawerImageLoader.init(object : AbstractDrawerImageLoader() {
            override fun set(imageView: ImageView, uri: Uri, placeholder: Drawable) {
                imageView.downloadAndSetImage(uri.toString())
            }
        })
    }*/
}