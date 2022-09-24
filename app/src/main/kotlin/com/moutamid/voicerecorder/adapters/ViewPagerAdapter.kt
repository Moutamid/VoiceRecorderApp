package com.moutamid.voicerecorder.adapters

import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.moutamid.voicerecorder.activities.SimpleActivity
import com.moutamid.voicerecorder.fragments.MyViewPagerFragment
import com.moutamid.voicerecorder.fragments.PlayerFragment
import com.simplemobiletools.voicerecorder.R

class ViewPagerAdapter(private val activity: SimpleActivity) : PagerAdapter() {
    private val mFragments = SparseArray<MyViewPagerFragment>()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layout = if (position == 0) R.layout.fragment_recorder else R.layout.fragment_player
        val view = activity.layoutInflater.inflate(layout, container, false)
        container.addView(view)

        mFragments.put(position, view as MyViewPagerFragment)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, item: Any) {
        container.removeView(item as View)
    }

    override fun getCount() = 2

    override fun isViewFromObject(view: View, item: Any) = view == item

    fun onResume() {
        for (i in 0 until mFragments.size()) {
            mFragments[i].onResume()
        }
    }

    fun onDestroy() {
        for (i in 0 until mFragments.size()) {
            mFragments[i].onDestroy()
        }
    }

    fun finishActMode() = (mFragments[1] as? PlayerFragment)?.finishActMode()
}
