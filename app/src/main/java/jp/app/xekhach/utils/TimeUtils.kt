package jp.app.xekhach.utils

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import java.text.SimpleDateFormat
import java.util.*

class TimeUtils {
    companion object {
        fun showDatePicker(activity: Activity, dateResponse: DateResponse) {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd =
                DatePickerDialog(activity, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    print("year:" + year + "month:" + monthOfYear + "date:" + dayOfMonth)
                    val cal = Calendar.getInstance()
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, monthOfYear)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    var time: String = SimpleDateFormat("dd/MM/yyyy").format(cal.time)
                    dateResponse.responseDate(time)
                }, year, month, day)

            dpd.show()
        }

        fun showTimePicker(activity: Activity, dateResponse: DateResponse) {
            val cal = Calendar.getInstance()

            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)

                dateResponse.responseTime(SimpleDateFormat("HH:mm").format(cal.time))
            }
            TimePickerDialog(
                activity,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }
    }

    interface DateResponse {
        fun responseDate(time: String);
        fun responseTime(time: String);
    }
}