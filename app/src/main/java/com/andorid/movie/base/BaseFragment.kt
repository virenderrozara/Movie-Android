package com.appster.commoncents.base


import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast

/**
 * Base Fragment of all Fragment
 */
abstract class BaseFragment : Fragment(), View.OnClickListener {
//    abstract fun initializeData()
//    abstract fun setListener()
    private  var mDialog: Dialog?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mDialog = Dialog(activity!!, R.style.transDialog)
//        mDialog?.setContentView(R.layout.view_progress_dialog)


    }

    fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
    /**
     * hide keyboard forcefully
     * @param view the view
     */
    fun hideSoftKeyboard(view: View) {
        view.setOnTouchListener { view, motionEvent ->
            if (view !is EditText) {
                assert(activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) != null)
                (activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(view.windowToken, 0)
            }
            false
        }
    }

    fun showKeyboard() {
        (activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }
    fun showProgress() {
        mDialog?.show()
    }

    fun hideProgress() {
        //mDialog.hide()
        mDialog?.dismiss()
    }
    fun isDialogShowing():Boolean {
       return mDialog?.isShowing!!
    }
}