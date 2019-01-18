package br.com.sailboat.template.ui.entity_mvvm

import android.content.Context
import android.content.Intent
import br.com.sailboat.template.ui.base.BaseActivity

class EntityMvvmListActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, EntityMvvmListActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun newFragmentInstance() = EntityMvvmListFragment.newInstance()

}