package com.capstone.surehealth.ui.main

import android.os.Bundle
import android.view.Menu
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.capstone.surehealth.R
import com.capstone.surehealth.databinding.ActivityMainBinding
import com.capstone.surehealth.ui.history.HistoryActivity
import com.capstone.surehealth.ui.login.OnboardingActivity
import com.capstone.surehealth.ui.quiz.QuizActivity

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var userModel: User
    private lateinit var userPreferences: UserPreferences
    private lateinit var data: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.homeActivity.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
//        val navController = findNavController(R.id.nav_host_fragment_content_navigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        binding.homeActivity.btnNavigation.setOnClickListener {
            drawerLayout.openDrawer(navView)
        }

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )

        binding.navKeluar.setOnClickListener {
            logout()
        }

        binding.homeActivity.cvTes.setOnClickListener{
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        binding.homeActivity.cvRiwayat.setOnClickListener{
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }

    private fun logout() {
        userModel.id_user = ""
        userPreferences.setUsers(userModel)
        startActivity(Intent(this, OnboardingActivity::class.java)


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_navigation)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
}