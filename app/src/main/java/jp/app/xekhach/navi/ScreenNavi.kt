package jp.app.xekhach.navi

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransaction
import jp.app.xekhach.R

class ScreenNavi(var activity: FragmentActivity) {
    public fun replace(
        fragment: Fragment,
        isAddToStack: Boolean
    ) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.run {
            setAnimation(this, StyleAnimation.SLIDE_FROM_RIGHT)
            replace(R.id.main_menu_fr, fragment, fragment::class.java.simpleName)
            if (isAddToStack)
                addToBackStack(null)
            commit()
        }
    }

    public fun add(
        fragment: Fragment,
        isAddToStack: Boolean
    ) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.run {
            setAnimation(this, StyleAnimation.SLIDE_FROM_RIGHT)
            add(R.id.main_menu_fr, fragment, fragment::class.java.simpleName)
            if (isAddToStack)
                addToBackStack(null)
            commit()
        }
    }

    public fun popBackStack() {
        val transaction = activity.supportFragmentManager
        transaction.run {
            popBackStack()
        }
    }

    private fun setAnimation(transaction: FragmentTransaction, styleAnimation: StyleAnimation) {
        when (styleAnimation) {
            StyleAnimation.SLIDE_FROM_RIGHT -> transaction.setCustomAnimations(
                R.anim.slide_in_from_right,
                R.anim.slide_out_to_left,
                R.anim.slide_in_from_left,
                R.anim.slide_out_to_right
            )
            StyleAnimation.SLIDE_FROM_LEFT -> transaction.setCustomAnimations(
                R.anim.slide_in_from_left,
                R.anim.stack_pop,
                R.anim.stack_push,
                R.anim.slide_out_to_left
            )
            StyleAnimation.SLIDE_FROM_BOTTOM -> transaction.setCustomAnimations(
                R.anim.slide_in_bottom,
                R.anim.stack_push,
                R.anim.stack_pop,
                R.anim.slide_out_bottom
            )
            else -> {
            }
        }
    }

    enum class StyleAnimation {
        SLIDE_FROM_RIGHT, SLIDE_FROM_LEFT, SLIDE_FROM_BOTTOM, SLIDE_NONE
    }
}