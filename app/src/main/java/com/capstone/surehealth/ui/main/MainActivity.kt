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
import com.capstone.surehealth.R
import com.capstone.surehealth.data.model.User
import com.capstone.surehealth.data.model.UserPreferences
import com.capstone.surehealth.data.response.Data
import com.capstone.surehealth.data.response.RegisterResponse
import com.capstone.surehealth.databinding.ActivityMainBinding
import com.capstone.surehealth.ui.history.HistoryActivity
import com.capstone.surehealth.ui.login.OnboardingActivity
import com.capstone.surehealth.ui.profile.EditProfileActivity
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

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        binding.homeActivity.btnNavigation.setOnClickListener {
            drawerLayout.openDrawer(navView)
        }

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_tes, R.id.nav_riwayat
            ), drawerLayout
        )

        binding.navKeluar.setOnClickListener {
            logout()
        }

        getName(data)

        binding.homeActivity.cvTes.setOnClickListener{
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        binding.homeActivity.cvRiwayat.setOnClickListener{
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        binding.homeActivity.btnEditProfil.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            intent.putExtra(EditProfileActivity.EXTRA_USERNAME, data.username)
            startActivity(intent)
        }
    }


    private fun logout() {
        userModel.id_user = ""
        userPreferences.setUsers(userModel)
//        startActivity(Intent(this, OnboardingActivity::class.java)
    }

    private fun getName(data: Data) {
        binding.apply {
            homeActivity.tvNama.text = data.username
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_navigation)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
}