package br.com.sailboat.template

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.sailboat.template.entitymvvm.EntityMVVMListActivity

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EntityMVVMListActivity.start(this)
        finish()
    }

}