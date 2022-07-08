package com.example.study.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.study.R
import com.example.study.databinding.ActivityMain2Binding
import com.example.study.databinding.ActivityMainBinding
import com.example.study.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain2Binding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** data binding **/
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java) //해당 viewModel의 owner를 mainActivity로 설정
        // 위 코드는 viewModel : MainViewModel by viewModels()로 대체 가능!
        val b = DataBindingUtil.setContentView<ActivityMain2Binding>(this, R.layout.activity_main2) // layout 이름에 따라 바뀜
        b.data = viewModel //layout 안에 있는 viewModel 변수를 viewModel과 바인딩!
        b.lifecycleOwner = this

        /** view binding
        binding = ActivityMain2Binding.inflate(layoutInflater)//액티에서 사용할 바인딩 클래스의 인스턴스 생성
        setContentView(binding.root)//view binding, root:레이아웃 내부의 최상위 위치 뷰의 인스턴스 활용용
       //id 접근 시 binding.[id] 사용**/
//
//        setSupportActionBar(binding.toolbar)
//
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}