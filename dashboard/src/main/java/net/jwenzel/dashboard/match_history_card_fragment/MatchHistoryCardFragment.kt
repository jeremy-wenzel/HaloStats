package net.jwenzel.dashboard.match_history_card_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import net.jeremywenzel.halostats.core.haloapi.GameBaseVariant
import net.jeremywenzel.halostats.core.haloapi.MatchHistoryItem
import net.jeremywenzel.halostats.core.haloapi.MultiplayerMap
import net.jeremywenzel.halostats.core.util.Duration
import net.jwenzel.dashboard.R
import net.jwenzel.dashboard.dashboard.DashboardCardFragment

class MatchHistoryCardFragment: DashboardCardFragment<MatchHistoryCardView, MatchHistoryCardPresenter>(), MatchHistoryCardView {

    private lateinit var mapImageView: ImageView
    private lateinit var mapNameTextView: TextView
    private lateinit var gameTypeNameTextView: TextView
    private lateinit var gameTimeTextView: TextView

    override fun getCardLayoutId(): Int = R.layout.match_history_card_fragment

    override fun getCardTitleId(): Int = R.string.match_history_card_title

    override fun createPresenter(): MatchHistoryCardPresenter = MatchHistoryCardPresenterImpl(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)!!
        mapImageView = view.findViewById(R.id.match_history_map_image)
        mapNameTextView = view.findViewById(R.id.match_history_map_name)
        gameTypeNameTextView = view.findViewById(R.id.match_history_game_type)
        gameTimeTextView = view.findViewById(R.id.match_history_game_time)
        return view
    }

    override fun showCard(matchHistoryItem: MatchHistoryItem, multiplayerMap: MultiplayerMap, gameBaseVariant: GameBaseVariant) {
        Glide.with(this).load(multiplayerMap.imageUrl).centerCrop().into(mapImageView)
        mapNameTextView.text = multiplayerMap.name
        gameTypeNameTextView.text = gameBaseVariant.name
        val duration = Duration.fromIsoString(matchHistoryItem.matchDuration)
        gameTimeTextView.text = java.lang.String.format("%d:%02d", duration.minutes, duration.seconds)
    }
}