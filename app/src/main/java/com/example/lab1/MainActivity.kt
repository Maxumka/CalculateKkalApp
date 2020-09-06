package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
                    .withName("Сброс веса"),
                PrimaryDrawerItem()
                    .withIdentifier(1)
                    .withName("Поддержание веса"),
                PrimaryDrawerItem()
                    .withIdentifier(2)
                    .withName("Набор веса")
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
                    }
                    return false
                }})
            .build()
    }
}
