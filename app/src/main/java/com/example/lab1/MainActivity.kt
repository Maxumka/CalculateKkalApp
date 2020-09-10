package com.example.lab1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val HISTORY_KEY = "history"
    }

    private var mHistories: java.util.ArrayList<HistoryRecord>? = java.util.ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fr_main, FragmentLosing())
            .commit()
        createDrawer()
    }

    fun addToHistories(historyRecord: HistoryRecord) { mHistories?.add(historyRecord) }

    // создание Drawer для toolbar, использована библиотека mikepenz/MaterialDrawer
    private fun createDrawer() {
        DrawerBuilder()
            .withActivity(this) // привязываем к этой активности
            .withToolbar(toolbar) // привязываем к тулбару
            .withActionBarDrawerToggle(true) // добавляем toggle
            .withSelectedItem(-1) // не выбираем начальный элемент
            .addDrawerItems( // добавляем пункты меню
                PrimaryDrawerItem()
                    .withIdentifier(0)
                    .withName(getString(R.string.ToolBarLose)),
                PrimaryDrawerItem()
                    .withIdentifier(1)
                    .withName(getString(R.string.ToolBarMaintain)),
                PrimaryDrawerItem()
                    .withIdentifier(2)
                    .withName(getString(R.string.ToolbarGain)),
                PrimaryDrawerItem()
                    .withIdentifier(3)
                    .withName(getString(R.string.HistoryCalculate))
            )
            .withOnDrawerItemClickListener(object: Drawer.OnDrawerItemClickListener { // создаем слушателя для пунктов меню
                override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*>): Boolean {
                        when (position) {
                        0 -> {
                            supportFragmentManager
                                .beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.fr_main, FragmentLosing())
                                .commit()
                        }
                        1 -> {
                            supportFragmentManager
                                .beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.fr_main, FragmentMaintaining())
                                .commit()
                        }
                        2 -> {
                            supportFragmentManager
                                .beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.fr_main, FragmentGaining())
                                .commit()
                        }
                        3 -> {
                            val intent = Intent(applicationContext, HistoryActivity::class.java)
                            intent.putExtra(HISTORY_KEY, mHistories)
                            startActivity(intent)
                        }
                    }
                    return false
                }})
            .build()
    }
}
