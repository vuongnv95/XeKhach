package jp.app.xekhach.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager
import jp.app.xekhach.navi.ScreenNavi

open class BaseFragment : Fragment() {
     var screenNavi: ScreenNavi? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        var screenNavi: ScreenNavi = activity?.let { ScreenNavi(it) }!!
        screenNavi = activity?.let { ScreenNavi(it) }
    }

    override fun onPause() {
        super.onPause()
        hideKeyBoard()
    }
    override fun onDestroy() {
        super.onDestroy()

    }

    protected fun hideKeyBoard() {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(activity?.window?.decorView?.windowToken, 0)
    }
}