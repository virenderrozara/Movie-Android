package com.android.movie.base


import GeneralConstant.DEFAULT
import GeneralConstant.FADE
import GeneralConstant.NONE
import GeneralConstant.SLIDE
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
//import android.support.v4.app.Fragment
//import android.support.v4.app.FragmentTransaction
//import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import com.android.movie.data.LogUtils
import com.appster.commoncents.utils.NetworkUtils

/**
 * Parent class of All activity in project
 */
abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mDialog: Dialog
    private var tAG = LogUtils.makeLogTag(BaseActivity::class.java.simpleName)
    fun isNetworkConnected(): Boolean {
        return NetworkUtils.isNetworkConnected(applicationContext)
    }

    abstract fun openFragment(fragment: Fragment, bundle: Bundle?)
//    abstract fun setSeekbar(progress: Int)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mDialog = Dialog(this, R.style.transDialog)
//        mDialog.setContentView(R.layout.view_progress_dialog)


    }

    /**
     * to push fragment in Activity
     * @param fragment the fragment
     * @param args the bundle
     * @param addToBackStack the addToBackStack or not
     * @param shouldAdd the add or replace
     */
//    fun pushFragment(fragment: Fragment, args: Bundle?, containerViewId: Int, addToBackStack: Boolean, shouldAdd: Boolean) {
//        try {
//            if (fragment == null) return
//            if (args != null)
//                fragment.arguments = args
//
//            val ft = supportFragmentManager.beginTransaction()
//            setAnimation(shouldAdd, addToBackStack, GeneralConstant.NONE, fragment, ft)
//        } catch (ex: Exception) {
//            LogUtils.lOGE(tAG, ex.toString())
//        }
//
//    }

    fun popFragment() {
        supportFragmentManager.popBackStack()


    }

    /**
     * Shows a [Snackbar].
     *
     * @param mainTextStringId The id for the string resource for the Snackbar text.
     * @param actionStringId   The text of the action item.
     * @param listener         The listener associated with the Snackbar action.
     */
    fun showSnackbar(mainTextStringId: Int, actionStringId: Int,
                     listener: View.OnClickListener) {
        Snackbar.make(
                findViewById(android.R.id.content),
                getString(mainTextStringId),
                Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(actionStringId), listener).show()
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showProgress() {
        mDialog.show()
    }

    fun hideProgress() {
        mDialog.hide()
    }

    /**
     * Set animation for adding or replacing Fragment
     * @param shouldAdd  true to add otherwise false
     * @param addToBackStack  add to backstack or not
     * @param animationType  the animation type
     * @param fragment  the fragment
     * @param transaction the transaction
     */
//    private fun setAnimation(shouldAdd: Boolean, addToBackStack: Boolean, animationType: Int, fragment: Fragment, transaction: FragmentTransaction) {
//        when (animationType) {
//            DEFAULT, SLIDE -> transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
//            FADE -> transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
//            /*ZOOM -> transaction.setCustomAnimations(R.anim.zoomin, R.anim.fadein)*/
//            NONE -> {
//            }
//            else -> {
//            }
//        }
//        if (shouldAdd)
//            transaction.add(R.id.container, fragment, fragment.javaClass.simpleName)
//        else
//            transaction.replace(R.id.container, fragment, fragment.javaClass.simpleName)
//        if (addToBackStack)
//            transaction.addToBackStack(fragment.javaClass.simpleName)
//
//
//        transaction.commitAllowingStateLoss()
//    }



}