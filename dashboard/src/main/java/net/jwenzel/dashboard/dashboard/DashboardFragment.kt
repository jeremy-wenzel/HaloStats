package net.jwenzel.dashboard.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import net.jeremywenzel.halostats.core.haloapi.GamerTag
import net.jeremywenzel.halostats.core.haloapi.PlayerAppearance
import net.jeremywenzel.halostats.webapi.requests.PlayerEmblemRequest
import net.jwenzel.coremvp.fragment.BaseMvpFragment
import net.jwenzel.dashboard.arena_card_fragment.ArenaCardFragment
import net.jwenzel.dashboard.R
import net.jwenzel.dashboard.match_history_card_fragment.MatchHistoryCardFragment
import net.jwenzel.dashboard.medals_fragment.MedalsCardFragment

class DashboardFragment: BaseMvpFragment<DashboardView, DashboardPresenter>(), DashboardView {
    private val gamerTag = GamerTag("English Crusade")

    private lateinit var gamerTagTextView: TextView
    private lateinit var gamerTagCompanyTextView: TextView
    private lateinit var gamerTagProfileImage: ImageView

    override fun createPresenter(): DashboardPresenter = DashboardPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.beginTransaction().add(R.id.card_layout, ArenaCardFragment()).commit()
        childFragmentManager.beginTransaction().add(R.id.card_layout, MatchHistoryCardFragment()).commit()
        childFragmentManager.beginTransaction().add(R.id.card_layout, MedalsCardFragment()).commit()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.dashboard_fragment, container, false)
        gamerTagTextView = view.findViewById(R.id.dashboard_gamertag)
        gamerTagCompanyTextView = view.findViewById(R.id.dashboard_company)
        gamerTagProfileImage = view.findViewById(R.id.dashboard_profile_image)
        return view
    }

    override fun showPlayerAppearance(playerAppearance: PlayerAppearance) {
        Glide.with(this).load(getGlideUrlForEmblem()).centerCrop().into(gamerTagProfileImage)
        gamerTagTextView.text = playerAppearance.gamerTag
        if (playerAppearance.company.name.isNotEmpty()) {
            gamerTagCompanyTextView.visibility = View.VISIBLE
            gamerTagCompanyTextView.text = playerAppearance.company.name
        }
        else {
            gamerTagCompanyTextView.visibility = View.GONE
        }
    }

    private fun getGlideUrlForEmblem(): GlideUrl {
        val playerRequest = PlayerEmblemRequest(gamerTag, 512)
        val lazyHeaders = LazyHeaders.Builder().addHeader(playerRequest.getKeyHeader(), playerRequest.getHeaderValue()).build()
        return GlideUrl(playerRequest.getRequestUrl(), lazyHeaders)
    }
}