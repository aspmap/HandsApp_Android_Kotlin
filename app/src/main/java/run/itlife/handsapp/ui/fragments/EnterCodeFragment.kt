package run.itlife.handsapp.ui.fragments

import android.text.Editable
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_enter_code.*
import run.itlife.handsapp.R
import run.itlife.handsapp.utils.AppTextWatcher
import run.itlife.handsapp.utils.showToast

class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {

    override fun onStart() {
        super.onStart()
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_input_code.text.toString()
            if (string.length == 6) {
                verificationCode()
            }
        })
    }

    private fun verificationCode() {
        showToast("OK")
    }

}