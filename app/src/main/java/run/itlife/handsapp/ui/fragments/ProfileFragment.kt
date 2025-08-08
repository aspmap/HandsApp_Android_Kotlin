package run.itlife.handsapp.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import run.itlife.handsapp.MainActivity
import run.itlife.handsapp.R
import run.itlife.handsapp.activities.RegisterActivity
import run.itlife.handsapp.utils.AUTH
import run.itlife.handsapp.utils.replaceActivity
import run.itlife.handsapp.utils.replaceFragment

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {  // TODO В основном меню тоже сделать выход
            R.id.settings_menu_change_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())
        }
        return true
    }
}