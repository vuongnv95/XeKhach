package jp.app.xekhach.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import jp.app.xekhach.R
import jp.app.xekhach.model.ItemTab

class TabFragmentAdapter(
    private var context: Context?,
    private var manager: FragmentManager?,
    private var listFragment: List<Fragment>
) :
    FragmentPagerAdapter(manager) {

    override fun getItem(p0: Int): Fragment {
        return listFragment.get(p0);
    }

    override fun getCount(): Int {
        return listFragment.size
    }

    fun getView(itemTab: ItemTab): View {
        var view: View = LayoutInflater.from(context).inflate(R.layout.tab_item, null)
        println("Vuong "+itemTab.nameTab)
        var imageTab: ImageView = view.findViewById(R.id.tab_item_img)
        var title: TextView = view.findViewById(R.id.tab_item_txt)
        imageTab.setImageResource(itemTab.imageTabUnselect)
        title.setText(itemTab.nameTab)
        return view
    }
}