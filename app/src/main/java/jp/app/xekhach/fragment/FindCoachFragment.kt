package jp.app.xekhach.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.app.xekhach.R
import jp.app.xekhach.base.BaseFragment
import jp.app.xekhach.utils.TimeUtils
import kotlinx.android.synthetic.main.fragment_find_coach.*
import kotlinx.android.synthetic.main.layout_header.*
import java.text.SimpleDateFormat
import java.util.*

class FindCoachFragment : BaseFragment(), View.OnClickListener, TimeUtils.DateResponse {
    override fun responseTime(time: String) {
        time_start_txt.text = time
    }

    override fun responseDate(time: String) {
        date_start_txt.text = time
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.dia_diem_di_rl -> {
                screenNavi?.add(PlaceStartFragment(), true)
//                activity!!.supportFragmentManager.beginTransaction().replace(R.id.main_menu_fr, PlaceStartFragment(), "").commit()
//                childFragmentManager.beginTransaction().replace(R.id.main_menu_fr, PlaceStartFragment(), "").commit()
            }
            R.id.dia_diem_den_rl -> {
                screenNavi?.add(PlaceStartFragment(), true)
            }
            R.id.ngay_di_rl -> {
                activity?.let { TimeUtils.showDatePicker(it, this) }
            }
            R.id.gio_di_rl -> {
                activity?.let { TimeUtils.showTimePicker(it, this) }
            }
            R.id.tim_xe_btn -> {

            }
            R.id.date_now_txt -> {
                var calander :Calendar = Calendar.getInstance()
                var date:String = SimpleDateFormat("dd/MM/yyyy").format(calander.time)
                var time:String = SimpleDateFormat("HH:mm").format(calander.time)
                date_start_txt.text = date
                time_start_txt.text = time
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_find_coach, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnclick()

    }

    private fun setOnclick() {
        dia_diem_di_rl.setOnClickListener(this)
        dia_diem_den_rl.setOnClickListener(this)
        ngay_di_rl.setOnClickListener(this)
        gio_di_rl.setOnClickListener(this)
        tim_xe_btn.setOnClickListener(this)
        date_now_txt.setOnClickListener(this)
        back_img.visibility = View.GONE
        title_txt.setText(resources.getString(R.string.tim_xe))
    }
}