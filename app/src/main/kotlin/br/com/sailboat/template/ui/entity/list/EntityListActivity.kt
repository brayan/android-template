package br.com.sailboat.template.ui.entity.list

import android.content.Context
import android.content.Intent
import br.com.sailboat.template.ui.base.BaseActivity

class EntityListActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, EntityListActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun newFragmentInstance() = EntityListFragment.newInstance()

}