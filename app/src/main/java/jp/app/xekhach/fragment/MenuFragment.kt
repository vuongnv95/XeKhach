package jp.app.xekhach.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import jp.app.xekhach.R
import jp.app.xekhach.adapter.TabFragmentAdapter
import jp.app.xekhach.base.BaseFragment
import jp.app.xekhach.model.ItemTab

class MenuFragment : BaseFragment(), TabLayout.BaseOnTabSelectedListener<TabLayout.Tab> {
    override fun onTabReselected(p0: TabLayout.Tab?) {
    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {
        var view: View? = p0?.customView
        var imageTab: ImageView? = view?.findViewById(R.id.tab_item_img)
        var title: TextView? = view?.findViewById(R.id.tab_item_txt)
        var possition = p0?.position
        var tabItemTab: ItemTab = possition?.let { listTab.get(it) }!!
        imageTab?.setImageResource(tabItemTab.imageTabUnselect)
        context?.resources?.getColor(R.color.gray)?.let { title?.setTextColor(it) }
    }

    override fun onTabSelected(p0: TabLayout.Tab?) {
        var view: View? = p0?.customView
        var imageTab: ImageView? = view?.findViewById(R.id.tab_item_img)
        var title: TextView? = view?.findViewById(R.id.tab_item_txt)
        var possition = p0?.position
        var tabItemTab: ItemTab = possition?.let { listTab.get(it) }!!
        imageTab?.setImageResource(tabItemTab.imageTab)
        context?.resources?.getColor(R.color.white)?.let { title?.setTextColor(it) }

    }

    private lateinit var viewPager: ViewPager;
    private lateinit var tabLayout: TabLayout;
    private lateinit var listFragment: ArrayList<Fragment>
    private lateinit var listTab: ArrayList<ItemTab>
    private lateinit var listImageTab: ArrayList<Int>
    private lateinit var mTabFragmentAdapter: TabFragmentAdapter

    companion object {
        fun newInstance(): MenuFragment {
            val fragment = MenuFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData();
        initViews(view)
        setViewData()
        setOnclickViews();
    }

    private fun initData() {
        listFragment = ArrayList()
        listTab = ArrayList()
        listImageTab = ArrayList()
        listFragment.add(FindCoachFragment())
        listFragment.add(FindCoachFragment())
        listFragment.add(FindCoachFragment())
        listFragment.add(FindCoachFragment())
        mTabFragmentAdapter = TabFragmentAdapter(context, activity?.supportFragmentManager, listFragment)
    }

    private fun initViews(view: View) {
        viewPager = view.findViewById(R.id.viewpager)
        tabLayout = view.findViewById(R.id.tab_layout)
    }

    private fun setViewData() {
        listTab.add(
            ItemTab(
                resources.getString(R.string.find_coach),
                R.mipmap.ic_search,
                R.mipmap.ic_search_disable
            )
        )
        listTab.add(
            ItemTab(
                resources.getString(R.string.wait_coach),
                R.mipmap.ic_coach,
                R.mipmap.ic_coach_disable
            )
        )
        listTab.add(
            ItemTab(
                resources.getString(R.string.history_coach),
                R.mipmap.ic_history,
                R.mipmap.ic_history_disable
            )
        )
        listTab.add(
            ItemTab(
                resources.getString(R.string.info_coach),
                R.mipmap.ic_info,
                R.mipmap.ic_info_disable
            )
        )
        listImageTab.add(R.mipmap.ic_search_disable)
        tabLayout.setupWithViewPager(viewPager)
        viewPager.adapter = mTabFragmentAdapter
        for (i in 0..listTab.size - 1) {
            var view: View = mTabFragmentAdapter.getView(listTab.get(i))
            tabLayout.getTabAt(i)?.customView = view
        }
    }

    private fun setOnclickViews() {
        tabLayout.addOnTabSelectedListener(this)
        tabLayout.selectedTabPosition
    }

}