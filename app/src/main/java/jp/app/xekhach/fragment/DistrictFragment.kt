package jp.app.xekhach.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.app.xekhach.R
import jp.app.xekhach.adapter.CountrySearchAdapter
import jp.app.xekhach.base.BaseFragment
import jp.app.xekhach.model.City
import kotlinx.android.synthetic.main.fragment_place_country_start.*
import kotlinx.android.synthetic.main.layout_header.*

class DistrictFragment : BaseFragment(), CountrySearchAdapter.OnClickItem, View.OnClickListener,
    SearchView.OnQueryTextListener {
    private var IS_FILTERING: Boolean = false
    private lateinit var listCitySearch: ArrayList<City>
    override fun onQueryTextChange(p0: String?): Boolean {
        if (IS_FILTERING) {
            return true
        }
        filter(this.listCity, p0)
        return true
    }

    fun filter(listCity: ArrayList<City>, query: String?) {
        IS_FILTERING = true
        var queryData = query?.toLowerCase()
        listCitySearch.clear()
        var size: Int = listCity.size - 1
        var item: Int
        for (item in 0..size) {
            var name = listCity.get(item).quan
            name = name.toLowerCase()
            if (name.contains(queryData!!)) {
                listCitySearch.add(listCity.get(item))
            }
        }
        if (listCitySearch.size == 0) {
            no_item_txt.visibility = View.VISIBLE
        } else {
            countrySearchAdapter.notifyDataSetChanged()
            no_item_txt.visibility = View.GONE
        }
        IS_FILTERING = false
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.back_img -> screenNavi?.popBackStack()
            R.id.search_edt -> search_edt.setIconified(false)
        }
    }

    private lateinit var countrySearchAdapter: CountrySearchAdapter
    override fun onClick(city: City) {

    }

    lateinit var listCity: ArrayList<City>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_place_district_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initViews(view)
        initOnclick()
    }

    private fun initViews(view: View) {
        search_edt.queryHint = getString(R.string.nha_ten_quan)
        search_edt.setOnClickListener(this)
        search_edt.setOnQueryTextListener(this)
        countrySearchAdapter = CountrySearchAdapter(listCitySearch)
        countrySearchAdapter.setOnClickItem(this)
        countrySearchAdapter.setCountry(false)
        country_search_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        country_search_rv.adapter = countrySearchAdapter
    }

    private fun initOnclick() {
    }

    private fun initData() {
        listCitySearch = ArrayList<City>()
        listCity = ArrayList<City>()
        listCity.add(City("Hà Nội", "Cầu giấy"))
        listCity.add(City("Nam Định", "Hà Đông"))
        listCity.add(City("Hải Phòng", "Ba Đình"))
        listCity.add(City("Bắc Ninh", "Hà Tây"))
        listCity.add(City("Thái Bình", "Nam Thăng Long"))
        listCity.add(City("Ninh Bình", "Nam Từ Liêm"))
        listCitySearch.addAll(listCity)
    }
}