package com.example.lab1.view

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import com.example.lab1.R
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

        // выбираю цвет тулбара в зависимости от настроек
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val color = when(pref.getString("toolbar_color", "")) {
            "Red" -> Color.RED
            "Green" -> Color.GREEN
            "Blue" -> Color.BLUE
            else -> Color.CYAN
        }
        toolbar.setBackgroundColor(color)

        // Запрос на использование Google Fit API
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACTIVITY_RECOGNITION)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACTIVITY_RECOGNITION), 1)
        }
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
                    .withName(getString(R.string.ToolBarLose)),
                PrimaryDrawerItem()
                    .withIdentifier(1)
                    .withName(getString(R.string.ToolBarMaintain)),
                PrimaryDrawerItem()
                    .withIdentifier(2)
                    .withName(getString(R.string.ToolbarGain)),
                PrimaryDrawerItem()
                    .withIdentifier(3)
                    .withName(getString(R.string.HistoryCalculate)),
                PrimaryDrawerItem()
                    .withIdentifier(4)
                    .withName(getString(R.string.TextViewStepCount)),
                PrimaryDrawerItem()
                    .withIdentifier(5)
                    .withName("Больше о методе расчета калорий"),
                PrimaryDrawerItem()
                    .withIdentifier(6)
                    .withName("История расчетов из БД"),
                PrimaryDrawerItem()
                    .withIdentifier(7)
                    .withName("История работы службы из файла"),
                PrimaryDrawerItem()
                    .withIdentifier(8)
                    .withName("Настройки"),
                PrimaryDrawerItem()
                    .withIdentifier(9)
                    .withName("Анимации")
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
                            startActivity(intent)
                        }
                        4 -> {
                            supportFragmentManager
                                .beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.fr_main, FragmentStepCounter())
                                .commit()
                        }
                        5 -> {
                            supportFragmentManager
                                .beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.fr_main, FragmentBrowserCall())
                                .commit()
                        }
                        6 -> {
                            supportFragmentManager
                                .beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.fr_main, FragmentDb())
                                .commit()
                        }
                        7 -> {
                            supportFragmentManager
                                .beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.fr_main, FragmentFileService())
                                .commit()
                        }
                        8 -> {
                            supportFragmentManager
                                .beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.fr_main, FragmentSettings())
                                .commit()
                        }
                        9 -> {
                            supportFragmentManager
                                .beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.fr_main, FragmentAnimation())
                                .commit()
                        }
                    }
                    return false
                }})
            .build()
    }
}
