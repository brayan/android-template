package br.com.sailboat.template.entitymvp.insert

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import br.com.sailboat.template.base.BaseActivity
import br.com.sailboat.template.helper.Extras
import br.com.sailboat.template.helper.RequestCode

class EntityInsertActivity : BaseActivity() {

    private lateinit var fragment: EntityInsertFragment

    companion object {
        fun startFrom(fragment: Fragment) {
            val intent = Intent(fragment.activity, EntityInsertActivity::class.java)
            fragment.startActivityForResult(intent, RequestCode.ENTITY_INSERT.ordinal)
        }

        fun startEdit(fragment: Fragment, productId: Long) {
            val intent = Intent(fragment.activity, EntityInsertActivity::class.java)
            val args = Bundle()
            Extras.putEntityId(args, productId)
            Extras.putBundle(intent, args)

            fragment.startActivityForResult(intent, RequestCode.ENTITY_INSERT.ordinal)
        }
    }

    override fun newFragmentInstance() = EntityInsertFragment().also {
        it.arguments = Extras.getBundle(intent)
        fragment = it
    }

    override fun onBackPressed() {
        fragment.onBackPressed()
    }

}