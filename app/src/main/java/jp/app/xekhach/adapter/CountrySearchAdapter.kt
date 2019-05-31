package jp.app.xekhach.adapter

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import jp.app.xekhach.R
import jp.app.xekhach.model.City

class CountrySearchAdapter(var listCity: ArrayList<City>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var isCountry: Boolean = true
    private lateinit var onClickItem: OnClickItem
    private lateinit var listCountry: ArrayList<City>
    fun setOnClickItem(onClickItem: OnClickItem) {
        this.onClickItem = onClickItem
    }

    fun setCountry(country: Boolean) {
        this.isCountry = country
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        if (isCountry) {
            val v = LayoutInflater.from(p0.context).inflate(R.layout.item_place_country, p0, false)
            return CountryViewHolder(v)
        } else {
//            v.setOnClickListener {
//                print("data")
//            }
            val v = LayoutInflater.from(p0.context).inflate(R.layout.item_place_district, p0, false)
            return DistrictViewHolder(v)
        }
    }

    override fun getItemCount(): Int {
        return listCity?.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        var city: City = listCity.get(p1)
        var cityHolder: RecyclerView.ViewHolder
        if (isCountry) {
            cityHolder = p0 as CountryViewHolder
            cityHolder.countryTxt?.text= city.thanhPho
            cityHolder.container?.setOnClickListener {
                print("p1")
                onClickItem!!.onClick(city)
            }
        } else {
            cityHolder = p0 as DistrictViewHolder
            cityHolder.districtTxt?.text= city.quan
        }
    }

    override fun getItemViewType(position: Int): Int {

        return super.getItemViewType(position)
    }

    fun setListCountry(listCity: ArrayList<City>) {
        this.listCity
    }

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var countryTxt: TextView? = null
        var container: ConstraintLayout? = null

        init {
            countryTxt = itemView.findViewById(R.id.country_name_txt)
            container = itemView.findViewById(R.id.container)
        }

        fun bindView(coutry: City) {
            this.countryTxt?.text = coutry.quan
        }
    }

    class DistrictViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var districtTxt: TextView? = null

        init {
            districtTxt = itemView.findViewById(R.id.district_txt)
        }

        fun bindView(coutry: City) {
            this.districtTxt?.text = coutry.quan
        }
    }

    interface OnClickItem {
        fun onClick(country: City)
    }
}