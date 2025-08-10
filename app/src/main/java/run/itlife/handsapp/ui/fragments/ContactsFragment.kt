package run.itlife.handsapp.ui.fragments

import run.itlife.handsapp.R
import run.itlife.handsapp.utils.APP_ACTIVITY

class ContactsFragment : BaseFragment(R.layout.fragment_contacts) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Контакты"
    }

}