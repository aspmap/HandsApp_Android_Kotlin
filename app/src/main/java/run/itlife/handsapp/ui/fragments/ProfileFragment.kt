package run.itlife.handsapp.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import run.itlife.handsapp.MainActivity
import run.itlife.handsapp.R
import run.itlife.handsapp.activities.RegisterActivity
import run.itlife.handsapp.utils.AUTH
import run.itlife.handsapp.utils.replaceActivity

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.settings_menu_change_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
        }
        return true
    }
}