package com.capstone.surehealth.ui.main

import android.content.Intent
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
import androidx.cardview.widget.CardView
import androidx.lifecycle.viewModelScope
import com.capstone.surehealth.R
import com.capstone.surehealth.data.model.User
import com.capstone.surehealth.data.model.UserPreference
import com.capstone.surehealth.databinding.ActivityMainBinding
import com.capstone.surehealth.ui.history.HistoryActivity
import com.capstone.surehealth.ui.login.OnboardingActivity
import com.capstone.surehealth.ui.quiz.QuizActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var userPreference: UserPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.appBarNavigation.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_tes, R.id.nav_riwayat
            ), drawerLayout
        )

        binding.navKeluar.setOnClickListener {
            startActivity(Intent(this, OnboardingActivity::class.java))
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



//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_navigation)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }

   private fun logout() = CoroutineScope(Dispatchers.Main).launch{
        userPreference.logouttoken()
    }



}