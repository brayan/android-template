package br.com.sailboat.template.entitymvp.details

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import br.com.sailboat.template.base.BaseActivity
import br.com.sailboat.template.helper.Extras
import br.com.sailboat.template.helper.RequestCode

class EntityDetailsActivity  : BaseActivity() {

    companion object {
        fun startFrom(fragment: Fragment, entityId: Long) {
            val intent = Intent(fragment.activity, EntityDetailsActivity::class.java)
            val args = Bundle()

            Extras.putEntityId(args, entityId)
            Extras.putBundle(intent, args)

            fragment.startActivityForResult(intent, RequestCode.ENTITY_DETAILS.ordinal)
        }
    }

    override fun newFragmentInstance() = EntityDetailsFragment().also { it.arguments = Extras.getBundle(intent) }

}
