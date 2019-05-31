package jp.app.xekhach.utils

import android.app.Activity
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import jp.app.xekhach.R

class ToastCustom {
    fun showToastCustom(activity: Activity, @StringRes titleId: Int, @StringRes contentId: Int, @DrawableRes drawableId: Int): Toast {
        val inflater = activity.layoutInflater
        val layout = inflater.inflate(R.layout.toast_custom_dialog, null)

        val image = layout.findViewById(R.id.img) as ImageView
        Glide.with(activity)
            .load(drawableId)
            .into(image)
        val tvTitle = layout.findViewById(R.id.tvTitle) as TextView
        tvTitle.setText(titleId)
        val tvContent = layout.findViewById(R.id.tvContent) as TextView
        tvContent.setText(contentId)

        val toast = Toast(activity.applicationContext)
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
        return toast
    }
}