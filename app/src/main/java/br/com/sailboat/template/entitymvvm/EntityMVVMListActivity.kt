package br.com.sailboat.template.entitymvvm

import android.content.Context
import android.content.Intent
import br.com.sailboat.template.base.BaseActivity

class EntityMVVMListActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, EntityMVVMListActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun newFragmentInstance() = EntityMVVMListFragment.newInstance()

}