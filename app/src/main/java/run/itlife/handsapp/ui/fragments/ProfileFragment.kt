package run.itlife.handsapp.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kotlinx.android.synthetic.main.fragment_profile.*
import run.itlife.handsapp.R
import run.itlife.handsapp.activities.RegisterActivity
import run.itlife.handsapp.utils.*

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        initFields()
    }

    private fun initFields() {
        settings_bio.text = USER.bio
        settings_full_name.text = USER.fullname
        settings_phone_number.text = USER.phone
        settings_status.text = USER.status
        settings_username.text = USER.username
        settings_btn_change_username.setOnClickListener { replaceFragment(ChangeUsernameFragment()) }
        settings_btn_change_bio.setOnClickListener { replaceFragment(ChangeBioFragment()) }
        //settings_change_photo.setOnClickListener { changePhotoUser() }
        settings_change_photo.setOnClickListener { showToast(getString(R.string.info_photo_profile)) }
    }

/*    private fun changePhotoUser() {
        CropImage.activity()
            .setAceptRatio(1, 1)
            .setRequestedSize(600, 600)
            .setCropShape(CropImageView.CropShape.OVAL)
            .start(APP_ACTIVITY)
    }*/

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {  // TODO В основном меню тоже сделать выход
            R.id.settings_menu_change_exit -> {
                AUTH.signOut()
                APP_ACTIVITY.replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())
        }
        return true
    }
}