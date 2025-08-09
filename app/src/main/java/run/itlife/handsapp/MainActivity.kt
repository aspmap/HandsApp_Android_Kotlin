package run.itlife.handsapp

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import run.itlife.handsapp.activities.RegisterActivity
import run.itlife.handsapp.databinding.ActivityMainBinding
import run.itlife.handsapp.models.User
import run.itlife.handsapp.ui.fragments.DialogsFragment
import run.itlife.handsapp.ui.objects.AppDrawer
import run.itlife.handsapp.utils.*

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        initFields()
        initFunc()
    }

    private fun initFunc() {
        if (AUTH.currentUser != null) {
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(DialogsFragment(), false)
        } else {
            replaceActivity(RegisterActivity())
        }

    }


    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
        initFirebase()
        initUser()
    }

    private fun initUser() {
        REF_DATABASE_ROOT.child(NODE_USERS).child(CURRENT_UID).addListenerForSingleValueEvent(
        AppValueEventListener {
            USER = it.getValue(User::class.java) ?:User()
        }
        )
    }
}