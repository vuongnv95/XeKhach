package jp.app.xekhach.fragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransaction
import jp.app.xekhach.R


class ScreenNaviExt {
    enum class StyleAnimation {
        SLIDE_FROM_RIGHT, SLIDE_FROM_LEFT, SLIDE_FROM_BOTTOM, SLIDE_NONE
    }

    fun FragmentActivity.replace(
        fragment: Fragment,
        holder: Int = R.id.main_menu_fr,
        isAddToStack: Boolean = true,
        animation: StyleAnimation = StyleAnimation.SLIDE_FROM_RIGHT
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.run {
            setAnimation(this, animation)
            replace(holder, fragment, fragment::class.java.simpleName)
            if (isAddToStack)
                addToBackStack(null)
            commit()
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
}