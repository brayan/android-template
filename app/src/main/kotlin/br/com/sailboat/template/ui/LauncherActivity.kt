package br.com.sailboat.template.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.sailboat.template.ui.entity.list.EntityListActivity

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EntityListActivity.start(this)
        finish()
    }

}