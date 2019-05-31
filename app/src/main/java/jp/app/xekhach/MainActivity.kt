package jp.app.xekhach

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import jp.app.xekhach.fragment.MenuFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.main_menu_fr, MenuFragment.newInstance(), "").commit()
    }
}
